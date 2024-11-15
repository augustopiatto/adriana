package app.DAOs;

import app.helpers.DatabaseConnection;
import app.models.CalcadoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalcadoDAO {
    ObservableList<CalcadoModel> calcadoList = FXCollections.observableArrayList();

    public int createCalcado(int tamanho, String marca) {
        String sql = "INSERT INTO calcado (tamanho, marca) VALUES(?, ?)";
        int calcadoId = 0;

        try {
            calcadoId = DatabaseConnection.executeUpdate(sql, tamanho, marca);
        } catch (SQLException e) {
            System.out.println("Erro no SQL de createCalcado: " + e.getMessage());
        } finally {
            DatabaseConnection.closeResources();
        }
        return calcadoId;
    }

    public ObservableList<CalcadoModel> readCalcado() {
        String sql = "SELECT * FROM calcado ORDER BY marca";

        try(ResultSet resultSet = DatabaseConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                int tamanho = resultSet.getInt("tamanho");
                String marca = resultSet.getString("marca");

                CalcadoModel calcado = new CalcadoModel(tamanho, marca);
                calcadoList.add(calcado);
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL de readCalcado: " + e.getMessage());
        }
        return calcadoList;
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
