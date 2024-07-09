import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        RecuperaMoeda consultaMoeda = new RecuperaMoeda();

        System.out.println("*************************************************");
        System.out.println("Seja bem vindo/a ao Conversor de Moeda =]");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileiro");
        System.out.println("4) Real brasileiro =>> Dólar");
        System.out.println("5) Dólar =>> Peso Colombiano");
        System.out.println("6) Peso Colombiano =>> Dólar");
        System.out.println("7) Sair");
        System.out.println("Escolha uma opção válida: ");
        System.out.println("*************************************************");

        var opcao = leitura.nextLine();

        var moeda = "";
        var moeda2 = "";

        switch (opcao) {
            case "1" -> {
                moeda = "USD";
                moeda2 = "ARS";
               }
            case "2" -> {
                moeda = "ARS";
                moeda2 = "USD";
            }
            case "3" -> {
                moeda = "USD";
                moeda2 = "BRL";
            }
            case "4" -> {
                moeda = "BRL";
                moeda2 = "USD";
            }
            case "5" -> {
                moeda = "USD";
                moeda2 = "COP";
            }
            case "6" -> {
                moeda = "COP";
                moeda2 = "USD";
            }
            case "7" -> {
                System.out.println("Finalizando a aplicação");
                System.exit(0);
            }
            default -> {
                System.out.println("Número inválido");
                System.exit(0);
            }

        }
        System.out.println("Digite o valor que deseja converter: ");
        double valor = leitura.nextDouble();
        try {
            Moeda novaMoeda = consultaMoeda.buscaMoeda(moeda, moeda2);
            double valorConvertido = novaMoeda.conversion_rate();
            double resultado = valor * valorConvertido;
            System.out.println("Valor " + valor + " [" + moeda + "] " + "corresponde ao valor final de =>>> " + resultado + " [" + moeda2 + "]");
        }

        catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
    }

