package entities;

public class Comida {
    private String nome;
    private String sabor;
    private String textura;

    public Comida(String nome, String sabor, String textura) {
        this.nome = nome;
        this.sabor = sabor;
        this.textura = textura;
    }

    public void comer() {
        System.out.println("Você comeu tudo!!!");
    }

    public void reaquecer() {
        this.textura = "insossa";
    }

    public void salgar() {
        this.sabor = "gostoso";
    }

    public String getTextura() {
        return this.textura;
    }

    public String getSabor() {
        return this.sabor;
    }
}
