package app.controllers;

import app.DAOs.InstrumentoDAO;
import app.helpers.Utils;
import app.models.InstrumentoModel;
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

public class InstrumentoController implements Initializable {
    String nomeBr;
    String tipoBr;
    String tamanhoBr;

    @FXML
    private TextField nome;
    @FXML
    private TextField tipo;
    @FXML
    private TextField tamanho;
    @FXML
    private ChoiceBox instrumentoChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private boolean convertParam() {
        this.nomeBr = nome.getText();
        this.tipoBr = tipo.getText();
        this.tamanhoBr = tamanho.getText();
        if (tamanhoBr.isEmpty() || nomeBr.isEmpty() || tipoBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        nome.clear();
        tipo.clear();
        tamanho.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        InstrumentoDAO instrumentoDAO = new InstrumentoDAO();
        int instrumentoId = instrumentoDAO.createInstrumento(nomeBr, tipoBr, tamanhoBr);

        if (instrumentoId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        instrumentoChoiceBox.getItems().clear();
        ArrayList<String> instrumentoNomeList = new ArrayList<>();

        InstrumentoDAO instrumentoDAO = new InstrumentoDAO();
        ObservableList<InstrumentoModel> instrumentoList = instrumentoDAO.readInstrumento();

        for (InstrumentoModel instrumento : instrumentoList) {
            instrumentoNomeList.add(instrumento.getNome());
        }

        instrumentoChoiceBox.getItems().addAll(instrumentoNomeList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String nomeAtual = (String) instrumentoChoiceBox.getValue();
        InstrumentoDAO instrumentoDAO = new InstrumentoDAO();
        instrumentoDAO.updateInstrumento(nomeAtual, nomeBr, tipoBr, tamanhoBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String nomeAtual = (String) instrumentoChoiceBox.getValue();
        if (nomeAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            InstrumentoDAO instrumentoDAO = new InstrumentoDAO();
            instrumentoDAO.deleteInstrumento(nomeAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
