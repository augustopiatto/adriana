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

    public void queimar() {
        System.out.println("Que coisa horrível de se fazer...");
    }

    public String modificar(String capa) {
        this.capa = capa;
        return "modificado";
    }

    public String ler() {
        return "lido";
    }
}
