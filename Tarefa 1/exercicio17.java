// Programa que leia as notas e calcule a média de LP1 deste semestre, referente a um determinado aluno.
// Fórmula para cálculo de média de LP1.
// (P1*0.6+((E1+E2)/2)*0.4)*0.5+(max(((P1*0.6+((E1+E2)/2)*0.4)-5.9),0)/((P1*0.6+((E1+E2)/2)*0.4)-5.9))*(API*0.5)+X+(SUB*0.2)
public class NotaAluno {
    private double P1;
    private double E1;
    private double E2;
    private double API;
    private double X;
    private double SUB;
    private double notaFinal;
    
    public double calculaNotaLP1(double P1, double E1, double E2, double API, double X, double SUB) {
        this.P1 = P1;
        this.E1 = E1;
        this.E2 = E2;
        this.API = API;
        this.X = X;
        this.SUB = SUB;

        this.notaFinal = (this.P1*0.6+((this.E1+this.E2)/2)*0.4)*0.5+(Math.max(((this.P1*0.6+((this.E1+this.E2)/2)*0.4)-5.9),0)/((this.P1*0.6+((this.E1+this.E2)/2)*0.4)-5.9))*(this.API*0.5)+this.X+(this.SUB*0.2);

        return this.notaFinal;
    }

     public static void main(String []args) {
        NotaAluno notaAluno = new NotaAluno();
        double nota = notaAluno.calculaNotaLP1(9, 8, 7, 6, 5, 4);
        System.out.println(nota);
     }
}
