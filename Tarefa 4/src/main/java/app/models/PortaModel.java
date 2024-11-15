package app.models;

public class PortaModel {
    private float altura;
    private String cor;

    public PortaModel(float altura, String cor) {
        this.altura = altura;
        this.cor = cor;
    }

    public float getAltura() { return altura; }
    public void setAltura(float altura) {  this.altura = altura; }

    public String getCor() { return cor; }
    public void setCor(String cor) {  this.cor = cor; }
}
