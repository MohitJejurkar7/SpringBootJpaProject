package com.example.tech;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LeadController {

    @Autowired
    private LeadService leadService;

    @Autowired
    private LeadRepo leadRepo;

    @PostMapping("/create")
    public ResponseEntity<?> createLead(@RequestBody @Valid Lead lead , BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());

            ErrorResponseDetail errorResponseDetail = new ErrorResponseDetail("E10001", errorMessages);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("error", errorResponseDetail));
        }
        return leadService.createLead(lead);
    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetchLead(@RequestBody @Valid FetchMobileNumber lead , BindingResult result)
    {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());

            ErrorResponseDetail errorResponseDetail = new ErrorResponseDetail("E10001", errorMessages);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("error", errorResponseDetail));
        }
        return leadService.fetchLead(lead.getMobileNumber());

    }
}
