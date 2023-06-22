package com.crossasyst.sqstodatabase.service;

import com.crossasyst.sqstodatabase.entity.MessageEntity;
import com.crossasyst.sqstodatabase.mapper.MessageMapper;
import com.crossasyst.sqstodatabase.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;

@Service
@Log4j2
public class CsvDataService {

    private final SqsClient sqsClient;

    private final MessageRepository messageRepository;

    private final ObjectMapper objectMapper;

    private final MessageMapper messageMapper;

    @Autowired
    public CsvDataService(SqsClient sqsClient, MessageRepository messageRepository, ObjectMapper objectMapper, MessageMapper messageMapper) {
        this.sqsClient = sqsClient;
        this.messageRepository = messageRepository;
        this.objectMapper = objectMapper;
        this.messageMapper = messageMapper;
    }

    @Value("${aws.sqsQueueUrl}")
    private String sqsQueueUrl;

    public void processCsvDataFromSqs() {
        String queueUrl = sqsQueueUrl;

        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10)
                .build();

        while (true) {
            // Receive messages from the SQS queue
            List<Message> messages = sqsClient.receiveMessage(request).messages();
            log.info("Messages received from AWS : {}", messages);

            if (messages.isEmpty()) {
                break; // No more messages in the queue, exit the loop
            }

            // Process each message
            for (Message message : messages) {
                try {

                    String string = message.body();
                    log.info("Message body: {}", string);

                    MessageEntity messageEntity = objectMapper.readValue(string, MessageEntity.class);
                    log.info("Data stored in the message entity using object mapper : {}", messageEntity.toString());
                    messageRepository.save(messageEntity);
                    log.info("Message Saved to database");

                } catch (Exception e) {
                    log.error("Failed to process message: {}", message.messageId(), e);
                }
            }
            // Check if all messages have been processed
            if (messages.size() < 10) {
                break; // All messages have been processed, exit the loop
            }
        }
    }

    public void processMessage(com.crossasyst.sqstodatabase.model.Message message) {
        log.info("Received Message : " + message);
    }
}
