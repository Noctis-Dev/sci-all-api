package com.sci_all.demo.service.impl;

import com.sci_all.demo.configuration.security.jwt.JwtConfig;
import com.sci_all.demo.configuration.security.user.UserDetailsImpl;
import com.sci_all.demo.configuration.security.user.UserDetailsServiceImpl;
import com.sci_all.demo.service.IJwtService;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.response.JwtResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.sql.Date;

@Service
public class JwtServiceImpl implements IJwtService {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private SecretKey secretKey;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public BaseResponse refreshToken(String refreshToken) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(refreshToken)
                .getBody();
        String email = claims.getSubject();

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(email);

        Date expirationDate = jwtConfig.getExpirationDate();
        String token = Jwts.builder()
                .setSubject(userDetails.getName())
                .claim("authorities", userDetails.getAuthorities())
                .setIssuedAt(new java.util.Date())
                .setExpiration(expirationDate)
                .signWith(secretKey).compact();

        Date refreshExpirationDate = jwtConfig.getRefreshExpirationDate();
        String newRefreshToken = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new java.util.Date())
                .setExpiration(refreshExpirationDate)
                .signWith(secretKey).compact();

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setAccessToken(token);
        jwtResponse.setRefreshToken(newRefreshToken);

        return BaseResponse.builder()
                .data(jwtResponse)
                .message("Successfully authenticated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }
}
