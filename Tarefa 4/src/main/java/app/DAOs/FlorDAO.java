package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.FlorModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlorDAO {
    ObservableList<FlorModel> florList = FXCollections.observableArrayList();

    public int createFlor(String cor, String estacao) {
        String sql = "INSERT INTO flor (cor, estacao) VALUES(?, ?)";
        int florId = 0;

        try {
            florId = DatabaseConnection.executeUpdate(sql, cor, estacao);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createFlor: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return florId;
    }

    public ObservableList<FlorModel> readFlor() {
        String sql = "SELECT * FROM flor";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                String cor = resultSet.getString("cor");
                String estacao = resultSet.getString("estacao");

                FlorModel flor = new FlorModel(cor, estacao);
                florList.add(flor);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readFlor: " + e.getMessage());
        }
        return florList;
    }

    public int updateFlor(String corAtual, String estacaoAtual, String corNova, String estacaoNova) {
        int generatedKey = 0;
        String sql = "UPDATE flor SET cor = ?, estacao = ? WHERE cor = ? AND estacao = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, corNova, estacaoNova, corAtual, estacaoAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateFlor: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteFlor(String cor, String estacao) {
        String sql = "DELETE FROM flor WHERE cor = ? AND estacao = ?";

        try {
            DatabaseConnection.executeUpdate(sql, cor, estacao);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteFlor: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
