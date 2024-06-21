package com.backend.tripmate.IAM.domain.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshToken {
    private String token;
    private String userId;
    private long expiryDate;
}