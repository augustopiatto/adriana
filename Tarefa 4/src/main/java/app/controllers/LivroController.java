package app.controllers;

import app.DAOs.LivroDAO;
import app.helpers.Utils;
import app.models.LivroModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LivroController implements Initializable {
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
    private ChoiceBox livroChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private boolean convertParam() {
        this.tituloBr = titulo.getText();
        this.durezaBr = dureza.getText();
        this.estiloBr = estilo.getText();
        if (tituloBr.isEmpty() || durezaBr.isEmpty() || estiloBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        titulo.clear();
        dureza.clear();
        estilo.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        LivroDAO livroDAO = new LivroDAO();
        int livroId = livroDAO.createLivro(tituloBr, durezaBr, estiloBr);

        if (livroId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        livroChoiceBox.getItems().clear();
        ArrayList<String> livroTipoList = new ArrayList<>();

        LivroDAO livroDAO = new LivroDAO();
        ObservableList<LivroModel> livroList = livroDAO.readLivro();

        for (LivroModel livro : livroList) {
            livroTipoList.add(livro.getTitulo() + " - " + livro.getDureza() + " - " + livro.getEstilo());
        }

        livroChoiceBox.getItems().addAll(livroTipoList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String livroAtual = (String) livroChoiceBox.getValue();
        String tituloAtual = livroAtual.split(" - ")[0];
        String durezaAtual = livroAtual.split(" - ")[1];
        String estiloAtual = livroAtual.split(" - ")[2];
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.updateLivro(tituloAtual, durezaAtual, estiloAtual, tituloBr, durezaBr, estiloBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String livroAtual = (String) livroChoiceBox.getValue();
        if (livroAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            String tituloAtual = livroAtual.split(" - ")[0];
            String durezaAtual = livroAtual.split(" - ")[1];
            String estiloAtual = livroAtual.split(" - ")[2];
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.deleteLivro(tituloAtual, durezaAtual, estiloAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
