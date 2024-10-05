package entities;

public class Teclado {
    private int teclas;
    private boolean rgb;
    private String tipo;

    public Teclado(int teclas, boolean rgb, String tipo) {
        this.teclas = teclas;
        this.tipo = tipo;
        this.rgb = rgb;
    }

    public String comparar(Teclado teclado) {
        if (this.teclas > teclado.trazTeclas()) {
            return "O teclado " + this.tipo + (this.rgb ? " com RGB" : " sem RGB") + " tem mais teclas";
        } else {
            return "O teclado " + teclado.trazTipo() + (teclado.trazRGB() ? " com RGB" : " sem RGB") + " tem mais teclas";
        }
    }

    public int trazTeclas() {
        return this.teclas;
    }

    public boolean trazRGB() {
        return this.rgb;
    }

    public String trazTipo() {
        return this.tipo;
    }

    public String digitar(String texto) {
        if (this.tipo.equals("mecânico")) {
            return "Que teclado barulhento!";
        };
        return texto;
    }
}
