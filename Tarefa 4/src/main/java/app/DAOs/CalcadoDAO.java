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
}
