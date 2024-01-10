package com.example.tech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeadService {

    @Autowired
    private LeadRepo leadRepository;

    public ResponseEntity<?> createLead(Lead lead) {
        Optional<Lead>  existingLead = leadRepository.findById(lead.getLeadId());
        if (existingLead.isPresent()) {
            ErrorResponseDetail errorResponseDetail = new ErrorResponseDetail("E10010",
                    List.of("Lead Already Exists in the database with the lead id"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("error", errorResponseDetail));
        } else {
            leadRepository.save(lead);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new SuccessResponse("200","Created Leads Successfully"));
        }
    }

    public ResponseEntity<?> fetchLead(String mobNo) {
        List<Lead> existingLead = leadRepository.findByMobileNumber(mobNo);

        if (existingLead.isEmpty()) {
            ErrorResponseDetail errorResponseDetail = new ErrorResponseDetail("E10011",
                    List.of("No Lead found with the Mobile Number"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("error", errorResponseDetail));
        } else {

            List<LeadResponse> leadResponses = existingLead.stream()
                    .map(this::mapLeadEntityToLeadResponse)
                    .collect(Collectors.toList());

            LeadListResponse leadListResponse = new LeadListResponse("success", leadResponses);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(leadListResponse);

        }
    }
    private LeadResponse mapLeadEntityToLeadResponse(Lead lead) {
        return new LeadResponse(
                lead.getLeadId(),
                lead.getFirstName(),
                lead.getMiddleName(),
                lead.getLastName(),
                lead.getMobileNumber(),
                lead.getGender(),
                lead.getDob(),
                lead.getEmail()
        );
    }

}