/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package org.artavia.tarea.t1.artavia.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author alex
 */
public class MainController {

  @FXML private Label label;

  @FXML
  private void handleButtonClick(ActionEvent event) {
    label.setText("Prueba JavaFX");
  }
}
