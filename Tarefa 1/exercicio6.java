// Escreva um algoritmo para ler uma temperatura em graus Fahrenheit, calcular e escrever o
// valor correspondente em graus Celsius. Observação: Para testar se a sua resposta está
// correta saiba que 100°C = 212°F
public class FahrenheitECelsius {
    private double tempFahrenheit;
    private double tempCelsius;
    
    public double converteTemperatura(double tempFahrenheit) {
        this.tempFahrenheit = tempFahrenheit;
        
        this.tempCelsius = 5 * ((this.tempFahrenheit - 32) /  9);

        return this.tempCelsius;
    } 

     public static void main(String []args) {
        FahrenheitECelsius conversorTemperatura = new FahrenheitECelsius();
        double tempCelsius = conversorTemperatura.converteTemperatura(115);
        double arredondado = Math.round(tempCelsius * 100.0) / 100.0;
        System.out.println(arredondado);
     }
}
