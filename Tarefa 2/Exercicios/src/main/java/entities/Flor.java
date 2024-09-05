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

    public void comer() {
        System.out.println("Você faleceu! A flor era venenosa");
    }

    public Optional<String> cheirar(String estacao) {
        if (estacao.equals(this.estacao)) {
            return Optional.of("doce");
        }
        else {
           System.out.println("Não está na época da flor");
            return Optional.empty();
        }
    }

    public void colher() {
        this.colhida = true;
    }

    public boolean getColhida() {
        return this.colhida;
    }
}
