// Ler dois valores (considere que não serão lidos valores iguais) e escrevê-los em ordem crescente.
public class MaiorValor {
    private double valor1;
    private double valor2;
    
    public double[] ordenaCrescentemente(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        double[] numeros = new double[2];
        if (this.valor1 < this.valor2) {
            numeros[0] = this.valor1;
            numeros[1] = this.valor2;
        } else {
            numeros[0] = this.valor2;
            numeros[1] = this.valor1;
        }
        return numeros;
    } 

     public static void main(String []args) {
        MaiorValor maiorValor = new MaiorValor();
        double[] numerosOrdenados = maiorValor.ordenaCrescentemente(2005, 2006);
        System.out.println(numerosOrdenados[0]);
        System.out.println(numerosOrdenados[1]);
     }
}
