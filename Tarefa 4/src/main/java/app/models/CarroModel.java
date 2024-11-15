package app.models;

public class CarroModel {
    private String cor;
    private String marca;
    private float preco;

    public CarroModel(String cor, String marca, float preco) {
        this.cor = cor;
        this.marca = marca;
        this.preco = preco;
    }

    public String getCor() { return cor; }
    public void setCor(String cor) {  this.cor = cor; }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
