package com.example.tech;

import lombok.Data;

import java.util.List;

@Data
public class LeadListResponse {

    private String status;
    private List<LeadResponse> data;

    public LeadListResponse(String status, List<LeadResponse> data) {
        this.status = status;
        this.data = data;
    }

}
