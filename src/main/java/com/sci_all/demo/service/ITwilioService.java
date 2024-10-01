package com.sci_all.demo.service;

public interface ITwilioService {

    void sendVerificationCode(String phoneNumber, String code);

}
