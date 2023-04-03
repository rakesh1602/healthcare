package com.examserver.service;

import com.examserver.entity.RoleEntity;
import com.examserver.entity.UserEntity;
import com.examserver.mapper.RoleMapper;
import com.examserver.mapper.UserMapper;
import com.examserver.model.User;
import com.examserver.repository.UserRepository;
import com.examserver.response.UserResponse;
import com.examserver.utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Log4j2
public class UserService {
    private final RoleMapper roleMapper;

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User user = new User();
    public RoleEntity roleEntity = new RoleEntity();

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper,
                       RoleMapper roleMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    public UserResponse addUser(User user) {

        log.info("Adding users.");
        UserEntity userEntity = userMapper.modelToEntity(user);
        userRepository.save(userEntity).getRoleEntitySet();
        log.info("User details saved successfully.");

        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userEntity.getUserId());
        return userResponse;
    }

    public User getUser(Long userID) {
        log.info("Retrieving users from database");
        UserEntity userEntity = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException(Constants.USER_ID_NOT_FOUND));

        user = userMapper.entityToModel(userEntity);
        log.info("User details retrieved successfully.");

        return user;
    }

    public User updateUser(Long userID, User user) {
        log.info("Retrieving users from database");
        UserEntity userEntity = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException(Constants.USER_ID_NOT_FOUND));

        Long userid = userEntity.getUserId();
        Long roleid = roleEntity.getRoleId();

        userEntity = userMapper.modelToEntity(user);
        userRepository.save(userEntity);
        log.info("User details updated successfully.");
        return user;
    }

    public void deleteUser(Long userID) {
        userRepository.deleteById(userID);
        log.info("Deleting user of id {} ", userID);
    }
}
