package entities;

public class Instrumento {
    private String nome;
    private String tipo;
    private String tamanho;

    public Instrumento(String nome, String tipo, String tamanho) {
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public String descrever() {
        return "Um " + this.tipo + " " + this.tamanho + " que leva o nome de " + this.nome;
    }

    public String reparar() {
        return "Reparado magicamente";
    }

    public String tocar() {
        return "Uma linda melodia";
    }
}
