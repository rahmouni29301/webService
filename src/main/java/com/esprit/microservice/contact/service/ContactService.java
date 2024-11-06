package com.esprit.microservice.contact.service;

import com.esprit.microservice.contact.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact saveContact(Contact contact);
    void deleteContact(Long id);
    Contact updateContact(Long id, Contact contactDetails);
}
