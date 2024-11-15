package app.controllers;

import app.DAOs.CalcadoDAO;
import app.DAOs.CarroDAO;
import app.helpers.Utils;
import app.models.CalcadoModel;
import app.models.CarroModel;
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

public class CarroController implements Initializable {
    String corBr;
    String marcaBr;
    float precoBr;

    @FXML
    private TextField cor;
    @FXML
    private TextField marca;
    @FXML
    private TextField preco;
    @FXML
    private ChoiceBox carroChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private void convertParam() {
        this.corBr = cor.getText();
        this.marcaBr = marca.getText();
        if (preco.getText() != null && !preco.getText().trim().isEmpty()) {
            try {
                this.precoBr = Integer.parseInt(preco.getText());
            } catch (NumberFormatException e) {
                Utils.setAlert("ERROR", "Validação", "O campo de preço não é um número");
            }
        }
        else if (precoBr <= 0 || corBr.isEmpty() || marcaBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        }
    }

    private void clearInputs() {
        cor.clear();
        marca.clear();
        preco.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        convertParam();
        CarroDAO carroDAO = new CarroDAO();
        int carroId = carroDAO.createCarro(corBr, marcaBr, precoBr);

        if (carroId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        carroChoiceBox.getItems().clear();
        ArrayList<String> carroMarcaList = new ArrayList<>();

        CarroDAO carroDAO = new CarroDAO();
        ObservableList<CarroModel> carroList = carroDAO.readCarro();

        for (CarroModel carro : carroList) {
            carroMarcaList.add(carro.getMarca() + " " + carro.getCor());
        }

        carroChoiceBox.getItems().addAll(carroMarcaList);
    }

    @FXML
    private void update(ActionEvent event) {
//        String calcadoAtual = (String) carroChoiceBox.getValue();
//        String marcaAtual = calcadoAtual.split(" - ")[0];
//        int tamanhoAtual = Integer.parseInt(calcadoAtual.split(" - ")[1]);
//        CalcadoDAO calcadoDAO = new CalcadoDAO();
//        calcadoDAO.updateCalcado(tamanhoAtual, marcaAtual, precoBr, marcaBr);
//        clearInputs();
//        read();
    }

    @FXML
    private void delete(ActionEvent event) {
//        String calcadoAtual = (String) carroChoiceBox.getValue();
//        if (calcadoAtual.isEmpty()) {
//            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
//        } else {
//            String marcaAtual = calcadoAtual.split(" - ")[0];
//            int tamanhoAtual = Integer.parseInt(calcadoAtual.split(" - ")[1]);
//            CalcadoDAO calcadoDAO = new CalcadoDAO();
//            calcadoDAO.deleteCalcado(tamanhoAtual, marcaAtual);
//            read();
//        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
