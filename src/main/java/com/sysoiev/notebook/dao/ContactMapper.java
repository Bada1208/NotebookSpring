package com.sysoiev.notebook.dao;

import com.sysoiev.notebook.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setPhoneNumber(rs.getString("id"));
        contact.setName(rs.getString("name"));
        contact.setAge(rs.getInt("age"));

        return contact;
    }
}
