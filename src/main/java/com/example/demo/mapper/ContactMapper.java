package com.example.demo.mapper;

import com.example.demo.dto.request.ContactCreationRequest;
import com.example.demo.dto.response.ContactResponse;
import com.example.demo.entity.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toContact(ContactCreationRequest contactCreationRequest);

    ContactResponse toContactResponse(Contact contact);

    java.util.List<ContactResponse> toContactResponseList(java.util.List<Contact> contacts);
}
