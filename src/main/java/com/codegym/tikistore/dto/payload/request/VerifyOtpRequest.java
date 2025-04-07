package com.codegym.tikistore.dto.payload.request;

import lombok.Data;

/**
 * @author ADMIN
 */
@Data
public class VerifyOtpRequest {
    private String email;
    private String otp;
    private String newPassword;
}
