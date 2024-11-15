package entities;

public class LampadaModel {
    private int voltagem;
    private String tipo;
    private String brilho;

    public LampadaModel(int voltagem, String tipo, String brilho) {
        this.voltagem = voltagem;
        this.tipo = tipo;
        this.brilho = brilho;
    }

    public int getVoltagem() { return voltagem; }
    public void setVoltagem(int voltagem) {  this.voltagem = voltagem; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {  this.tipo = tipo; }

    public String getBrilho() { return brilho; }
    public void setBrilho(String brilho) {  this.brilho = brilho; }
}
