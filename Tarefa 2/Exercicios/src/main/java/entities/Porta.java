package entities;

public class Porta {
    private float altura;
    private String cor;
    private boolean aberta = false;

    public Porta(float altura, String cor) {
        this.altura = altura;
        this.cor = cor;
    }

    public void pintar(String cor) {
        this.cor = cor;
    }

    public void abrir() {
        this.aberta = true;
    }

    public void fechar() {
        this.aberta = false;
    }

    public boolean getAberta() {
        return this.aberta;
    }

    public String getCor() {
        return this.cor;
    }
}
