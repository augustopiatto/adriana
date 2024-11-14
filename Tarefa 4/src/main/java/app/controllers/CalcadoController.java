package app.controllers;

import app.DAOs.CalcadoDAO;
import app.helpers.Utils;
import app.models.CalcadoModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class CalcadoController {
    int tamanhoBr;
    String marcaBr;

    @FXML
    private TextField marca;
    @FXML
    private TextField tamanho;
    @FXML
    private ChoiceBox calcadoChoiceBox;

    private void convertParam() {
        if (tamanho.getText() != null && !tamanho.getText().trim().isEmpty()) {
            this.tamanhoBr = Integer.parseInt(tamanho.getText());
        }
        this.marcaBr = marca.getText();
    }

    @FXML
    private void create(ActionEvent event) {
        convertParam();
        if (tamanhoBr > 0 && !marcaBr.isEmpty()) {
            CalcadoDAO calcadoDAO = new CalcadoDAO();
            int calcadoId = calcadoDAO.createCalcado(tamanhoBr, marcaBr);

            if (calcadoId != 0) {
                read();
            }
        } else {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        }
    }

    private void read() {
        List<String> calcadoMarcaList = List.of();

        CalcadoDAO calcadoDAO = new CalcadoDAO();
        ObservableList<CalcadoModel> calcadoList = calcadoDAO.readCalcado();

        for (CalcadoModel calcado : calcadoList) {
            calcadoMarcaList.add(calcado.getMarca());
        }

        calcadoChoiceBox.getItems().addAll(calcadoMarcaList);
    }

    @FXML
    private void update(ActionEvent event) {
        convertParam();
        if (tamanhoBr > 0 && !marcaBr.isEmpty()) {
//
        } else {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        convertParam();
        if (tamanhoBr > 0 && !marcaBr.isEmpty()) {
//
        } else {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
