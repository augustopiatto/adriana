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
