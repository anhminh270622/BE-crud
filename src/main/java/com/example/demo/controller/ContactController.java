package com.example.demo.controller;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.ContactCreationRequest;
import com.example.demo.dto.response.ContactResponse;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping()
    ApiResponse<ContactResponse> addContact(@RequestBody ContactCreationRequest request) {
        ApiResponse<ContactResponse> response = new ApiResponse<>();
        ContactResponse contact = contactService.createContact(request);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(contact);
        return response;
    }

    @GetMapping()
    ApiResponse<List<ContactResponse>> getAllContacts() {
        ApiResponse<List<ContactResponse>> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(contactService.getAllContacts());
        response.setTotalRecords(
                contactService.getAllContacts().size()
        );
        return response;
    }

}
