package app.controllers;

import app.DAOs.CelularDAO;
import app.helpers.Utils;
import app.models.CelularModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CelularController implements Initializable {
    String sistemaOperacionalBr;
    String marcaBr;

    @FXML
    private TextField marca;
    @FXML
    private TextField sistema;
    @FXML
    private ChoiceBox celularChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private boolean convertParam() {
        this.marcaBr = marca.getText();
        this.sistemaOperacionalBr = sistema.getText();
        if (sistemaOperacionalBr.isEmpty() || marcaBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        marca.clear();
        sistema.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        CelularDAO celularDAO = new CelularDAO();
        int celularId = celularDAO.createCelular(sistemaOperacionalBr, marcaBr);

        if (celularId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        celularChoiceBox.getItems().clear();
        ArrayList<String> celularMarcaList = new ArrayList<>();

        CelularDAO celularDAO = new CelularDAO();
        ObservableList<CelularModel> celularList = celularDAO.readCelular();

        for (CelularModel celular : celularList) {
            celularMarcaList.add(celular.getMarca() + " - " + celular.getSistemaOperacional());
        }

        celularChoiceBox.getItems().addAll(celularMarcaList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String celularAtual = (String) celularChoiceBox.getValue();
        String marcaAtual = celularAtual.split(" - ")[0];
        String sistemaOperacionalAtual = celularAtual.split(" - ")[1];
        CelularDAO celularDAO = new CelularDAO();
        celularDAO.updateCelular(sistemaOperacionalAtual, marcaAtual, sistemaOperacionalBr, marcaBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String celularAtual = (String) celularChoiceBox.getValue();
        if (celularAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            String marcaAtual = celularAtual.split(" - ")[0];
            String sistemaOperacionalAtual = celularAtual.split(" - ")[1];
            CelularDAO celularDAO = new CelularDAO();
            celularDAO.deleteCelular(sistemaOperacionalAtual, marcaAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
