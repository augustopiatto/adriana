package app.models;

public class LivroModel {
    private String titulo;
    private String dureza;
    private String estilo;

    public LivroModel(String titulo, String dureza, String estilo) {
        this.titulo = titulo;
        this.estilo = estilo;
        this.dureza = dureza;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {  this.titulo = titulo; }

    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) {  this.estilo = estilo; }

    public String getDureza() { return dureza; }
    public void setDureza(String dureza) {  this.dureza = dureza; }
}
