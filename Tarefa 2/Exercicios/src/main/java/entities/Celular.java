package entities;

public class Celular {
    private String sistemaOperacional;
    private String marca;
    public boolean quebrado = false;

    public Celular(String sistemaOperacional, String marca) {
        this.sistemaOperacional = sistemaOperacional;
        this.marca = marca;
    }

    public void derrubar() {
        if (Math.random() < 0.5) {
            this.quebrar();
        } else {
            this.riscarTela();
        }
    }

    private void quebrar() {
        this.quebrado = true;
    }

    private void riscarTela() {
        if (this.quebrado) {
            System.out.println("Celular já estava quebrado");
        } else System.out.println("Riscou a tela");
    }
}
