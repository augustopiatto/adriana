package application;

import entities.*;
import java.util.Scanner;

public class TestaClasse {
    Scanner scanner = new Scanner(System.in);

    private void escolhaCalcado() {
        System.out.println("Digite o tamanho do calçado");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a marca do calçado");
        String marca = scanner.nextLine();

        Calcado calcado = new Calcado(tamanho, marca);
        calcado.jogarNosFiosDoPoste();
        calcado.usar();
        calcado.limpar();

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaCarro() {
        System.out.println("Digite a cor do carro");
        String cor = scanner.nextLine();

        System.out.println("Digite a marca do carro");
        String marca = scanner.nextLine();

        System.out.println("Digite o preco do carro");
        float preco = scanner.nextFloat();
        scanner.nextLine();

        Carro carro = new Carro(cor, marca, preco);
        carro.dirigir();
        boolean vendeu = carro.vender();
        System.out.println("Vendeu o carro? " + vendeu);
        carro.pintar("vermelho");
        System.out.println("O carro está com cor " + carro.getCor());

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaCelular() {
        System.out.println("Digite o sistema operacional");
        String sistemaOperacional = scanner.nextLine();

        System.out.println("Digite a marca do celular");
        String marca = scanner.nextLine();

        Celular celular = new Celular(sistemaOperacional, marca);
        celular.derrubar();

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaComida() {
        System.out.println("Digite o nome da comida");
        String nome = scanner.nextLine();

        System.out.println("Digite o sabor da comida");
        String sabor = scanner.nextLine();

        System.out.println("Digite a textura da comida");
        String textura = scanner.nextLine();

        Comida comida = new Comida(nome, sabor, textura);
        comida.reaquecer();
        comida.salgar();
        System.out.println("A comida está com textura " + comida.getTextura());
        System.out.println("A comida está com sabor " + comida.getSabor());
        comida.comer();

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaFlor() {
        System.out.println("Digite a cor da flor");
        String cor = scanner.nextLine();

        System.out.println("Digite a estação que a flor floresce");
        String estacao = scanner.nextLine();

        Flor flor = new Flor(cor, estacao);
        flor.cheirar("primavera");
        flor.colher();
        boolean colhida = flor.getColhida();
        System.out.println(colhida ? "Você colheu a flor" : "Você está admirando a flor");
        flor.comer();

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaInstrumento() {
        System.out.println("Digite o nome do instrumento");
        String nome = scanner.nextLine();

        System.out.println("Digite o tipo do instrumento");
        String tipo = scanner.nextLine();

        System.out.println("Digite o tamanho do instrumento");
        String tamanho = scanner.nextLine();

        Instrumento instrumento = new Instrumento(nome, tipo, tamanho);
        instrumento.descrever();
        String som = instrumento.tocar();
        System.out.println("O instrumento tocou " + som);
        boolean reparado = instrumento.reparar();
        System.out.println("O instrumento está reparado? " + reparado);

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaLampada() {
        System.out.println("Digite a voltagem da lâmpada");
        int voltagem = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o tipo da lâmpada");
        String tipo = scanner.nextLine();

        System.out.println("Digite a brilhosidade da lâmpada");
        String brilho = scanner.nextLine();

        Lampada lampada = new Lampada(voltagem, tipo, brilho);
        lampada.usar(220);
        lampada.queimar();
        lampada.quebrar();

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaLivro() {
        System.out.println("Digite o titulo do livro");
        String titulo = scanner.nextLine();

        System.out.println("Digite a dureza da capa");
        String capa = scanner.nextLine();

        System.out.println("Digite o estilo do livro");
        String estilo = scanner.nextLine();

        Livro livro = new Livro(titulo, capa, estilo);
        String lido = livro.ler();
        System.out.println("O livro está lido? " + lido);
        String modificado = livro.modificar("capa dura");
        System.out.println("A capa está modificada? " + modificado);
        livro.queimar();

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaPorta() {
        System.out.println("Digite a altura da porta");
        float altura = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Digite a cor da porta");
        String cor = scanner.nextLine();

        Porta porta = new Porta(altura, cor);
        porta.abrir();
        porta.fechar();
        porta.pintar("preto");
        String novaCor = porta.getCor();
        System.out.println("A nova cor é " + novaCor);
        boolean estado = porta.getAberta();
        System.out.println("A porta está aberta? " + estado);

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaTeclado() {
        System.out.println("Digite quantas teclas o teclado tem");
        int teclas = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite se o teclado é RGB (true ou false)");
        String rgb = scanner.nextLine();
        boolean ehRgb = Boolean.parseBoolean(rgb);

        System.out.println("Digite o tipo do teclado");
        String tipo = scanner.nextLine();

        Teclado tecladoUm = new Teclado(teclas, ehRgb, tipo);
        Teclado tecladoDois = new Teclado(40, false, "mecânico");
        tecladoUm.digitar("mecânico");
        tecladoUm.comparar(tecladoDois);

        System.out.println("Pressione 'Enter' para voltar ao menu");
        scanner.nextLine();
    }

    private void escolhaOperacao() {
        Fracao doisQuintos = new Fracao(2, 5);
        Fracao tresSetimos = new Fracao(3, 7);
        Fracao resultadoSomaUm = doisQuintos.soma(tresSetimos);
        System.out.println("(2/5) + (3/7) = " + resultadoSomaUm.fracaoSimplificada());

        Fracao quatroTercos = new Fracao(4, 3);
        Fracao doisSetimos = new Fracao(2, 7);
        Fracao resultadoSubtracaoUm = quatroTercos.subtrai(doisSetimos);
        System.out.println("(4/3) - (2/7) = " + resultadoSubtracaoUm.fracaoSimplificada());

        Fracao tresMeios = new Fracao(3, 2);
        Fracao resultadoSomaDois = quatroTercos.soma(doisQuintos);
        Fracao resultadoSomaTres = resultadoSomaDois.soma(tresMeios);
        System.out.println("(4/3) + (2/5) + (3/2) = " + resultadoSomaTres.fracaoSimplificada());

        Fracao dezTercos = new Fracao(10, 3);
        Fracao resultadoSubtracaoDois = dezTercos.subtrai(quatroTercos);
        System.out.println("(10/3) - (4/3) = " + resultadoSubtracaoDois.fracaoSimplificada());

        Fracao dois = new Fracao(2, 1);
        Fracao umTerco = new Fracao(1, 3);
        Fracao cincoQuartos = new Fracao(5, 4);
        Fracao resultadoSomaQuatro = dois.soma(umTerco);
        Fracao resultadoSubtracaoTres = resultadoSomaQuatro.subtrai(cincoQuartos);
        System.out.println("2 + (1/3) + (5/4) = " + resultadoSubtracaoTres.fracaoSimplificada());

        Fracao cincoMeios = new Fracao(5, 2);
        Fracao resultadoSubtracaoQuatro = quatroTercos.subtrai(doisQuintos);
        Fracao resultadoMultiplicacaoUm = resultadoSubtracaoQuatro.multiplica(cincoMeios);
        System.out.println("(5/2) x ((4/3) - (2/5)) = " + resultadoMultiplicacaoUm.fracaoSimplificada());

        Fracao cinco = new Fracao(5, 1);
        Fracao resultadoSomaCinco = cinco.soma(doisSetimos);
        System.out.println("5 + (2/7) = " + resultadoSomaCinco.fracaoSimplificada());

        Fracao cincoTercos = new Fracao(5, 3);
        Fracao setimoQuartos = new Fracao(7, 4);
        Fracao resultadoMultiplicacaoDois = cincoTercos.multiplica(setimoQuartos);
        System.out.println("(5/3) * (7/4) = " + resultadoMultiplicacaoDois.fracaoSimplificada());

        Fracao resultadoDivisaoUm = cincoQuartos.divide(umTerco);
        System.out.println("(5/4) / (1/3) = " + resultadoDivisaoUm.fracaoSimplificada());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestaClasse classe = new TestaClasse();
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Classe Calçado");
            System.out.println("2. Classe Carro");
            System.out.println("3. Classe Celular");
            System.out.println("4. Classe Comida");
            System.out.println("5. Classe Flor");
            System.out.println("6. Classe Instrumento");
            System.out.println("7. Classe Lâmpada");
            System.out.println("8. Classe Livro");
            System.out.println("9. Classe Porta");
            System.out.println("10. Classe Teclado");
            System.out.println("11. Operações matemáticas");
            System.out.println("12. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Você escolheu a Opção 1");
                    classe.escolhaCalcado();
                    break;
                case 2:
                    System.out.println("Você escolheu a Opção 2");
                    classe.escolhaCarro();
                    break;
                case 3:
                    System.out.println("Você escolheu a Opção 3");
                    classe.escolhaCelular();
                    break;
                case 4:
                    System.out.println("Você escolheu a Opção 4");
                    classe.escolhaComida();
                    break;
                case 5:
                    System.out.println("Você escolheu a Opção 5");
                    classe.escolhaFlor();
                    break;
                case 6:
                    System.out.println("Você escolheu a Opção 6");
                    classe.escolhaInstrumento();
                    break;
                case 7:
                    System.out.println("Você escolheu a Opção 7");
                    classe.escolhaLampada();
                    break;
                case 8:
                    System.out.println("Você escolheu a Opção 8");
                    classe.escolhaLivro();
                    break;
                case 9:
                    System.out.println("Você escolheu a Opção 9");
                    classe.escolhaPorta();
                    break;
                case 10:
                    System.out.println("Você escolheu a Opção 10");
                    classe.escolhaTeclado();
                    break;
                case 11:
                    System.out.println("Você escolheu a Opção 10");
                    classe.escolhaOperacao();
                    break;
                case 12:
                    System.out.println("Saindo...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }
        scanner.close();

//        Celular celular = new Celular("android", "Samsung");
//        celular.derrubar();
//        System.out.println("O celular está quebrado? " + celular.quebrado);
//
//        Porta porta = new Porta(3, "verde");
//        porta.pintar("laranja");
//        porta.abrir();
//        porta.fechar();
//
//        Teclado teclado = new Teclado(42, true, "mecânico");
//        String textoDigitado = teclado.digitar("funcionou?");
//        System.out.println("O novo texto é " + textoDigitado);
//        Teclado segundoTeclado = new Teclado(38, false, "membrana");
//        teclado.comparar(segundoTeclado);
//
//        Livro livro = new Livro("O nome do vento", "dura", "fantasia");
//        String lido = livro.ler();
//        System.out.println("Livro foi " + lido);
//        String capa = livro.modificar("mole");
//        System.out.println("A nova capa é " + capa);
//
//        Lampada lampada = new Lampada(110, "RGB", "intenso");
//        lampada.usar(220);
//        lampada.quebrar();
//
//        Instrumento instrumento = new Instrumento("Oboé", "sopro", "médio");
//        String som = instrumento.tocar();
//        System.out.println("O som é " + som);
//        boolean reparado = instrumento.reparar();
//        System.out.println("Foi reparado? " + reparado);
//
//        Flor flor = new Flor("vermelha", "primavera");
//        flor.cheirar("inverno");
//        flor.colher();
//
//        Comida comida = new Comida("Risoto", "salgado", "empapado");
//        comida.aquecer();
//        comida.comer(comida);
//
//        Carro carro = new Carro("preto", "Volkswagen", 80000);
//        carro.dirigir();
//        boolean vendido = carro.vender();
//        System.out.println("Foi vendido? " + vendido);
    }
}
