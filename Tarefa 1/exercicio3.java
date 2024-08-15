public class NovoSalario {
    private double salario;
    private double reajuste;
    
    public double calculaNovoSalario(double salario, double reajuste) {
        this.salario = salario;
        this.reajuste = reajuste;
        
        return salario + (salario * reajuste);
    } 

     public static void main(String []args) {
        NovoSalario salario = new NovoSalario();
        double novoSalario = salario.calculaNovoSalario(100, 0.000324);
        double arredondado = Math.round(novoSalario * 100.0) / 100.0;
        System.out.println(arredondado);
     }
}
