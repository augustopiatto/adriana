package app.controllers;

import app.DAOs.FlorDAO;
import app.helpers.Utils;
import app.models.FlorModel;
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

public class FlorController implements Initializable {
    String corBr;
    String estacaoBr;

    @FXML
    private TextField cor;
    @FXML
    private TextField estacao;
    @FXML
    private ChoiceBox florChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private boolean convertParam() {
        this.corBr = cor.getText();
        this.estacaoBr = estacao.getText();
        if (corBr.isEmpty() || estacaoBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        cor.clear();
        estacao.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        FlorDAO florDAO = new FlorDAO();
        int florId = florDAO.createFlor(corBr, estacaoBr);

        if (florId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        florChoiceBox.getItems().clear();
        ArrayList<String> florCorMarcaList = new ArrayList<>();

        FlorDAO florDAO = new FlorDAO();
        ObservableList<FlorModel> florList = florDAO.readFlor();

        for (FlorModel flor : florList) {
            florCorMarcaList.add(flor.getCor() + " - " + flor.getEstacao());
        }

        florChoiceBox.getItems().addAll(florCorMarcaList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String celularAtual = (String) florChoiceBox.getValue();
        String corAtual = celularAtual.split(" - ")[0];
        String estacaoAtual = celularAtual.split(" - ")[1];
        FlorDAO florDAO = new FlorDAO();
        florDAO.updateFlor(corAtual, estacaoAtual, corBr, estacaoBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String celularAtual = (String) florChoiceBox.getValue();
        if (celularAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            String corAtual = celularAtual.split(" - ")[0];
            String estacaoAtual = celularAtual.split(" - ")[1];
            FlorDAO florDAO = new FlorDAO();
            florDAO.deleteFlor(estacaoAtual, corAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
