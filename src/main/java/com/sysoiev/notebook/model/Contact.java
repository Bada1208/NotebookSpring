package com.sysoiev.notebook.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Contact {

    /**
     * Класс модель.
     * Этот класс представляет основные сущности и хранимый тип данных.
     * Это логические сущности которые управляются слоем сервисов бизнес логики.
     */

    private SimpleStringProperty surname ;
    private SimpleStringProperty name;
    private SimpleStringProperty phoneNumber;
    private SimpleIntegerProperty age;

    public Contact(){

    }

    public Contact(String surname, String name, String phoneNumber, int age) {
        this.surname = new SimpleStringProperty(surname);
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.age = new SimpleIntegerProperty(age);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty phoneProperty() {
        return phoneNumber;
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return age == contact.age &&
                Objects.equals(surname, contact.surname) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(surname, name, phoneNumber, age);
    }

    @Override
    public String toString() {
        return "Contact:" + '\n' +
                "surname = " + surname + '\n' +
                "name = " + name + '\n' +
                "phone number = " + phoneNumber + '\n' +
                "age = " + age;
    }

}
