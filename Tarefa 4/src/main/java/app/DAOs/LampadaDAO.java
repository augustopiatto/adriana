package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.CarroModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LampadaDAO {
    ObservableList<CarroModel> carroList = FXCollections.observableArrayList();

    public int createCarro(String cor, String marca, float preco) {
        String sql = "INSERT INTO carro (cor, marca, preco) VALUES(?, ?, ?)";
        int carroId = 0;

        try {
            carroId = DatabaseConnection.executeUpdate(sql, cor, marca, preco);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createCarro: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return carroId;
    }

    public ObservableList<CarroModel> readCarro() {
        String sql = "SELECT * FROM carro ORDER BY marca";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                String cor = resultSet.getString("cor");
                String marca = resultSet.getString("marca");
                float preco = resultSet.getFloat("preco");

                CarroModel carro = new CarroModel(cor, marca, preco);
                carroList.add(carro);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readCarro: " + e.getMessage());
        }
        return carroList;
    }

    public int updateCarro(String corAtual, String marcaAtual, String corNova, String marcaNova, float precoNovo) {
        int generatedKey = 0;
        String sql = "UPDATE carro SET cor = ?, marca = ?, preco = ? WHERE cor = ? AND marca = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, corNova, marcaNova, precoNovo, corAtual, marcaAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateCarro: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteCarro(String cor, String marca) {
        String sql = "DELETE FROM carro WHERE cor = ? AND marca = ?";

        try {
            DatabaseConnection.executeUpdate(sql, cor, marca);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteCarro: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
