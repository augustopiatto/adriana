package app.controllers;

import entities.Comida;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ComidaController {
    String nomeBr;
    String saborBr;
    String texturaBr;

    @FXML
    private TextField nome;

    @FXML
    private TextField sabor;

    @FXML
    private TextField textura;

    @FXML
    private TextField resultado;

    private void convertParam() {
        this.nomeBr = nome.getText();
        this.saborBr = sabor.getText();
        this.texturaBr = textura.getText();
    }

    @FXML
    protected void onReheatButtonClick() throws IOException {
        convertParam();
        if (!nomeBr.isEmpty() && !saborBr.isEmpty() && !texturaBr.isEmpty()) {
            Comida comida = new Comida(nomeBr,  saborBr, texturaBr);
            String resposta = comida.reaquecer();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }
    @FXML
    protected void onSaltButtonClick() throws IOException {
        convertParam();
        if (!nomeBr.isEmpty() && !saborBr.isEmpty() && !texturaBr.isEmpty()) {
            Comida comida = new Comida(nomeBr,  saborBr, texturaBr);
            String resposta = comida.salgar();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }
    @FXML
    protected void onEatButtonClick() throws IOException {
        convertParam();
        if (!nomeBr.isEmpty() && !saborBr.isEmpty() && !texturaBr.isEmpty()) {
            Comida comida = new Comida(nomeBr,  saborBr, texturaBr);
            String resposta = comida.comer();
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
