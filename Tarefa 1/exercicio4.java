// O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem do
// distribuidor e dos impostos (aplicados ao custo de fábrica). Supondo que o percentual do
// distribuidor seja de 28% e os impostos de 45%, escrever um algoritmo para ler o custo de
// fábrica de um carro, calcular e escrever o custo final ao consumidor. 
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
