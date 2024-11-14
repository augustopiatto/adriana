package app.controllers;

import entities.Instrumento;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InstrumentoController {
    String nomeBr;
    String tipoBr;
    String tamanhoBr;

    @FXML
    private TextField nome;

    @FXML
    private TextField tipo;

    @FXML
    private TextField tamanho;

    @FXML
    private TextField resultado;

    private void convertParam() {
        this.nomeBr = nome.getText();
        this.tipoBr = tipo.getText();
        this.tamanhoBr = tamanho.getText();
    }

    @FXML
    protected void onDescribeButtonClick() throws IOException {
        convertParam();
        if (!nomeBr.isEmpty() && !tipoBr.isEmpty() && !tamanhoBr.isEmpty()) {
            Instrumento instrumento = new Instrumento(nomeBr,  tipoBr, tamanhoBr);
            String resposta = instrumento.descrever();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onTouchButtonClick() throws IOException {
        convertParam();
        if (!nomeBr.isEmpty() && !tipoBr.isEmpty() && !tamanhoBr.isEmpty()) {
            Instrumento instrumento = new Instrumento(nomeBr,  tipoBr, tamanhoBr);
            String resposta = instrumento.tocar();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onRepairButtonClick() throws IOException {
        convertParam();
        if (!nomeBr.isEmpty() && !tipoBr.isEmpty() && !tamanhoBr.isEmpty()) {
            Instrumento instrumento = new Instrumento(nomeBr,  tipoBr, tamanhoBr);
            String resposta = instrumento.reparar();
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
