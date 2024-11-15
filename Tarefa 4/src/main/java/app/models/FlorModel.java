package app.models;

public class FlorModel {
    private String cor;
    private String estacao;

    public FlorModel(String cor, String estacao) {
        this.cor = cor;
        this.estacao = estacao;
    }

    public String getCor() { return cor; }
    public void setCor(String cor) {  this.cor = cor; }

    public String getEstacao() { return estacao; }
    public void setEstacao(String estacao) {  this.estacao = estacao; }
}
