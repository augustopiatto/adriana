package app.controllers;

import app.models.LivroModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LivroController {
    String tituloBr;
    String durezaBr;
    String estiloBr;

    @FXML
    private TextField titulo;

    @FXML
    private TextField dureza;

    @FXML
    private TextField estilo;

    @FXML
    private TextField resultado;

    private void convertParam() {
        this.tituloBr = titulo.getText();
        this.durezaBr = dureza.getText();
        this.estiloBr = estilo.getText();
    }

    @FXML
    protected void onReadButtonClick() throws IOException {
        convertParam();
        if (!tituloBr.isEmpty() && !durezaBr.isEmpty() && !estiloBr.isEmpty()) {
            LivroModel livro = new LivroModel(tituloBr,  durezaBr, estiloBr);
            String resposta = livro.ler();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onModifyButtonClick() throws IOException {
        convertParam();
        if (!tituloBr.isEmpty() && !durezaBr.isEmpty() && !estiloBr.isEmpty()) {
            LivroModel livro = new LivroModel(tituloBr,  durezaBr, estiloBr);
            String resposta = livro.modificar(durezaBr);
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onBurnButtonClick() throws IOException {
        convertParam();
        if (!tituloBr.isEmpty() && !durezaBr.isEmpty() && !estiloBr.isEmpty()) {
            LivroModel livro = new LivroModel(tituloBr,  durezaBr, estiloBr);
            String resposta = livro.queimar();
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
