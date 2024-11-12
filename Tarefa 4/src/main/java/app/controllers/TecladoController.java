package app.controllers;

import entities.Teclado;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TecladoController {
    int teclasBr;
    boolean rgbBr;
    String tipoBr;
    String textoBr;

    @FXML
    private TextField teclas;

    @FXML
    private TextField rgb;

    @FXML
    private TextField tipo;

    @FXML
    private TextField texto;

    @FXML
    private TextField resultado;

    private void convertParam() {
        if (teclas.getText() != null && !teclas.getText().trim().isEmpty()) {
            this.teclasBr = Integer.parseInt(teclas.getText());
        }
        this.rgbBr = rgb.getText().equals("true");
        this.tipoBr = tipo.getText();
        this.textoBr = texto.getText();
    }

    @FXML
    protected void onTypeButtonClick() throws IOException {
        convertParam();
        if (!tipoBr.isEmpty() && !textoBr.isEmpty() && teclasBr > 0) {
            Teclado teclado = new Teclado(teclasBr, rgbBr, tipoBr);
            String resposta = teclado.digitar(textoBr);
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onCompareButtonClick() throws IOException {
        convertParam();
        if (!tipoBr.isEmpty() && teclasBr > 0) {
            Teclado teclado = new Teclado(teclasBr, rgbBr, tipoBr);
            Teclado teclado2 = new Teclado(100, false, "membrana");
            String resposta = teclado.comparar(teclado2);
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
