package com.sysoiev.notebook.dao.impl;

import com.sysoiev.notebook.dao.ContactDao;
import com.sysoiev.notebook.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystemContactDaoImpl implements ContactDao {

    /**
     * Сервис работы с файловой системой. Преобразует модели в/из данные хранимые на жестком диске.
     */

    private static final File FILE = new File("data");
    private List<Contact> currentContact = new ArrayList<>();

    @Override
    public void saveContact(Contact contact) {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE, true)))) {
            writer.println(contact);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact(String surname) {
        for (int i = 0; i < currentContact.size(); i++) {
            Contact removeContact = currentContact.get(i);
            if (removeContact.getSurname().equals(surname)) {
                currentContact.remove(i);
            }
        }

    }

    @Override
    public void updateContact(String oldSurname, Contact contact) {

    }

    @Override
    public List<Contact> showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
