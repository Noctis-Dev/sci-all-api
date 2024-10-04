package com.sci_all.demo.service;

public interface VerificationCodeService {

    void sendVerificationCode(String phoneNumber, String code);

}
