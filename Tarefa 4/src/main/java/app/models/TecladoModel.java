package app.models;

public class TecladoModel {
    private int teclas;
    private boolean rgb;
    private String tipo;

    public TecladoModel(int teclas, boolean rgb, String tipo) {
        this.teclas = teclas;
        this.tipo = tipo;
        this.rgb = rgb;
    }

    public int getTeclas() { return teclas; }
    public void setTeclas(int teclas) {  this.teclas = teclas; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {  this.tipo = tipo; }

    public boolean getRgb() { return rgb; }
    public void setRgb(boolean rgb) {  this.rgb = rgb; }
}
