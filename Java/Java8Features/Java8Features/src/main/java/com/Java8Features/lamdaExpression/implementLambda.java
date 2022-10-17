package com.Java8Features.features;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class implementLambda {
    public static void main(String[] args) {
        Lambda lambda = ()-> {
            log.info("Switch on from lambda");
        };
        lambda.switchOn();
    }

}
