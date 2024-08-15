// Ler um valor e escrever se é positivo ou negativo (considere o valor zero como positivo).
public class PositivoNegativo {
    private double valor;
    
    public boolean checaSePositivoOuNegativo(double valor) {
        this.valor = valor;

        return this.valor >= 0 ? true : false;
    } 

     public static void main(String []args) {
        PositivoNegativo positivoNegativo = new PositivoNegativo();
        boolean ehPositivo = positivoNegativo.checaSePositivoOuNegativo(0);
        System.out.println(ehPositivo ? "Positivo" : "Negativo");
     }
}
