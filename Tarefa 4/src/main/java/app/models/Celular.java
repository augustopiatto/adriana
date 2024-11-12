package entities;

public class Celular {
    private String sistemaOperacional;
    private String marca;
    public boolean quebrado = false;

    public Celular(String sistemaOperacional, String marca) {
        this.sistemaOperacional = sistemaOperacional;
        this.marca = marca;
    }

    public String derrubar() {
        String resultado;
        if (Math.random() < 0.5) {
            resultado = this.quebrar();
        } else {
            resultado = this.riscarTela();
        }
        return resultado;
    }

    private String quebrar() {
        this.quebrado = true;
        return "Pois quebrou";
    }

    private String riscarTela() {
        if (this.quebrado) {
            return "Celular já estava quebrado";
        } else return "Riscou a tela";
    }
}
