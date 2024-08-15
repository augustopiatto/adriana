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
