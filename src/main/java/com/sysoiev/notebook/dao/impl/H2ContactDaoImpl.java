package com.sysoiev.notebook.dao.impl;

import com.sysoiev.notebook.dao.ContactDao;
import com.sysoiev.notebook.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.h2.tools.DeleteDbFiles;

public class H2ContactDaoImpl implements ContactDao {

    private static final String USER = "sa";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String PASSWORD = "";

    private int counter = 0;

    public H2ContactDaoImpl() {
        DeleteDbFiles.execute("~", "test", true);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            st.execute("CREATE TABLE CLIENT(ID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "   SURNAME VARCHAR(255),NAME VARCHAR(255),PHONENUMBER VARCHAR(255),AGE INTEGER);");
        } catch (SQLException e) {
            System.err.println("Something went wrong while initialisation " + e);
        }
    }

    @Override
    public void saveContact(Contact contact) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection.prepareStatement("INSERT INTO CLIENT VALUES(?, ?, ?, ?, ?);")) {

            st.setInt(1, counter++);
            st.setString(2, contact.getSurname());
            st.setString(3, contact.getName());
            st.setString(4, contact.getPhoneNumber());
            st.setInt(5, contact.getAge());

            st.execute();
        } catch (SQLException e) {
            System.err.println("Something went wrong when saving contact " + e);
        }

    }

    @Override
    public void updateContact(String oldSurname, Contact contact) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection
                     .prepareStatement("UPDATE CLIENT SET SURNAME=?, NAME=?, PHONENUMBER=?, AGE=? WHERE SURNAME=?")) {

            st.setString(1, contact.getSurname());
            st.setString(2, contact.getName());
            st.setString(3, contact.getPhoneNumber());
            st.setInt(4, contact.getAge());
            st.setString(5, oldSurname);

            st.execute();
        } catch (SQLException e) {
            System.err.println("Something went wrong when updating contact " + e);
        }

    }

    @Override
    public void removeContact(String surname) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection.prepareStatement("DELETE FROM CLIENT WHERE SURNAME=?;")) {

            st.setString(1, surname);
            st.execute();
        } catch (SQLException e) {
            System.err.println("Something went wrong when removing contact" + e);
        }
    }

    @Override
    public List<Contact> showAll() {
        final List<Contact> contacts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT ORDER BY ID")) {

            while (resultSet.next()){
                final String surname = resultSet.getString("SURNAME");
                final String name = resultSet.getString("NAME");
                final String phoneNumber = resultSet.getString("PHONENUMBER");
                final Integer age = resultSet.getInt("AGE");
                contacts.add(new Contact(surname, name, phoneNumber, age));
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong when selecting all clients " + e);
        }
        return contacts;
    }
}
