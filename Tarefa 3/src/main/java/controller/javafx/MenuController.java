package controller.javafx;

import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {
    @FXML
    protected void onCalcadoButtonClick() throws IOException {
        Main.setRoot("calcado");
    }
    @FXML
    protected void onCarroButtonClick() throws IOException {
        Main.setRoot("carro");
    }
    @FXML
    protected void onCelularButtonClick() throws IOException {
        Main.setRoot("celular");
    }
    @FXML
    protected void onComidaButtonClick() throws IOException {
        Main.setRoot("comida");
    }
    @FXML
    protected void onFlorButtonClick() throws IOException {
        Main.setRoot("flor");
    }
    @FXML
    protected void onInstrumentoButtonClick() throws IOException {
        Main.setRoot("instrumento");
    }
    @FXML
    protected void onLampadaButtonClick() throws IOException {
        Main.setRoot("lampada");
    }
    @FXML
    protected void onLivroButtonClick() throws IOException {
        Main.setRoot("livro");
    }
    @FXML
    protected void onPortaButtonClick() throws IOException {
        Main.setRoot("porta");
    }
    @FXML
    protected void onTecladoButtonClick() throws IOException {
        Main.setRoot("teclado");
    }
}