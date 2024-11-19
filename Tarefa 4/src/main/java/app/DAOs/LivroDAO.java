package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.LivroModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO {
    ObservableList<LivroModel> livroList = FXCollections.observableArrayList();

    public int createLivro(String titulo, String dureza, String estilo) {
        String sql = "INSERT INTO livro (titulo, dureza, estilo) VALUES(?, ?, ?)";
        int livroId = 0;

        try {
            livroId = DatabaseConnection.executeUpdate(sql, titulo, dureza, estilo);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createLivro: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return livroId;
    }

    public ObservableList<LivroModel> readLivro() {
        String sql = "SELECT * FROM livro";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String dureza = resultSet.getString("dureza");
                String estilo = resultSet.getString("estilo");

                LivroModel livro = new LivroModel(titulo, dureza, estilo);
                livroList.add(livro);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readLivro: " + e.getMessage());
        }
        return livroList;
    }

    public int updateLivro(String tituloAtual, String durezaAtual, String estiloAtual, String tituloNovo, String durezaNova, String estiloNovo) {
        int generatedKey = 0;
        String sql = "UPDATE livro SET titulo = ?, dureza = ?, estilo = ? WHERE titulo = ? AND dureza = ? AND estilo = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, tituloNovo, durezaNova, estiloNovo, tituloAtual, durezaAtual, estiloAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateLivro: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteLivro(String titulo, String dureza, String estilo) {
        String sql = "DELETE FROM livro WHERE titulo = ? AND dureza = ? AND estilo = ?";

        try {
            DatabaseConnection.executeUpdate(sql, titulo, dureza, estilo);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteLivro: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
