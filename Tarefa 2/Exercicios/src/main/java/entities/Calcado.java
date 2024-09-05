package entities;

public class Calcado {
    private int tamanhoBr;
    private String marca;
    private boolean limpo = true;

    public Calcado(int tamanhoBr, String marca) {
        this.tamanhoBr = tamanhoBr;
        this.marca = marca;
    }

    public void usar() {
        this.limpo = false;
        System.out.println("O calçado está sujo");
    }

    public void limpar() {
        this.limpo = true;
        System.out.println("O calçado está limpo");

    }

    public void jogarNosFiosDoPoste() {
        System.out.println("Você jogou o calçado na fiação!");
    }
}
