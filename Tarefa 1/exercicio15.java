// A jornada de trabalho semanal de um funcionário é de 40 horas. O funcionário que trabalhar
// mais de 40 horas receberá hora extra, cujo cálculo é o valor da hora regular com um acréscimo
// de 50%. Escreva um algoritmo que leia o número de horas trabalhadas em um mês, o salário por
// hora e escreva o salário total do funcionário, que deverá ser acrescido das horas extras,
// caso tenham sido trabalhadas (considere que o mês possua 4 semanas exatas).
public class SalarioFuncionario {
    private int horasTrabalhadas;
    private double salarioPorHora;
    private double salarioTotal;
    
    public double calculaSalario(int horasTrabalhadas, double salarioPorHora) {
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioPorHora = salarioPorHora;
        
        this.salarioTotal = (this.salarioPorHora * 40 * 4);
        if (this.horasTrabalhadas > 160) {
            this.salarioTotal = this.salarioTotal + ((this.horasTrabalhadas - 160) * this.salarioPorHora * 1.5);
        }
        return this.salarioTotal;
    } 

     public static void main(String []args) {
        SalarioFuncionario salarioFuncionario = new SalarioFuncionario();
        double salario = salarioFuncionario.calculaSalario(170, 10);
        System.out.println(salario);
     }
}
