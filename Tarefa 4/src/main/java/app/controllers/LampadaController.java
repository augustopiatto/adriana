package app.controllers;

import app.DAOs.LampadaDAO;
import app.helpers.Utils;
import app.models.LampadaModel;
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

public class LampadaController implements Initializable {
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
    private ChoiceBox lampadaChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private boolean convertParam() {
        this.tipoBr = tipo.getText();
        this.brilhosidadeBr = brilhosidade.getText();
        if (voltagem.getText() != null && !voltagem.getText().trim().isEmpty()) {
            try {
                this.voltagemBr = Integer.parseInt(voltagem.getText());
            } catch (NumberFormatException e) {
                Utils.setAlert("ERROR", "Validação", "O campo de tamanho não é um número");
                return false;
            }
        }
        else if (voltagemBr <= 0 || tipoBr.isEmpty() || brilhosidadeBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        tipo.clear();
        brilhosidade.clear();
        voltagem.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        LampadaDAO lampadaDAO = new LampadaDAO();
        int lampadaId = lampadaDAO.createLampada(voltagemBr, tipoBr, brilhosidadeBr);

        if (lampadaId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        lampadaChoiceBox.getItems().clear();
        ArrayList<String> voltagemTipoList = new ArrayList<>();

        LampadaDAO lampadaDAO = new LampadaDAO();
        ObservableList<LampadaModel> voltagemList = lampadaDAO.readLampada();

        for (LampadaModel voltagem : voltagemList) {
            voltagemTipoList.add(voltagem.getVoltagem() + " - " + voltagem.getTipo());
        }

        lampadaChoiceBox.getItems().addAll(voltagemTipoList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String lampadaAtual = (String) lampadaChoiceBox.getValue();
        int voltagemAtual = Integer.parseInt(lampadaAtual.split(" - ")[0]);
        String tipoAtual = lampadaAtual.split(" - ")[1];
        LampadaDAO lampadaDAO = new LampadaDAO();
        lampadaDAO.updateLampada(voltagemAtual, tipoAtual, voltagemBr, tipoBr, brilhosidadeBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String lampadaAtual = (String) lampadaChoiceBox.getValue();
        if (lampadaAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            int voltagemAtual = Integer.parseInt(lampadaAtual.split(" - ")[0]);
            String tipoAtual = lampadaAtual.split(" - ")[1];
            LampadaDAO lampadaDAO = new LampadaDAO();
            lampadaDAO.deleteLampada(voltagemAtual, tipoAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
