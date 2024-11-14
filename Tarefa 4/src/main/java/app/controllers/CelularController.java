package app.controllers;

import entities.Celular;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CelularController {
    String sistemaBr;
    String marcaBr;

    @FXML
    private TextField sistema;

    @FXML
    private TextField marca;

    @FXML
    private TextField resultado;

    private void convertParam() {
        this.sistemaBr = sistema.getText();
        this.marcaBr = marca.getText();
    }

    @FXML
    protected void onSurpriseButtonClick() throws IOException {
        convertParam();
        if (!marcaBr.isEmpty() && !marcaBr.isEmpty()) {
            Celular celular = new Celular(sistemaBr,  marcaBr);
            String resposta = celular.derrubar();
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
