package app.models;

public class ComidaModel {
    private String nome;
    private String sabor;
    private String textura;

    public ComidaModel(String nome, String sabor, String textura) {
        this.nome = nome;
        this.sabor = sabor;
        this.textura = textura;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) {  this.nome = nome; }

    public String getSabor() { return sabor; }
    public void setSabor(String sabor) {  this.sabor = sabor; }

    public String getTextura() { return textura; }
    public void setTextura(String textura) {  this.textura = textura; }
}
