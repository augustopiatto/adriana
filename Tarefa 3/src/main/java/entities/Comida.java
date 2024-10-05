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

    public String comer() {
        return "Você comeu tudo!!!";
    }

    public String reaquecer() {
        return "Insossa";
    }

    public String salgar() {
        return "Gostoso";
    }
}
