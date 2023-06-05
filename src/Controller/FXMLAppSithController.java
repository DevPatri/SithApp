/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    @FXML
    private TextField tfAnioCaida;
    @FXML
    private TextField tfAnioAscenso;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pAprendiz.setDisable(true);
        pLord.setDisable(true);

        lvVistaLordSith.setItems(OLLordSith);
        lvVistaAprendizSith.setItems(OLAprendizSith);

    }

    @FXML
    private void MaestroOnAction(ActionEvent event) {
        if (chbMaestro.isSelected()) {
            chbAlpha.setDisable(false);
            tfAprendiz.setDisable(false);
            tfAnioAscenso.setDisable(false);
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
        
        /*
        Comprobamos primero si se ha escrito un nombre, para no crear un objeto vacío.
        */
        if (tfNombre.getText().isEmpty() || tfNombre.getText().isBlank()) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Advertencia");
            alerta.setContentText("Debe introducir como mínimo un nombre.");
            alerta.showAndWait();
        }
        Fortalezas a = new Fortalezas(tfFortaleza.getText());
        /*
        recorremos el listview de los aprendices buscando coincidencia, 
        y si no lo encontramos, creamos el aprendiz con el nombre introducido
        y creamos el Lord con los atributos correspondientes.
         */
        for (int i = 0; i < OLAprendizSith.size(); i++) {

            if (OLAprendizSith.get(i).getNombre().equalsIgnoreCase(tfAprendiz.getText().trim())) {
                try {
                    LordSith lord = new LordSith(chbMaestro.isSelected(), chbAlpha.isSelected(), Integer.parseInt(tfAnioAscenso.getText()), tfNombre.getText(), Integer.parseInt(tfNivelMidi.getText()), Integer.parseInt(tfEdad.getText()), a);
                    lord.agregarAprendiz(OLAprendizSith.get(i));
                    OLAprendizSith.get(i).setMaestro(lord);
                    lvVistaLordSith.getItems().add(lord);
                } catch (InputMismatchException e) {
                    System.out.println("Error: " + e);
                } catch (NumberFormatException e) {
                    System.out.println("Debe introducir los valores correctamente.");
                }
                return;
            }
        }
        try {
            LordSith lord = new LordSith(chbMaestro.isSelected(), chbAlpha.isSelected(), Integer.parseInt(tfAnioAscenso.getText()), tfNombre.getText(), Integer.parseInt(tfNivelMidi.getText()), Integer.parseInt(tfEdad.getText()), a);
            lvVistaLordSith.getItems().add(lord);
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Debe introducir los valores correctamente.");
        }
    }

    private void añadirAprendiz() {
        /*
        Comprobamos primero si se ha escrito un nombre, para no crear un objeto vacío.
        */
        if (tfNombre.getText().isEmpty() || tfNombre.getText().isBlank()) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Advertencia");
            alerta.setContentText("Debe introducir como mínimo un nombre.");
            alerta.showAndWait();
        }
        
        Fortalezas a = new Fortalezas(tfFortaleza.getText());

        if (!OLLordSith.isEmpty()) {
            /*
            Código a ejecutar para añadir un Aprendiz si hay Lords que puedan ser maestros en la lista.
            */
            for (int i = 0; i < OLLordSith.size(); i++) {
                if (OLLordSith.get(i).getNombre().equalsIgnoreCase(tfMaestro.getText().trim())) {
                    try {

                        AprendizSith aprendiz = new AprendizSith(tfNombre.getText(), Integer.parseInt(tfNivelMidi.getText()), Integer.parseInt(tfEdad.getText()), a, Integer.parseInt(tfAnioCaida.getText()));
                        OLLordSith.get(i).setMaestroSith(true);
                        aprendiz.setMaestro(OLLordSith.get(i));
                        lvVistaAprendizSith.getItems().add(aprendiz);

                    } catch (InputMismatchException e) {
                        System.out.println("Error: " + e);
                    } catch (NumberFormatException e) {
                        System.out.println("Debe introducir los valores correctamente.");
                    }
                    return;
                }
            }
        } else {
            /*
            Trozo de código a ejecutar si se mete un Aprendiz y no hay maestros en la lista.
            */
            try {
                AprendizSith aprendiz = new AprendizSith(tfNombre.getText(), Integer.parseInt(tfNivelMidi.getText()), Integer.parseInt(tfEdad.getText()), a, Integer.parseInt(tfAnioCaida.getText()));
                lvVistaAprendizSith.getItems().add(aprendiz);
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e);
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir los valores correctamente.");
            }
        }
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
