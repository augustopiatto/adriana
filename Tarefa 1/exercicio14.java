// Ler a hora de início e a hora de fim de um jogo de Xadrez (considere apenas horas inteiras,
// sem os minutos) e calcule a duração do jogo em horas, sabendo-se que o tempo máximo de
// duração do jogo é de 24 horas e que o jogo pode iniciar em um dia e terminar no dia seguinte.
public class JogoXadrez {
    private int inicio;
    private int fim;
    private int duracao;
    
    private boolean estaEntre(int valor, int inicio, int fim) {
        for (int atual = inicio; atual < fim; atual++) {
            if (valor == atual) {
                return true;
            }
        }
        return false;
    }
    
    public int calculaTempoPartida(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
        
        if (this.inicio == this.fim) {
            this.duracao = 24;
        } else if (this.estaEntre(this.fim, this.inicio, 24)) {
            this.duracao = this.fim - this.inicio;
        } else {
            this.duracao = 24 - this.inicio + this.fim;
        }

        return this.duracao;
    } 

     public static void main(String []args) {
        JogoXadrez jogoXadrez = new JogoXadrez();
        int duracao = jogoXadrez.calculaTempoPartida(17, 15);
        System.out.println(duracao);
     }
}
