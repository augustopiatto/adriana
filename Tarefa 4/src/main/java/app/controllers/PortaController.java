package app.controllers;

import app.DAOs.PortaDAO;
import app.helpers.Utils;
import app.models.PortaModel;
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

public class PortaController implements Initializable {
    float alturaBr;
    String corBr;

    @FXML
    private TextField altura;
    @FXML
    private TextField cor;
    @FXML
    private ChoiceBox portaChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        read();
    }

    private boolean convertParam() {
        this.corBr = cor.getText();
        if (altura.getText() != null && !altura.getText().trim().isEmpty()) {
            try {
                this.alturaBr = Integer.parseInt(altura.getText());
            } catch (NumberFormatException e) {
                Utils.setAlert("ERROR", "Validação", "O campo de tamanho não é um número");
                return false;
            }
        }
        else if (alturaBr <= 0 || corBr.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        cor.clear();
        altura.clear();
    }

    @FXML
    private void create(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        PortaDAO portaDAO = new PortaDAO();
        int portaId = portaDAO.createPorta(alturaBr, corBr);

        if (portaId != 0) {
            clearInputs();
            read();
        }
    }

    private void read() {
        portaChoiceBox.getItems().clear();
        ArrayList<String> portaCorList = new ArrayList<>();

        PortaDAO portaDAO = new PortaDAO();
        ObservableList<PortaModel> portaList = portaDAO.readPorta();

        for (PortaModel porta : portaList) {
            portaCorList.add(porta.getCor() + " - " + porta.getAltura());
        }

        portaChoiceBox.getItems().addAll(portaCorList);
    }

    @FXML
    private void update(ActionEvent event) {
        boolean converted = convertParam();
        if (!converted) return;
        String portaAtual = (String) portaChoiceBox.getValue();
        String corAtual = portaAtual.split(" - ")[0];
        float alturaAtual = Float.parseFloat(portaAtual.split(" - ")[1]);
        PortaDAO portaDAO = new PortaDAO();
        portaDAO.updatePorta(alturaAtual, corAtual, alturaBr, corBr);
        clearInputs();
        read();
    }

    @FXML
    private void delete(ActionEvent event) {
        String portaAtual = (String) portaChoiceBox.getValue();
        if (portaAtual.isEmpty()) {
            Utils.setAlert("ERROR", "Validação", "Preencha os campos");
        } else {
            String corAtual = portaAtual.split(" - ")[0];
            float alturaAtual = Float.parseFloat(portaAtual.split(" - ")[1]);
            PortaDAO portaDAO = new PortaDAO();
            portaDAO.deletePorta(alturaAtual, corAtual);
            read();
        }
    }

    @FXML
    private void onMenuButtonClick(ActionEvent event) throws IOException {
        Main.setRoot("/menu");
    }
}
