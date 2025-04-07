package com.codegym.tikistore.service;

import com.codegym.tikistore.dto.payload.request.SendOtpRequest;

/**
 * @author ADMIN
 */
public interface EmailService {
    void sendOtp(SendOtpRequest sendOtpRequest);


}
