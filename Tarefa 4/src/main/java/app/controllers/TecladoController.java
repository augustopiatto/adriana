package app.controllers;

import app.DAOs.TecladoDAO;
import app.helpers.Utils;
import app.models.TecladoModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class TecladoController implements Initializable {
    int teclasBr;
    boolean rgbBr;
    String tipoBr;

    @FXML
    private TextField teclas;
    @FXML
    private TextField rgb;
    @FXML
    private TextField tipo;
    @FXML
    private ChoiceBox tecladoChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private boolean convertParam() {
        this.tipoBr = tipo.getText();
        if (teclas.getText() != null && !teclas.getText().trim().isEmpty()) {
            try {
                this.teclasBr = Integer.parseInt(teclas.getText());
            } catch (NumberFormatException e) {
                Utils.setAlert("ERROR", "Validação", "O campo de tamanho não é um número");
                return false;
            }
        }
        if (rgb.getText() != null && !rgb.getText().trim().isEmpty()) {
            if (Objects.equals(rgb.getText(), "true")) rgbBr = true;
            else rgbBr = false;
        } else {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        if (teclasBr <= 0 || tipoBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        teclas.clear();
        rgb.clear();
        tipo.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        TecladoDAO tecladoDAO = new TecladoDAO();
        int tecladoId = tecladoDAO.createTeclado(teclasBr, rgbBr, tipoBr);

        if (tecladoId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        tecladoChoiceBox.getItems().clear();
        ArrayList<String> tecladoTipoList = new ArrayList<>();

        TecladoDAO tecladoDAO = new TecladoDAO();
        ObservableList<TecladoModel> tecladoList = tecladoDAO.readTeclado();

        for (TecladoModel teclado : tecladoList) {
            tecladoTipoList.add(teclado.getTipo() + " - " + teclado.getTeclas() + " - " + teclado.getRgb());
        }

        tecladoChoiceBox.getItems().addAll(tecladoTipoList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String tecladoAtual = (String) tecladoChoiceBox.getValue();
        String tipoAtual = tecladoAtual.split(" - ")[0];
        int teclasAtual = Integer.parseInt(tecladoAtual.split(" - ")[1]);
        boolean rgbAtual = Boolean.parseBoolean(tecladoAtual.split(" - ")[2]);
        TecladoDAO tecladoDAO = new TecladoDAO();
        tecladoDAO.updateTeclado(teclasAtual, rgbAtual, tipoAtual, teclasBr, rgbBr, tipoBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String tecladoAtual = (String) tecladoChoiceBox.getValue();
        if (tecladoAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            String tipoAtual = tecladoAtual.split(" - ")[0];
            int teclasAtual = Integer.parseInt(tecladoAtual.split(" - ")[1]);
            boolean rgbAtual = Boolean.parseBoolean(tecladoAtual.split(" - ")[2]);
            TecladoDAO tecladoDAO = new TecladoDAO();
            tecladoDAO.deleteTeclado(teclasAtual, rgbAtual, tipoAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
