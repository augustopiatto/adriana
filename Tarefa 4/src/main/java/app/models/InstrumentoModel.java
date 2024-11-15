package app.models;

public class InstrumentoModel {
    private String nome;
    private String tipo;
    private String tamanho;

    public InstrumentoModel(String nome, String tipo, String tamanho) {
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public String getNome() { return nome; }
    public void setNome(String cor) {  this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {  this.tipo = tipo; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) {  this.tamanho = tamanho; }
}
