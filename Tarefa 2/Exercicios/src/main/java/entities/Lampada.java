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

    public void usar(int voltagem) {
        if (voltagem > voltagem) {
            System.out.println("Queimou a lâmpada!");
        } else {
            System.out.println("Um brilho " + this.brilho);
        }
    }

    public String quebrar() {
        return "quebrado";
    }

    public String queimar() {
        return "queimado";
    }
}
