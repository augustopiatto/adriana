package app.models;

public class LivroModel {
    private String titulo;
    private String capa;
    private String estilo;

    public LivroModel(String titulo, String capa, String estilo) {
        this.titulo = titulo;
        this.estilo = estilo;
        this.capa = capa;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {  this.titulo = titulo; }

    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) {  this.estilo = estilo; }

    public String getCapa() { return capa; }
    public void setCapa(String capa) {  this.capa = capa; }
}
