package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.TecladoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TecladoDAO {
    ObservableList<TecladoModel> tecladoList = FXCollections.observableArrayList();

    public int createTeclado(int teclas, boolean rgb, String tipo) {
        String sql = "INSERT INTO teclado (teclas, rgb, tipo) VALUES(?, ?, ?)";
        int tecladoId = 0;

        try {
            tecladoId = DatabaseConnection.executeUpdate(sql, teclas, rgb, tipo);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createTeclado: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return tecladoId;
    }

    public ObservableList<TecladoModel> readTeclado() {
        String sql = "SELECT * FROM teclado ORDER BY teclas";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                int teclas = resultSet.getInt("teclas");
                boolean rgb = resultSet.getBoolean("rgb");
                String tipo = resultSet.getString("tipo");

                TecladoModel teclado = new TecladoModel(teclas, rgb, tipo);
                tecladoList.add(teclado);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readTeclado: " + e.getMessage());
        }
        return tecladoList;
    }

    public int updateTeclado(int teclasAtual, boolean rgbAtual, String tipoAtual, int teclasNova, boolean rgbNovo, String tipoNovo) {
        int generatedKey = 0;
        String sql = "UPDATE teclado SET teclas = ?, rgb = ?, tipo = ? WHERE teclas = ? AND rgb = ? AND tipo = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, teclasNova, rgbNovo, tipoNovo, teclasAtual, rgbAtual, tipoAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateTeclado: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteTeclado(int teclas, boolean rgb, String tipo) {
        String sql = "DELETE FROM teclado WHERE teclas = ? AND rgb = ? AND tipo = ?";

        try {
            DatabaseConnection.executeUpdate(sql, teclas, rgb, tipo);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteTeclado: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
