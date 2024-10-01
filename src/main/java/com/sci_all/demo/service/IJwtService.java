package com.sci_all.demo.service;

import com.sci_all.demo.web.dto.BaseResponse;

public interface IJwtService {

    BaseResponse refreshToken(String refreshToken);

}
