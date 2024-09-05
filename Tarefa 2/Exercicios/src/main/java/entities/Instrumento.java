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

    public void descrever() {
        System.out.println("Um " + this.tipo + " " + this.tamanho + " que leva o nome de " + this.nome);
    }

    public boolean reparar() {
        return true;
    }

    public String tocar() {
        return "uma linda melodia";
    }
}
