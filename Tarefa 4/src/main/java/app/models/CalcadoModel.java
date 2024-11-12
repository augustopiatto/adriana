package app.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CalcadoModel {
    private SimpleIntegerProperty tamanho;
    private SimpleStringProperty marca;

    public CalcadoModel(int id, String marca){
        this.tamanho = new SimpleIntegerProperty(id);
        this.marca = new SimpleStringProperty(marca);
    }

    public int getTamanho() {   return tamanho.get(); }
    public void setTamanho(int tamanho) {  this.tamanho = new SimpleIntegerProperty(tamanho); }

    public String getMarca() {
        return marca.get();
    }
    public void setMarca(String marca) {
        this.marca = new SimpleStringProperty(marca);
    }
}
