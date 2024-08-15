// Ler dois valores (considere que não serão lidos valores iguais) e escrever o maior deles.
public class MaiorValor {
    private double valor1;
    private double valor2;
    
    public double calculaMaior(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;

        return this.valor1 > this.valor2 ? this.valor1 : this.valor2;
    } 

     public static void main(String []args) {
        MaiorValor maiorValor = new MaiorValor();
        double maior = maiorValor.calculaMaior(2005, 2006);
        System.out.println(maior);
     }
}
