// Ler o ano atual e o ano de nascimento de uma pessoa. Escrever uma mensagem que diga se
// ela poderá ou não votar este ano (não é necessário considerar o mês em que a pessoa nasceu).
public class MaiorDeIdade {
    private int anoNascimento;
    private int anoAtual;
    
    public int calculaIdade(int anoAtual, int anoNascimento) {
        this.anoNascimento = anoNascimento;
        this.anoAtual = anoAtual;

        return this.anoAtual - anoNascimento;
    } 

     public static void main(String []args) {
        MaiorDeIdade maiorDeIdade = new MaiorDeIdade();
        int idade = maiorDeIdade.calculaIdade(2024, 2006);
        System.out.println(idade >= 18 ? "Você pode votar" : "Você NÃO pode votar");
     }
}
