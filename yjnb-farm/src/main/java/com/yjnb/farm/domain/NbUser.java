package com.yjnb.farm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class NbUser {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    private String userNickname;
    private String userName;
    private String userPassword;
    private String userPhone;
}
