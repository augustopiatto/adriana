package entities;

public class Livro {
    private String titulo;
    private String capa;
    private String estilo;

    public Livro(String titulo, String capa, String estilo) {
        this.titulo = titulo;
        this.estilo = estilo;
        this.capa = capa;
    }

    public String queimar() {
        return "Que coisa horrível de se fazer...";
    }

    public String modificar(String capa) {
        this.capa = capa;
        return "Modificado";
    }

    public String ler() {
        return "Lido";
    }
}
