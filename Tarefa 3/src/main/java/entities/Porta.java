package entities;

public class Porta {
    private float altura;
    private String cor;

    public Porta(float altura, String cor) {
        this.altura = altura;
        this.cor = cor;
    }

    public String abrir() {
        return "Abriu a porta";
    }

    public String fechar() {
        return "Fechou a porta";
    }
}
