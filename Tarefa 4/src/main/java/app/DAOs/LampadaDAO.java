package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.LampadaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LampadaDAO {
    ObservableList<LampadaModel> lampadaList = FXCollections.observableArrayList();

    public int createLampada(int voltagem, String tipo, String brilho) {
        String sql = "INSERT INTO lampada (voltagem, tipo, brilho) VALUES(?, ?, ?)";
        int lampadaId = 0;

        try {
            lampadaId = DatabaseConnection.executeUpdate(sql, voltagem, tipo, brilho);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createLampada: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return lampadaId;
    }

    public ObservableList<LampadaModel> readLampada() {
        String sql = "SELECT * FROM lampada";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                int voltagem = resultSet.getInt("voltagem");
                String tipo = resultSet.getString("tipo");
                String brilho = resultSet.getString("brilho");

                LampadaModel lampada = new LampadaModel(voltagem, tipo, brilho);
                lampadaList.add(lampada);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readLampada: " + e.getMessage());
        }
        return lampadaList;
    }

    public int updateLampada(int voltagemAtual, String tipoAtual, int voltagemNova, String tipoNovo, String brilhoNovo) {
        int generatedKey = 0;
        String sql = "UPDATE lampada SET voltagem = ?, tipo = ?, brilho = ? WHERE voltagem = ? AND tipo = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, voltagemNova, tipoNovo, brilhoNovo, voltagemAtual, tipoAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateLampada: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteLampada(int voltagem, String tipo) {
        String sql = "DELETE FROM lampada WHERE voltagem = ? AND tipo = ?";

        try {
            DatabaseConnection.executeUpdate(sql, voltagem, tipo);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteLampada: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
