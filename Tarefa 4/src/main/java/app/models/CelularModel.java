package app.models;

public class CelularModel {
    private String sistemaOperacional;
    private String marca;

    public CelularModel(String sistemaOperacional, String marca) {
        this.sistemaOperacional = sistemaOperacional;
        this.marca = marca;
    }

    public String getSistemaOperacional() { return sistemaOperacional; }
    public void setSistemaOperacional(String sistemaOperacional) {  this.sistemaOperacional = sistemaOperacional; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) {  this.marca = marca; }
}
