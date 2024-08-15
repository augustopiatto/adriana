public class CustoCarro {
    private double custoDeFabrica;
    private double custoFinal;
    private double porcentualDistribuidor = 0.28;
    private double porcentualImpostos = 0.45;
    
    public double calculaCustoDoCarro(double custoDeFabrica) {
        this.custoDeFabrica = custoDeFabrica;
        
        this.custoFinal = this.custoDeFabrica + (this.custoDeFabrica * this.porcentualDistribuidor) + (this.custoDeFabrica * this.porcentualImpostos);
        return this.custoFinal;
    } 

     public static void main(String []args) {
        CustoCarro custo = new CustoCarro();
        double custoFinal = custo.calculaCustoDoCarro(100);
        double arredondado = Math.round(custoFinal * 100.0) / 100.0;
        System.out.println(arredondado);
     }
}
