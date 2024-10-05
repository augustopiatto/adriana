package controller.javafx;

import entities.Carro;
import entities.Lampada;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LampadaController {
    int voltagemBr;
    String tipoBr;
    String brilhosidadeBr;

    @FXML
    private TextField voltagem;

    @FXML
    private TextField tipo;

    @FXML
    private TextField brilhosidade;

    @FXML
    private TextField resultado;

    private void convertParam() {
        if (voltagem.getText() != null && !voltagem.getText().trim().isEmpty()) {
            this.voltagemBr = Integer.parseInt(voltagem.getText());
        }
        this.tipoBr = tipo.getText();
        this.brilhosidadeBr = brilhosidade.getText();
    }

    @FXML
    protected void onUseButtonClick() throws IOException {
        convertParam();
        if (voltagemBr > 0 && !tipoBr.isEmpty() && !brilhosidadeBr.isEmpty()) {
            Lampada lampada = new Lampada (220, tipoBr, brilhosidadeBr);
            String resposta = lampada.usar(voltagemBr);
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onBurnButtonClick() throws IOException {
        convertParam();
        if (voltagemBr > 0 && !tipoBr.isEmpty() && !brilhosidadeBr.isEmpty()) {
            Lampada lampada = new Lampada (220, tipoBr, brilhosidadeBr);
            String resposta = lampada.queimar();
            resultado.setText(resposta);
        } else {
            resultado.setText("Preencha os campos");
        }
    }

    @FXML
    protected void onBreakButtonClick() throws IOException {
        convertParam();
        if (voltagemBr > 0 && !tipoBr.isEmpty() && !brilhosidadeBr.isEmpty()) {
            Lampada lampada = new Lampada (220, tipoBr, brilhosidadeBr);
            String resposta = lampada.quebrar();
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
