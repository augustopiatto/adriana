// Na empresa em que trabalhamos, há tabelas com o gasto de cada mês. Para fechar o balanço
// do primeiro trimestre, precisamos somar o gasto total. Sabendo que, em janeiro, foram gastos
// 15 mil reais, em fevereiro, 23 mil reais e, em março, 17 mil reais, faça um programa que
// calcule e imprima a despesa total no trimestre e a média mensal de gastos.
public class DespesasEmpresa {
    private int despesaJaneiro = 15000;
    private int despesaFevereiro = 23000;
    private int despesaMarco = 17000;
    private int totalTrimestre;
    
    public int calculaDespesasTrimestral() {
        this.totalTrimestre = this.despesaJaneiro + this.despesaFevereiro + this.despesaMarco;
        return this.totalTrimestre;
    }
    
    public double calculaMediaMensal() {
        return this.totalTrimestre / 3;
    } 

     public static void main(String []args) {
        DespesasEmpresa despesasEmpresa = new DespesasEmpresa();
        int despesaTrimestre = despesasEmpresa.calculaDespesasTrimestral();
        double mediaMensal = despesasEmpresa.calculaMediaMensal();
        System.out.println(despesaTrimestre);
        System.out.println(mediaMensal);
     }
}
