package com.example.tech;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class FetchMobileNumber {

    @Column(name = "mobile_number", nullable = false)
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number should start with digit 6 to 9")
    private String mobileNumber;
}
