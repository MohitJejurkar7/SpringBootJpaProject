package com.example.tech;

import jakarta.persistence.ConstructorResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
@Data
public class LeadResponse {

    private Integer leadId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String gender;
    private LocalDate dob;
    private String email;

    public LeadResponse(Integer leadId,String firstName, String middleName,String lastName, String mobileNumber, String gender, LocalDate dob, String email){
        this.leadId=leadId;
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
        this.mobileNumber=mobileNumber;
        this.gender=gender;
        this.dob=dob;
        this.email=email;
    }

}
