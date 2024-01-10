package com.example.tech;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse {
    private String status;
    private String data;

    public SuccessResponse(String status,String data){
        this.status=status;
        this.data=data;
    }
}
