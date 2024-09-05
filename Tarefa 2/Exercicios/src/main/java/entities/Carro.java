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

    public void pintar(String cor) {
        this.cor = cor;
    }

    public boolean vender() {
        return true;
    }

    public void dirigir() {
        System.out.println("Vrum vruuuummmm");
    }

    public String getCor() {
        return this.cor;
    }
}
