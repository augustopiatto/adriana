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

    private boolean convertParam() {
        this.corBr = cor.getText();
        this.marcaBr = marca.getText();
        if (preco.getText() != null && !preco.getText().trim().isEmpty()) {
            try {
                this.precoBr = Integer.parseInt(preco.getText());
            } catch (NumberFormatException e) {
                Utils.setAlert("ERROR", "Validação", "O campo de preço não é um número");
                return false;
            }

        }
        else if (precoBr <= 0 || corBr.isEmpty() || marcaBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        cor.clear();
        marca.clear();
        preco.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
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
            carroMarcaList.add(carro.getMarca() + " - " + carro.getCor());
        }

        carroChoiceBox.getItems().addAll(carroMarcaList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String carroAtual = (String) carroChoiceBox.getValue();
        String marcaAtual = carroAtual.split(" - ")[0];
        String corAtual = carroAtual.split(" - ")[1];
        CarroDAO carroDAO = new CarroDAO();
        carroDAO.updateCarro(corAtual, marcaAtual, corBr, marcaBr, precoBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String carroAtual = (String) carroChoiceBox.getValue();
        if (carroAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            String marcaAtual = carroAtual.split(" - ")[0];
            String corAtual = carroAtual.split(" - ")[1];
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.deleteCarro(corAtual, marcaAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
