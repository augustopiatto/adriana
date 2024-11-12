package app.controllers;

import entities.Porta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PortaController {
    float alturaBr;
    String corBr;

    @FXML
    private TextField cor;

    @FXML
    private TextField altura;

    @FXML
    private TextField resultado;

    private void convertParam() {
        if (altura.getText() != null && !altura.getText().trim().isEmpty()) {
            this.alturaBr = Float.parseFloat(altura.getText());
        }
        this.corBr = cor.getText();
    }

    @FXML
    protected void onOpenButtonClick() throws IOException {
        convertParam();
        if (!corBr.isEmpty() && alturaBr > 0) {
            Porta porta = new Porta(alturaBr, corBr);
            String resposta = porta.abrir();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onCloseButtonClick() throws IOException {
        convertParam();
        if (!corBr.isEmpty() && alturaBr > 0) {
            Porta porta = new Porta(alturaBr, corBr);
            String resposta = porta.fechar();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onMenuButtonClick() throws IOException {
        Main.setRoot("menu");
    }
}
