package com.sci_all.demo.service.impl;

import com.sci_all.demo.configuration.twilio.TwilioConfig;
import com.sci_all.demo.service.ITwilioService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioServiceImpl implements ITwilioService {

    @Autowired
    private TwilioConfig config;

    @Override
    public void sendVerificationCode(String phoneNumber, String code) {
        Twilio.init(config.getAccountSid(), config.getAuthToken());
        Message.creator(new PhoneNumber(phoneNumber), config.getMessagingServiceSid(), code).create();
    }
}
