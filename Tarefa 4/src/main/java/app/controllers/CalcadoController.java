package app.controllers;

import app.DAOs.CalcadoDAO;
import app.helpers.Utils;
import app.models.CalcadoModel;
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

public class CalcadoController implements Initializable {
    int tamanhoBr;
    String marcaBr;

    @FXML
    private TextField marca;
    @FXML
    private TextField tamanho;
    @FXML
    private ChoiceBox calcadoChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private void convertParam() {
        this.marcaBr = marca.getText();
        if (tamanho.getText() != null && !tamanho.getText().trim().isEmpty()) {
            try {
                this.tamanhoBr = Integer.parseInt(tamanho.getText());
            } catch (NumberFormatException e) {
                Utils.setAlert("ERROR", "Validação", "O campo de tamanho não é um número");
            }
        }
        else if (tamanhoBr <= 0 || marcaBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        }
    }

    private void clearInputs() {
        marca.clear();
        tamanho.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        convertParam();
        CalcadoDAO calcadoDAO = new CalcadoDAO();
        int calcadoId = calcadoDAO.createCalcado(tamanhoBr, marcaBr);

        if (calcadoId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        calcadoChoiceBox.getItems().clear();
        ArrayList<String> calcadoMarcaList = new ArrayList<>();

        CalcadoDAO calcadoDAO = new CalcadoDAO();
        ObservableList<CalcadoModel> calcadoList = calcadoDAO.readCalcado();

        for (CalcadoModel calcado : calcadoList) {
            calcadoMarcaList.add(calcado.getMarca() + " - " + calcado.getTamanho());
        }

        calcadoChoiceBox.getItems().addAll(calcadoMarcaList);
    }

    @FXML
    private void update(ActionEvent event) {
        String calcadoAtual = (String) calcadoChoiceBox.getValue();
        String marcaAtual = calcadoAtual.split(" - ")[0];
        int tamanhoAtual = Integer.parseInt(calcadoAtual.split(" - ")[1]);
        CalcadoDAO calcadoDAO = new CalcadoDAO();
        calcadoDAO.updateCalcado(tamanhoAtual, marcaAtual, tamanhoBr, marcaBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String calcadoAtual = (String) calcadoChoiceBox.getValue();
        if (calcadoAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            String marcaAtual = calcadoAtual.split(" - ")[0];
            int tamanhoAtual = Integer.parseInt(calcadoAtual.split(" - ")[1]);
            CalcadoDAO calcadoDAO = new CalcadoDAO();
            calcadoDAO.deleteCalcado(tamanhoAtual, marcaAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
