// Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e escreva
// a idade dessa pessoa expressa apenas em dias. Considerar ano com 365 dias e mês com 30 dias. 
public class IdadePessoa {
    private int anos;
    private int meses;
    private int dias;
    
    public int calculaIdadeEmDias(int anos, int meses, int dias) {
        this.anos = anos;
        this.meses = meses;
        this.dias = dias;
        
        return (this.anos * 365) + (this.meses * 30) + this.dias;
    } 

     public static void main(String []args) {
        IdadePessoa ip = new IdadePessoa();
        int dias = ip.calculaIdadeEmDias(1, 2, 30);
        System.out.println(dias);
     }
}
