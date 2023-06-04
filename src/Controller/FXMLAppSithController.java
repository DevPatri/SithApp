/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import sithapp.AprendizSith;
import sithapp.Fortalezas;
import sithapp.LordSith;

/**
 * FXML Controller class
 *
 * @author Patri
 */
public class FXMLAppSithController implements Initializable {

    @FXML
    private Pane pLord;
    @FXML
    private CheckBox chbMaestro;
    @FXML
    private CheckBox chbAlpha;
    @FXML
    private Pane pAprendiz;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfEdad;
    @FXML
    private TextField tfNivelMidi;

    @FXML
    private RadioButton rbLord;
    @FXML
    private RadioButton rbAprendiz;
    @FXML
    private ToggleGroup SithGroup;
    @FXML
    private TextField tfFortaleza;
    @FXML
    private TextField tfMaestro;
    @FXML
    private ListView<LordSith> lvVistaLordSith;
    private ObservableList<LordSith> OLLordSith = FXCollections.observableArrayList();
    @FXML
    private ListView<AprendizSith> lvVistaAprendizSith;
    private ObservableList<AprendizSith> OLAprendizSith = FXCollections.observableArrayList();
    @FXML
    private TextField tfAprendiz;
    @FXML
    private Button btInsertar;
    @FXML
    private Button btBorrarLord;
    @FXML
    private Button btBorrarTodosLord;
    @FXML
    private Button btBorrarAprendiz;
    @FXML
    private Button btBorrarTodosAprendiz;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chbAlpha.setDisable(true);
        tfAprendiz.setDisable(true);

        lvVistaLordSith.setItems(OLLordSith);
        lvVistaAprendizSith.setItems(OLAprendizSith);

    }

    @FXML
    private void MaestroOnAction(ActionEvent event) {
        if (chbMaestro.isSelected()) {
            chbAlpha.setDisable(false);
            tfAprendiz.setDisable(false);
        } else {
            chbAlpha.setSelected(false);
            chbAlpha.setDisable(true);
            tfAprendiz.setDisable(true);
        }
    }

    @FXML
    private void LordSithButton(ActionEvent event) {
        pLord.setDisable(false);
        pAprendiz.setDisable(true);

    }

    @FXML
    private void AprendizButton(ActionEvent event) {
        pAprendiz.setDisable(false);
        pLord.setDisable(true);

    }

    private void añadirLord() {
        Fortalezas a = new Fortalezas(tfFortaleza.getText());
        /*
        recorremos el listview de los aprendices buscando coincidencia, 
        y si no lo encontramos, creamos el aprendiz con el nombre introducido
        y creamos el Lord con los atributos correspondientes.
         */

        for (int i = 0; i < OLAprendizSith.size(); i++) {

            if (OLAprendizSith.get(i).getNombre().equalsIgnoreCase(tfAprendiz.getText().trim())) {
                LordSith lord = new LordSith(chbMaestro.isSelected(), chbAlpha.isSelected(), OLAprendizSith.get(i), tfNombre.getText(), Integer.parseInt(tfNivelMidi.getText()), Integer.parseInt(tfEdad.getText()), a);
                lvVistaLordSith.getItems().add(lord);
                return;
            }
        }
//        AprendizSith aprendiz = new AprendizSith();
//        aprendiz.setNombre(tfAprendiz.getText().trim());
        LordSith lord = new LordSith(chbMaestro.isSelected(), chbAlpha.isSelected(), tfNombre.getText(), Integer.parseInt(tfNivelMidi.getText()), Integer.parseInt(tfEdad.getText()), a);
        lvVistaLordSith.getItems().add(lord);
    }

    private void añadirAprendiz() {
        Fortalezas a = new Fortalezas(tfFortaleza.getText());

        for (int i = 0; i < OLLordSith.size(); i++) {
            if (OLLordSith.get(i).getNombre().equalsIgnoreCase(tfMaestro.getText().trim())) {
                AprendizSith aprendiz = new AprendizSith(OLLordSith.get(i), tfNombre.getText(), Integer.parseInt(tfNivelMidi.getText()), Integer.parseInt(tfEdad.getText()), a);
                lvVistaAprendizSith.getItems().add(aprendiz);
                return;
            }
        }
//        LordSith lord = new LordSith();
//        lord.setNombre(tfMaestro.getText().trim());
        AprendizSith aprendiz = new AprendizSith( tfNombre.getText(), Integer.parseInt(tfNivelMidi.getText()), Integer.parseInt(tfEdad.getText()), a);
        lvVistaAprendizSith.getItems().add(aprendiz);

    }

    @FXML
    private void Insertar(ActionEvent event) {

        if (rbLord.isSelected()) {
            añadirLord();
            lvVistaAprendizSith.refresh();
            lvVistaLordSith.refresh();

        } else if (rbAprendiz.isSelected()) {
            añadirAprendiz();
            lvVistaAprendizSith.refresh();
            lvVistaLordSith.refresh();
        }
    }

    @FXML
    private void BorrarLord(ActionEvent event) {
        this.OLLordSith.remove(this.lvVistaLordSith.getSelectionModel().getSelectedItem());
        lvVistaLordSith.refresh();
    }

    @FXML
    private void BorrarTodosLord(ActionEvent event) {
        this.lvVistaLordSith.getItems().removeAll(OLLordSith);
    }

    @FXML
    private void BorrarAprendiz(ActionEvent event) {
        this.OLAprendizSith.remove(this.lvVistaAprendizSith.getSelectionModel().getSelectedItem());
        lvVistaAprendizSith.refresh();
    }

    @FXML
    private void BorrarTodosAprendiz(ActionEvent event) {
        this.lvVistaAprendizSith.getItems().removeAll(OLAprendizSith);
    }
}
