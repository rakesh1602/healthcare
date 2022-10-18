package com.Java8Features.lamdaExpression;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class implementLambda {
    public static void main(String[] args) {
        Lambda lambda = () -> {
            log.info("Switch on from lambda");
        };
        lambda.switchOn();


        Withinput withinput = (input, input2) -> log.info("sum is :" + input + input2);
        withinput.sum(44, 44);


        withReturn withReturn = (i1, i2) ->i1 * i2;
        log.info(withReturn.multiply(33, 33));
    }
}
