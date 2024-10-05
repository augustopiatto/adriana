package entities;

public class Lampada {
    private int voltagem;
    private String tipo;
    private String brilho;

    public Lampada(int voltagem, String tipo, String brilho) {
        this.voltagem = voltagem;
        this.tipo = tipo;
        this.brilho = brilho;
    }

    public String usar(int voltagem) {
        if (voltagem > this.voltagem) {
            return "Queimou a lâmpada!";
        } else {
            return "Um brilho " + this.brilho;
        }
    }

    public String quebrar() {
        return "Quebrado";
    }

    public String queimar() {
        return "Queimado";
    }
}
