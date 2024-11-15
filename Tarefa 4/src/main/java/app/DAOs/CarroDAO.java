package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.CarroModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO {
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

    public int updateCalcado(int tamanhoAtual, String marcaAtual, int tamanhoNovo, String marcaNova) {
        int generatedKey = 0;
        String sql = "UPDATE calcado SET tamanho = ?, marca = ? WHERE tamanho = ? AND marca = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, tamanhoNovo, marcaNova, tamanhoAtual, marcaAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateCalcado: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteCalcado(int tamanho, String marca) {
        String sql = "DELETE FROM calcado WHERE tamanho = ? AND marca = ?";

        try {
            DatabaseConnection.executeUpdate(sql, tamanho, marca);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteCalcado: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
