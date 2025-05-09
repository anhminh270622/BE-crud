package com.example.demo.service;

import com.example.demo.dto.request.ContactCreationRequest;
import com.example.demo.dto.response.ContactResponse;
import com.example.demo.entity.Contact;
import com.example.demo.mapper.ContactMapper;
import com.example.demo.repository.ContactRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ContactService {
    ContactRepository contactRepository;
    ContactMapper contactMapper;

    public ContactResponse createContact(ContactCreationRequest request) {
        Contact contact = contactMapper.toContact(request);
        return contactMapper.toContactResponse(contactRepository.save(contact));
    }

    public List<ContactResponse> getAllContacts() {
        return contactMapper.toContactResponseList(contactRepository.findAll());
    }
}
