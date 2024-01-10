package com.example.tech;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponseDetail {
    private String code;
    private List<String> messages;

    public  ErrorResponseDetail(String code,List<String> msg){
        this.code=code;
        this.messages=msg;
    }
}
