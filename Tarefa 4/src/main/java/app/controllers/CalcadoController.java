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
import java.util.List;
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
        convertParam();
        if (tamanhoBr > 0 && !marcaBr.isEmpty()) {
            String calcadoAtual = (String) calcadoChoiceBox.getValue();
            String marcaAtual = calcadoAtual.split(" - ")[0];
            int tamanhoAtual = Integer.parseInt(calcadoAtual.split(" - ")[1]);
            CalcadoDAO calcadoDAO = new CalcadoDAO();
            calcadoDAO.updateCalcado(tamanhoAtual, marcaAtual, tamanhoBr, marcaBr);
            read();
        } else {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        }
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
