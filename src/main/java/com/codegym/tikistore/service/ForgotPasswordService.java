package com.codegym.tikistore.service;

import com.codegym.tikistore.dto.payload.request.SendMailRequest;
import com.codegym.tikistore.dto.payload.request.VerifyOtpRequest;

/**
 * @author ADMIN
 */
public interface ForgotPasswordService {

    void sendOtpAndSaveToDatabase(SendMailRequest sendMailRequest);

    void verifyOtpAndResetPassword(VerifyOtpRequest verifyOtpRequest);
}
