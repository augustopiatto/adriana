package entities;

public class Fracao {
    private int numerador;
    private int denominador;

    public Fracao(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fracao soma(Fracao numero) {
        int multDenominador = this.denominador * numero.denominador;
        int novoNumeradorUm = multDenominador / this.denominador * this.numerador;
        int novoNumeradorDois = multDenominador / numero.denominador * numero.numerador;
        int novoNumerador = novoNumeradorUm + novoNumeradorDois;
        Fracao novaFracao = new Fracao(novoNumerador, multDenominador);

        return novaFracao;
    }

    public Fracao subtrai(Fracao numero) {
        int multDenominador = this.denominador * numero.denominador;
        int novoNumeradorUm = multDenominador / this.denominador * this.numerador;
        int novoNumeradorDois = multDenominador / numero.denominador * numero.numerador;
        int novoNumerador = novoNumeradorUm - novoNumeradorDois;
        Fracao novaFracao = new Fracao(novoNumerador, multDenominador);

        return novaFracao;
    }

    public Fracao multiplica(Fracao numero) {
        int novoNumerador = this.numerador * numero.numerador;
        int novoDenominador = this.denominador * numero.denominador;
        Fracao novaFracao = new Fracao(novoNumerador, novoDenominador);

        return novaFracao;
    }

    public Fracao divide(Fracao numero) {
        int novoNumerador = this.numerador * numero.denominador;
        int novoDenominador = this.denominador * numero.numerador;
        Fracao novaFracao = new Fracao(novoNumerador, novoDenominador);

        return novaFracao;
    }

    public String fracaoSimplificada() {
        int mdc = calcularMDC(this.numerador, this.denominador);

        int novoNumerador = this.numerador / mdc;
        int novoDenominador = this.denominador / mdc;

        return String.valueOf(novoNumerador) + "/" + String.valueOf(novoDenominador);
    }

    // Copiado do ChatGPT, mas entendi o conceito
    private static int calcularMDC(int numerador, int denominador) {
        if (denominador == 0) {
            return numerador;
        }
        return calcularMDC(denominador, numerador % denominador);
    }
}
