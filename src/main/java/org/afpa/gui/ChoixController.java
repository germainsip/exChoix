package org.afpa.gui;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ChoixController {

    public TextField champAremplir;
    public Label textQuiChange;
    public JFXToggleButton fondButt;
    public JFXToggleButton textButt;
    public JFXToggleButton casseButt;
    public JFXRadioButton fondRed;
    public JFXRadioButton fondBlue;
    public JFXRadioButton fondGreen;
    public JFXRadioButton textRed;
    public JFXRadioButton textBlue;
    public JFXRadioButton textGreen;
    public JFXRadioButton casseMaj;
    public JFXRadioButton casseMin;
    public VBox choixBox;
    public HBox radioBox;
    public VBox radioTexte;
    public VBox radioCasse;
    public VBox radioFond;
    public String texte;

    public void afficheTexte(KeyEvent keyEvent) {

        texte = champAremplir.getText();
        textQuiChange.setText(texte);
        if (!texte.isEmpty()){
            choixBox.setVisible(true);
            radioBox.setVisible(true);
        } else {
            choixBox.setVisible(false);
            radioBox.setVisible(false);
        }
    }


    public void activeMenu(ActionEvent actionEvent) {
        radioFond.setDisable(!fondButt.isSelected());
        radioTexte.setDisable(!textButt.isSelected());
        radioCasse.setDisable(!casseButt.isSelected());
        String style = "";
        if (!radioFond.isDisable()) {
            if(fondRed.isSelected()) style += "-fx-background-color: red;";
            if(fondGreen.isSelected()) style += "-fx-background-color: green;";
            if(fondBlue.isSelected()) style += "-fx-background-color: blue;";
        }
        if (!radioTexte.isDisable()) {
            if(textRed.isSelected()) style += "-fx-text-fill: red;";
            if(textGreen.isSelected()) style += "-fx-text-fill: green;";
            if(textBlue.isSelected()) style += "-fx-text-fill: blue;";
        }
        if (!radioCasse.isDisable()) {
            if(casseMaj.isSelected()) textQuiChange.setText(textQuiChange.getText().toUpperCase());
            if(casseMin.isSelected()) textQuiChange.setText(textQuiChange.getText().toLowerCase());
        } else textQuiChange.setText(texte);
        textQuiChange.setStyle(style);
    }
}
