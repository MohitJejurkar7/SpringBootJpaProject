package com.example.tech;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @Column(name = "lead_id")
    private Integer leadId;

    @Column(name = "first_name", nullable = false)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should contain only alphabets")
    private String firstName;

    @Column(name = "middle_name")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Middle name should contain only alphabets")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should contain only alphabets")
    private String lastName;

    @Column(name = "mobile_number", nullable = false)
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number should start with digit 6 to 9")
    private String mobileNumber;

    @Column(name = "gender", nullable = false)
    @Pattern(regexp = "^(Male|Female|Others)$", message = "Gender should be Male, Female, or Others")
    private String gender;

    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "dob", columnDefinition = "DATE")
    private LocalDate dob;

    @Column(name = "email", nullable = false)
    @Email(message = "Invalid email format")
    private String email;


}