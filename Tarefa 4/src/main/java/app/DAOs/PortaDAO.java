package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.PortaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PortaDAO {
    ObservableList<PortaModel> portaList = FXCollections.observableArrayList();

    public int createPorta(float altura, String cor) {
        String sql = "INSERT INTO porta (altura, cor) VALUES(?, ?)";
        int portaId = 0;

        try {
            portaId = DatabaseConnection.executeUpdate(sql, altura, cor);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createPorta: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return portaId;
    }

    public ObservableList<PortaModel> readPorta() {
        String sql = "SELECT * FROM porta ORDER BY altura";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                float altura = resultSet.getFloat("altura");
                String cor = resultSet.getString("cor");

                PortaModel porta = new PortaModel(altura, cor);
                portaList.add(porta);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readPorta: " + e.getMessage());
        }
        return portaList;
    }

    public int updatePorta(float alturaAtual, String corAtual, float alturaNova, String corNova) {
        int generatedKey = 0;
        String sql = "UPDATE porta SET altura = ?, cor = ? WHERE altura = ? AND cor = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, alturaNova, corNova, alturaAtual, corAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updatePorta: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deletePorta(float altura, String cor) {
        String sql = "DELETE FROM porta WHERE altura = ? AND cor = ?";

        try {
            DatabaseConnection.executeUpdate(sql, altura, cor);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deletePorta: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
