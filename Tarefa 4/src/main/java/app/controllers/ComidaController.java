package app.controllers;

import app.DAOs.ComidaDAO;
import app.helpers.Utils;
import app.models.ComidaModel;
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

public class ComidaController implements Initializable {
    String nomeBr;
    String saborBr;
    String texturaBr;

    @FXML
    private TextField nome;
    @FXML
    private TextField sabor;
    @FXML
    private TextField textura;
    @FXML
    private ChoiceBox comidaChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private boolean convertParam() {
        this.nomeBr = nome.getText();
        this.saborBr = sabor.getText();
        this.texturaBr = textura.getText();
        if (nomeBr.isEmpty() || saborBr.isEmpty() || texturaBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        nome.clear();
        sabor.clear();
        textura.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        ComidaDAO comidaDAO = new ComidaDAO();
        int comidaId = comidaDAO.createComida(nomeBr, saborBr, texturaBr);

        if (comidaId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        comidaChoiceBox.getItems().clear();
        ArrayList<String> comidaMarcaList = new ArrayList<>();

        ComidaDAO comidaDAO = new ComidaDAO();
        ObservableList<ComidaModel> comidaList = comidaDAO.readComida();

        for (ComidaModel comida : comidaList) {
            comidaMarcaList.add(comida.getNome());
        }

        comidaChoiceBox.getItems().addAll(comidaMarcaList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String nomeAtual = (String) comidaChoiceBox.getValue();
        ComidaDAO comidaDAO = new ComidaDAO();
        comidaDAO.updateComida(nomeAtual, nomeBr, saborBr, texturaBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String nomeAtual = (String) comidaChoiceBox.getValue();
        if (nomeAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            ComidaDAO comidaDAO = new ComidaDAO();
            comidaDAO.deleteComida(nomeAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
