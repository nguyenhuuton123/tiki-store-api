package com.codegym.tikistore.dto;

import com.codegym.tikistore.entitiy.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDTO {
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
}
