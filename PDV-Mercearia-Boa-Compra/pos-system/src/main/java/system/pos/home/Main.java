package system.pos.home;
import system.pos.service.ProductRegistration;
import system.pos.user.Operator;
import java.util.Scanner;
public class Main {
    private static Operator operador;
    private static Scanner input;
    private static ProductRegistration registration;

    public static void main(String[] args){
        input = new Scanner(System.in);
        operador = new Operator();
//        ProductRegistration registrar = new ProductRegistration(operador);
        System.out.println("=============================");
        System.out.println("Bem vindo(a), a Mercearia boa compra!");
        System.out.println("=============================");
        boolean autentificando = false;

        while(!autentificando){

            System.out.print("Já tem uma conta? ");
            String res = input.nextLine().trim().toLowerCase();

            if(res.equalsIgnoreCase("n") || res.equalsIgnoreCase("não")){
                criarConta(operador);

            }else if(res.equalsIgnoreCase("s") || res.equalsIgnoreCase("sim")){
                if(operador.getLogin() == null){
                    System.err.println("\nNenhuma conta cadastrada.");

                }else{
                    autentificando = fazerLogin();
                }

            }else{
                System.err.println("Resposta inválida!");
            }

        }
        menu();

    }

    private static void menu(){
        registration = new ProductRegistration(operador);
        while(true){
            System.out.println("O que deseja fazer hoje");
            System.out.println("=============================");
            System.out.println("1 - Caixa");
            System.out.println("2 - Movimentar Estoque");
            System.out.println("3 - Relatório");
            System.out.println("4 - sair");
            System.out.println("------------");
            System.out.print("Resposta: ");
            String op = input.nextLine().trim().toLowerCase();
            input.nextLine();
            switch (op){
                case "1": case "caixa":
                    System.out.println("Sistema em andamento");
                    break;
                case"2": case"movimentar estoque":
                    menuEtoque();
                    break;
                case "3": case "relatorio":
                    System.out.println("Sistema em andamento");
                    break;
                case "4": case "sair":
                    System.out.println("Até breve!");
                    return;
                default:
                    System.err.println("Opção não localizada");

            }
        }

    }
    private static boolean fazerLogin(){
        System.out.print("E-mail: ");
        String email = input.nextLine().toLowerCase().trim();

        System.out.print("Password: ");
        String password = input.nextLine().trim();

        if(email.equals(operador.getLogin()) && password.equals(operador.getPassword())){
            System.out.println("Bom vindo(a) novamente " + operador.getName());
            return true;
        }
        System.err.println("\nE-mail ou senha incorreto.");
        return false;
    }

    public static void menuEtoque(){
        System.out.println("=============================");
        System.out.println("Movimentação de Estoque");
        System.out.println("=============================");
        System.out.println("1 - Registrar Produto");
        System.out.println("2 - Consultar Produto");
        System.out.println("3 - Atualizar Produto");
        System.out.println("4 - Deletar Produto");
        String res = input.nextLine().toLowerCase().trim();
        input.nextLine();
        switch (res){
            case "1": case "registrar produto":
                System.out.println("Informe a quantidade de produto que deseja cadastrar");
                System.out.print("Resposta: ");
                int qtd = input.nextInt();
                registration.register(qtd);
                break;
            case "2": case "consultar produto":
                registration.consulation();
                break;
            case "3": case "atualizar produto":
                registration.edit();
                break;
            case "4": case "deletar produto":
                registration.delete();
                break;
            default:
                System.err.println("Opção não localizada");

        }



    }

    public static void criarConta(Operator operador){

        System.out.println("=============================");
        System.out.println("Criando conta!");
        System.out.println("=============================");

        System.out.print("Nome: ");
        operador.setName(input.nextLine().trim().toUpperCase());

        System.out.print("Idade: ");
        operador.setAge(input.nextInt());
        input.nextLine();

        String cpf;
        while (true){
            System.out.print("CPF: ");
            cpf = input.nextLine().trim();
            if(cpf.matches("\\d{11}")){
                break;
            }
            System.out.println("CPF inválido");
        }
        operador.setCpf(cpf);

        char sexo;
        while(true){
            System.out.print("Sexo (M/F): ");
            String s = input.nextLine().trim().toUpperCase();
            if(s.equalsIgnoreCase("M") || s.equalsIgnoreCase("F")){
                sexo = s.charAt(0);
                break;
            }
            System.err.println("Digite M ou F");
        }

        operador.setSex(sexo);

        System.out.print("E-mail: ");
        operador.setLogin(input.nextLine().trim().toLowerCase());

        System.out.print("Password: ");
        operador.setPassword(input.nextLine().trim());

        System.out.println("Conta criada com êxito");


    }
}
