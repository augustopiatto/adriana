package app.controllers;

import entities.Carro;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CarroController {
    float precoBr;
    String marcaBr;
    String corBr;

    @FXML
    private TextField cor;

    @FXML
    private TextField marca;

    @FXML
    private TextField preco;

    @FXML
    private TextField resultado;

    private void convertParam() {
        if (preco.getText() != null && !preco.getText().trim().isEmpty()) {
            this.precoBr = Float.parseFloat(preco.getText());
        }
        this.corBr = cor.getText();
        this.marcaBr = marca.getText();
    }

    @FXML
    protected void onDriveButtonClick() throws IOException {
        convertParam();
        if (!corBr.isEmpty() && !marcaBr.isEmpty() && precoBr > 0) {
            Carro carro = new Carro(corBr,  marcaBr, precoBr);
            String resposta = carro.dirigir();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onSellButtonClick() throws IOException {
        convertParam();
        if (!corBr.isEmpty() && !marcaBr.isEmpty() && precoBr > 0) {
            Carro carro = new Carro(corBr,  marcaBr, precoBr);
            String resposta = carro.vender();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onMenuButtonClick() throws IOException {
        Main.setRoot("/menu");
    }
}
