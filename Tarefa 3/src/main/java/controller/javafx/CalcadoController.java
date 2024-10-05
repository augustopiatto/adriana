package controller.javafx;

import entities.Calcado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CalcadoController {
    int tamanhoBr;
    String marcaBr;

    @FXML
    private TextField marca;

    @FXML
    private TextField tamanho;

    @FXML
    private TextField resultado;

    @FXML
    void onCleanShoesButtonClick(ActionEvent event) {
        convertParam();
        if (tamanhoBr > 0 && !marcaBr.isEmpty()) {
            Calcado calcado = new Calcado(Integer.parseInt(tamanho.getText()), marca);
            String resposta = calcado.limpar();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos"); 
        }
    }

    private void convertParam() {
        if (tamanho.getText() != null && !tamanho.getText().trim().isEmpty()) {
            this.tamanhoBr = Integer.parseInt(tamanho.getText());
        }
        this.marcaBr = marca.getText();
    }

    @FXML
    void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("menu");
    }

    @FXML
    void onPlayShoesButtonClick(ActionEvent event) {
        convertParam();
        if (tamanhoBr > 0 && !marcaBr.isEmpty()) {
            Calcado calcado = new Calcado(Integer.parseInt(tamanho.getText()), marca);
            String resposta = calcado.jogarNosFiosDoPoste();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    void onUseShoesButtonClick(ActionEvent event) {
        convertParam();
        if (tamanhoBr > 0 && !marcaBr.isEmpty()) {
            Calcado calcado = new Calcado(Integer.parseInt(tamanho.getText()), marca);
            String resposta = calcado.usar();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

}
