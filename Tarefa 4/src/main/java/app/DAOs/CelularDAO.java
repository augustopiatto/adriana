package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.CelularModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CelularDAO {
    ObservableList<CelularModel> celularList = FXCollections.observableArrayList();

    public int createCelular(String sistemaOperacional, String marca) {
        String sql = "INSERT INTO celular (sistema_operacional, marca) VALUES(?, ?)";
        int celularId = 0;

        try {
            celularId = DatabaseConnection.executeUpdate(sql, sistemaOperacional, marca);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createCelular: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return celularId;
    }

    public ObservableList<CelularModel> readCelular() {
        String sql = "SELECT * FROM celular ORDER BY marca";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                String cor = resultSet.getString("sistema_operacional");
                String marca = resultSet.getString("marca");

                CelularModel celular = new CelularModel(cor, marca);
                celularList.add(celular);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readCelular: " + e.getMessage());
        }
        return celularList;
    }

    public int updateCelular(String sistemaOperacionalAtual, String marcaAtual, String sistemaOperacionalNovo, String marcaNova) {
        int generatedKey = 0;
        String sql = "UPDATE celular SET sistema_operacional = ?, marca = ? WHERE sistema_operacional = ? AND marca = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, sistemaOperacionalNovo, marcaNova, sistemaOperacionalAtual, marcaAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateCelular: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteCelular(String sistemaOperacionalAtual, String marca) {
        String sql = "DELETE FROM celular WHERE sistema_operacional = ? AND marca = ?";

        try {
            DatabaseConnection.executeUpdate(sql, sistemaOperacionalAtual, marca);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteCelular: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
