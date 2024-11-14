package app.controllers;

import app.helpers.Utils;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {
    @FXML
    protected void onCalcadoButtonClick() throws IOException {
        Main.setRoot("/calcado");
    }
    @FXML
    protected void onCarroButtonClick() throws IOException {
        Main.setRoot("/carro");
    }
    @FXML
    protected void onCelularButtonClick() throws IOException {
        Main.setRoot("/celular");
    }
    @FXML
    protected void onComidaButtonClick() throws IOException {
        Main.setRoot("/comida");
    }
    @FXML
    protected void onFlorButtonClick() throws IOException {
        Main.setRoot("/flor");
    }
    @FXML
    protected void onInstrumentoButtonClick() throws IOException {
        Main.setRoot("/instrumento");
    }
    @FXML
    protected void onLampadaButtonClick() throws IOException {
        Main.setRoot("/lampada");
    }
    @FXML
    protected void onLivroButtonClick() throws IOException {
        Main.setRoot("/livro");
    }
    @FXML
    protected void onPortaButtonClick() throws IOException {
        Main.setRoot("/porta");
    }
    @FXML
    protected void onTecladoButtonClick() throws IOException {
        Main.setRoot("/teclado");
    }
    @FXML
    private void fillDatabase() {
        try {
            Utils.executeSQLFromFile("/assets/sql/schema.sql");
            Utils.setAlert("CONFIRMATION", "Preenchimento do banco", "Tabelas criadas com sucesso!");
        } catch (Exception e) {
            Utils.setAlert("ERROR", "Preenchimento do banco", "Erro ao criar as tabelas: " + e.getMessage());
        }
        try {
            Utils.executeSQLFromFile("/assets/sql/dump.sql");
            Utils.setAlert("CONFIRMATION", "Preenchimento do banco", "As tabelas foram populadas com sucesso!");
        } catch (Exception e) {
            Utils.setAlert("ERROR", "Preenchimento do banco", "Erro ao popular as tabelas: " + e.getMessage());
        }
    }
}