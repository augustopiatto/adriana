// Ler as notas da 1a. e 2a. avaliações de um aluno. Calcular a média aritmética simples e
// escrever uma mensagem que diga se o aluno foi ou não aprovado (considerar que nota igual
// ou maior que 6 o aluno é aprovado). Escrever também a média calculada. 
public class MediaAluno {
    private double prova1;
    private double prova2;
    
    public double calculaMedia(double prova1, double prova2) {
        this.prova1 = prova1;
        this.prova2 = prova2;

        return (this.prova1 + this.prova2) / 2;
    } 

     public static void main(String []args) {
        MediaAluno mediaAluno = new MediaAluno();
        double media = mediaAluno.calculaMedia(5, 5);
        System.out.println(media >= 6 ? "Aluno aprovado" : "Aluno reprovado");
        System.out.println(media);
     }
}
