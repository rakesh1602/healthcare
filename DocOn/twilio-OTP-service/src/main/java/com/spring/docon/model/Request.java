package com.spring.docon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private String phoneNumber;

    private String userName;

    private String oneTimePassword;

    private String to;

}
