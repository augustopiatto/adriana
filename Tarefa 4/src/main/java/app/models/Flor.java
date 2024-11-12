package entities;
import java.util.Optional;

public class Flor {
    private String cor;
    private boolean colhida = false;
    private String estacao;

    public Flor(String cor, String estacao) {
        this.cor = cor;
        this.estacao = estacao;
    }

    public String comer() {
        return "Você faleceu! A flor era venenosa";
    }

    public String cheirar() {
        if (this.estacao.equals("primavera")) {
            return "doce";
        }
        else {
           return "Não está na época da flor";
        }
    }

    public String colher() {
        return "Flor colhida";
    }

}
