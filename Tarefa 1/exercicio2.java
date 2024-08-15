public class Votacao {
    private int eleitores;
    private int votosBrancos;
    private int votosNulos;
    private int votosValidos;
    
    public String calculaVotos(int eleitores, int votosBrancos, int votosNulos, int votosValidos) {
        this.eleitores = eleitores;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
        this.votosValidos = votosValidos;
        
        int vb = (int)(((double)this.votosBrancos / this.eleitores) * 100);
        int vn = (int)(((double)this.votosNulos / this.eleitores) * 100);
        int vv = (int)(((double)this.votosValidos / this.eleitores) * 100);
        
        return "Porcentagem de votos brancos: " + vb + "% / Porcentagem de votos nulos: " + vn + "% / Porcentagem de votos validos: " + vv + "%";
    } 

     public static void main(String []args) {
        Votacao votacao = new Votacao();
        String votos = votacao.calculaVotos(100, 10, 20, 70);
        System.out.println(votos);
     }
}
