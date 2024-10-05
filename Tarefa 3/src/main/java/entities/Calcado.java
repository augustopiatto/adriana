package entities;

import javafx.scene.control.TextField;

public class Calcado {
    private int tamanhoBr;
    private TextField marca;
    private boolean limpo = true;

    public Calcado(int tamanhoBr, TextField marca) {
        this.tamanhoBr = tamanhoBr;
        this.marca = marca;
    }

    public String usar() {
        this.limpo = false;
        return "O calçado está sujo";
    }

    public String limpar() {
        this.limpo = true;
        return "O calçado está limpo";
    }

    public String jogarNosFiosDoPoste() {
        return "Você jogou o calçado na fiação!";
    }
}
