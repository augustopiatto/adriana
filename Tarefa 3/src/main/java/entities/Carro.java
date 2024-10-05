package entities;

public class Carro {
    private String cor;
    private String marca;
    private float preco;

    public Carro(String cor, String marca, float preco) {
        this.cor = cor;
        this.marca = marca;
        this.preco = preco;
    }

    public String vender() {
        return "Vendido!";
    }

    public String dirigir() {
        return "Vrum vruuuummmm";
    }
}
