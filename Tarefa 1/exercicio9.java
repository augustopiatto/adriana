// As maçãs custam R$ 1,30 cada se forem compradas menos de uma dúzia, e R$ 1,00 se forem
// compradas pelo menos doze. Escreva um programa que leia o número de maçãs compradas,
// calcule e escreva o custo total da compra.
public class CustoMacas {
    private int quantidadeMacas;
    
    public double calculaValoresMacas(int quantidadeMacas) {
        this.quantidadeMacas = quantidadeMacas;

        return this.quantidadeMacas >= 12 ? quantidadeMacas : quantidadeMacas * 1.3;
    } 

     public static void main(String []args) {
        CustoMacas custoMacas = new CustoMacas();
        double valorMacas = custoMacas.calculaValoresMacas(12);
        System.out.println("R$" + valorMacas);
     }
}
