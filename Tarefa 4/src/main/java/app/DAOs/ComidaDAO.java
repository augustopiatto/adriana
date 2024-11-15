package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.ComidaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComidaDAO {
    ObservableList<ComidaModel> comidaList = FXCollections.observableArrayList();

    public int createComida(String nome, String sabor, String textura) {
        String sql = "INSERT INTO comida (nome, sabor, textura) VALUES(?, ?, ?)";
        int comidaId = 0;

        try {
            comidaId = DatabaseConnection.executeUpdate(sql, nome, sabor, textura);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createComida: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return comidaId;
    }

    public ObservableList<ComidaModel> readComida() {
        String sql = "SELECT * FROM comida ORDER BY nome";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String sabor = resultSet.getString("sabor");
                String textura = resultSet.getString("textura");

                ComidaModel comida = new ComidaModel(nome, sabor, textura);
                comidaList.add(comida);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readComida: " + e.getMessage());
        }
        return comidaList;
    }

    public int updateComida(String nomeAtual, String nomeNovo, String saborNovo, String texturaNova) {
        int generatedKey = 0;
        String sql = "UPDATE comida SET nome = ?, sabor = ?, textura = ? WHERE nome = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, nomeNovo, saborNovo, texturaNova, nomeAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateComida: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteComida(String nome) {
        String sql = "DELETE FROM comida WHERE nome = ?";

        try {
            DatabaseConnection.executeUpdate(sql, nome);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteComida: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
