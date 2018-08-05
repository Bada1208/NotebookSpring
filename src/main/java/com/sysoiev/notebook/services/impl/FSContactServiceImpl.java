package com.sysoiev.notebook.services.impl;

import com.sysoiev.notebook.dao.ContactDao;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FSContactServiceImpl implements ContactService {
    /**
     * Реализация ContactService которая использует Файловую Систему для хранения данных.
     */

    private final ContactDao contactDao;

    ObservableList<Contact> list = FXCollections.observableArrayList();

    public FSContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public void createContact(String surName, String name, String phoneNumber, int age) {
        contactDao.saveContact(new Contact(surName, name, phoneNumber, age));
    }

    @Override
    public void deleteContact(String surName) {
        contactDao.removeContact(surName);
    }

    @Override
    public ObservableList<Contact> showAllContacts() {
        list.clear();
        list.addAll(contactDao.showAll());
        return list;


//        final List<Contact> contacts = contactDao.showAll();
//        for (Contact contact : contacts) {
//            System.out.println(contact);
//        }
    }

    public void editContact(String oldSurname, String newSurname, String newName, String newPhoneNumber, int newAge) {
        Contact contact = new Contact(newSurname, newName, newPhoneNumber, newAge);
        contactDao.updateContact(oldSurname, contact);
    }
}
