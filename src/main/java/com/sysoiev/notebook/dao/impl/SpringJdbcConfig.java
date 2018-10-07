package com.sysoiev.notebook.dao.impl;

import com.sysoiev.notebook.dao.ContactDao;
import com.sysoiev.notebook.model.Contact;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component("splitter")
public class SpringJdbcConfig implements ContactDao {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveContact(Contact contact) {
        /*this.jdbcTemplate.update(
                "INSERT INTO CLIENT VALUES (?, ?, ?, ?)");
        final int update = jdbcTemplate.update();*/
    }

    @Override
    public void removeContact(String surname) {

    }

    @Override
    public void updateContact(String oldSurname, Contact contact) {

    }


    @Override
    public List<Contact> showAll() {
        final List<Contact> contacts = new ArrayList<>();
        return contacts;
    }
}
