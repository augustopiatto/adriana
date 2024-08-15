// Uma revendedora de carros usados paga a seus funcionários vendedores um salário fixo por mês,
// mais uma comissão também fixa para cada carro vendido e mais 5% do valor das vendas por ele
// efetuadas. Escrever um algoritmo que leia o número de carros por ele vendidos, o valor total
// de suas vendas, o salário fixo e o valor que ele recebe por carro vendido. Calcule e escreva
// o salário final do vendedor.
public class SalarioVendedor {
    private int carrosVendidos;
    private double valorVendas;
    private double salarioFixo;
    private double comissaoPorCarro;
    
    public double calculaSalario(int carrosVendidos, double valorVendas, double salarioFixo, double comissaoPorCarro) {
        this.carrosVendidos = carrosVendidos;
        this.valorVendas = valorVendas;
        this.salarioFixo = salarioFixo;
        this.comissaoPorCarro = comissaoPorCarro;
        
        double salarioFinal = this.salarioFixo + (this.valorVendas * 0.05) + (this.carrosVendidos * this.comissaoPorCarro);

        return salarioFinal;
    } 

     public static void main(String []args) {
        SalarioVendedor salario = new SalarioVendedor();
        double salarioFinal = salario.calculaSalario(2, 160000, 1000, 200);
        double arredondado = Math.round(salarioFinal * 100.0) / 100.0;
        System.out.println(arredondado);
     }
}
