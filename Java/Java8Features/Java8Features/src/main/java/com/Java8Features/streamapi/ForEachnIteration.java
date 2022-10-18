package com.Java8Features.streamapi;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ForEachnIteration {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Chips");
        list.add("Potato");
        list.add("Pott");
        list.add("POTT");

        for (String s:list) {
            log.info(s);
        }

        list.stream().forEach(t ->log.info("from stream "+t));

        list.stream().filter(t -> t.startsWith("p")).forEach(t->log.info("using filter "+t));


    }
}
