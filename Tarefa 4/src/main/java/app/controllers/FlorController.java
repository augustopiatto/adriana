package app.controllers;

import entities.Flor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FlorController {
    String estacaoBr;
    String corBr;

    @FXML
    private TextField cor;

    @FXML
    private TextField estacao;

    @FXML
    private TextField resultado;

    private void convertParam() {
        this.corBr = cor.getText();
        this.estacaoBr = estacao.getText();
    }

    @FXML
    protected void onSmellButtonClick() throws IOException {
        convertParam();
        if (!corBr.isEmpty() && !estacaoBr.isEmpty()) {
            Flor flor= new Flor(corBr,  estacaoBr);
            String resposta = flor.cheirar();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onHarvestButtonClick() throws IOException {
        convertParam();
        if (!corBr.isEmpty() && !estacaoBr.isEmpty()) {
            Flor flor = new Flor(corBr,  estacaoBr);
            String resposta = flor.colher();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onEatButtonClick() throws IOException {
        convertParam();
        if (!corBr.isEmpty() && !estacaoBr.isEmpty()) {
            Flor flor = new Flor(corBr,  estacaoBr);
            String resposta = flor.comer();
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
