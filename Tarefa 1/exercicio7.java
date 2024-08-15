// Ler um valor e escrever a mensagem É MAIOR QUE 10! se o valor lido for maior que 10,
// caso contrário escrever NÃO É MAIOR QUE 10! 
public class MaiorQueDez {
    private double valor;
    
    public boolean checaSeMaiorQueDez(double valor) {
        this.valor = valor;

        return this.valor > 10 ? true : false;
    } 

     public static void main(String []args) {
        MaiorQueDez maiorQueDez = new MaiorQueDez();
        boolean ehMaior = maiorQueDez.checaSeMaiorQueDez(-1);
        System.out.println(ehMaior ? "É MAIOR QUE 10!" : "NÃO É MAIOR QUE 10!");
     }
}
