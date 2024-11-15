package app.models;

public class CalcadoModel {
    private int tamanho;
    private String marca;

    public CalcadoModel(int tamanho, String marca){
        this.tamanho = tamanho;
        this.marca = marca;
    }

    public int getTamanho() { return tamanho; }
    public void setTamanho(int tamanho) { this.tamanho = tamanho; }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
