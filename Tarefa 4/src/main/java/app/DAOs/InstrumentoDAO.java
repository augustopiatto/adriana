package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.InstrumentoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstrumentoDAO {
    ObservableList<InstrumentoModel> instrumentoList = FXCollections.observableArrayList();

    public int createInstrumento(String nome, String tipo, String tamanho) {
        String sql = "INSERT INTO instrumento (nome, tipo, tamanho) VALUES(?, ?, ?)";
        int instrumentoId = 0;

        try {
            instrumentoId = DatabaseConnection.executeUpdate(sql, nome, tipo, tamanho);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createInstrumento: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return instrumentoId;
    }

    public ObservableList<InstrumentoModel> readInstrumento() {
        String sql = "SELECT * FROM instrumento ORDER BY nome";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String tipo = resultSet.getString("tipo");
                String tamanho = resultSet.getString("tamanho");

                InstrumentoModel instrumento = new InstrumentoModel(nome, tipo, tamanho);
                instrumentoList.add(instrumento);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readInstrumento: " + e.getMessage());
        }
        return instrumentoList;
    }

    public int updateInstrumento(String nomeAtual, String nomeNovo, String tipoNovo, String tamanhoNovo) {
        int generatedKey = 0;
        String sql = "UPDATE instrumento SET nome = ?, tipo = ?, tamanho = ? WHERE nome = ?";

        try {
            generatedKey = DatabaseConnection.executeUpdate(sql, nomeNovo, tipoNovo, tamanhoNovo, nomeAtual);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de updateInstrumento: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return generatedKey;
    }

    public void deleteInstrumento(String nome) {
        String sql = "DELETE FROM instrumento WHERE nome = ?";

        try {
            DatabaseConnection.executeUpdate(sql, nome);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de deleteInstrumento: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
    }
}
