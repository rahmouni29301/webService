package com.esprit.microservice.contact.service;

import com.esprit.microservice.contact.entity.Contact;
import com.esprit.microservice.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact updateContact(Long id, Contact contactDetails) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact != null) {
            contact.setNom(contactDetails.getNom());
            contact.setEmail(contactDetails.getEmail());
            contact.setTelephone(contactDetails.getTelephone());
            return contactRepository.save(contact);  // Sauvegarde des modifications
        }
        return null;
    }
}
