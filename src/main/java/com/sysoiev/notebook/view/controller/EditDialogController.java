package com.sysoiev.notebook.view.controller;

import com.sysoiev.notebook.model.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditDialogController implements Initializable {

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtAge;
    private Contact contact;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void setPerson(Contact contact) {
        if (contact == null) {
            return;
        }
        this.contact = contact;
        txtSurname.setText(contact.getSurname());
        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhoneNumber());
        txtAge.setText(String.valueOf(contact.getAge()));
    }

    public void actionSave(ActionEvent actionEvent) {
        contact.setPhoneNumber(txtPhone.getText());
        contact.setSurname(txtSurname.getText());
        contact.setName(txtName.getText());
        contact.setAge(Integer.parseInt(txtAge.getText()));
        actionClose(actionEvent);
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
