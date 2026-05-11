import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    static void main() {
        Scanner s = new Scanner(System.in);
        boolean ativo = true;
        Restaurante restaurante = new Restaurante();
        boolean menuCentral = true;
        boolean cadCliente = false;
        boolean cadFuncionario = false;
        boolean checkFuncionario = false;
        boolean checkCliente = false;
        boolean cadMesas = false;
        boolean checkMesas = false;
        boolean cadReservas = false;
        boolean checkReservas = false;
        boolean cancelReservas = false;
        int menuInput;
        while (ativo) {

            while (menuCentral) {
                System.out.printf("===========================%n" +
                        "Bem vindo ao sistema : restaurante%n" +
                        " 1 - Cadastrar clientes%n" +
                        " 2 - Consultar clientes%n" +
                        " 3 - Cadastrar Funcionários%n" +
                        " 4 - Consultar Funcionário%n" +
                        " 5 - Cadastrar novas mesas%n" +
                        " 6 - Listar mesas disponíveis%n" +
                        " 7 - Fazer Reserva%n" +
                        " 8 - Buscar reservas por cliente%n" +
                        " 9 - Cancelar uma reserva%n" +
                        " 0 - Fechar Sistema%n"+
                        "===========================%n");

                menuInput = s.nextInt(); // \n
                s.nextLine();
                if (menuInput == 1) {
                    cadCliente = true;
                    menuCentral = false;
                } else if (menuInput == 2) {
                    checkCliente = true;
                    menuCentral = false;
                } else if (menuInput == 3) {
                    cadFuncionario = true;
                    menuCentral = false;
                } else if (menuInput == 4) {
                checkFuncionario = true;
                menuCentral = false;
                } else if (menuInput == 5) {
                    menuCentral = false;
                    cadMesas = true;

                } else if (menuInput == 6) {
                    menuCentral = false;
                    checkMesas = true;

                } else if (menuInput == 7) {
                    menuCentral = false;
                    cadReservas = true;

                } else if (menuInput == 8) {
                    menuCentral = false;
                    checkReservas = true;

                } else if (menuInput == 9) {
                    menuCentral = false;
                    cancelReservas = true;

                } else if (menuInput == 0) {
                ativo = false;
                menuCentral = false;
                }
            }
            while (cadCliente) {
                System.out.println("Pressione x para cancelar");
                String[] cadClienteMenu = new String[3];
                for (int i = 0; i < 3; i++) {
                    String cadClienteInput = s.nextLine();
                    if (cadClienteInput.equalsIgnoreCase("x")) {
                        System.out.println("Cancelado");
                        cadCliente = false;
                        menuCentral = true;
                        i = 3;
                    } else {
                        cadClienteMenu[i] = cadClienteInput;
                    }
                 }
                boolean cheio = Arrays.stream(cadClienteMenu).noneMatch(Objects::isNull);
                if (cheio){
                    String nome = cadClienteMenu[0];
                    String nasc = cadClienteMenu[1];
                    LocalDate dNasc = LocalDate.parse(nasc);
                    String telefone = cadClienteMenu[2];
                    Cliente cliente = new Cliente(nome, dNasc, telefone);
                    restaurante.cadastrarCliente(cliente);
                    System.out.println(cliente);
                    System.out.println("Cliente cadastrado com sucesso");
                    cadCliente = false;
                    menuCentral = true;
                }
            }
            while (checkCliente){
                String checkInput;

                System.out.println(restaurante.getClientes());
                System.out.println("Pressione X para sair");
                checkInput = s.next();
                if (checkInput.equalsIgnoreCase("x")){
                    checkCliente = false;
                    menuCentral = true;
                }
            }
            while (cadFuncionario) {
                System.out.println("Pressione x para cancelar");
                String[] cadFuncionarioMenu = new String[6];
                String[] cadFuncionarioInst = new String[6];
                cadFuncionarioInst [0] = "DIGITE A ÁREA DO FUNCIONÁRIO\n"+"ATENDIMENTO | RECEPCAO\n"+"GERENCIA | COZINHA\n";
                cadFuncionarioInst [1] = "Digite o nome";
                cadFuncionarioInst [2] = "Digite a Data de nascimento : Ano-Mês-Dia";
                cadFuncionarioInst [3] = "Digite o Telefone";
                cadFuncionarioInst [4] = "Digite o cpf";
                cadFuncionarioInst [5] = "Digite o salário";

                for (int i = 0; i < 6; i++) {
                    System.out.println(cadFuncionarioInst[i]);
                    String cadFuncionarioInput = s.nextLine();
                    if (cadFuncionarioInput.equalsIgnoreCase("x")) {
                        System.out.println("Cancelado");
                        cadFuncionario = false;
                        menuCentral = true;
                        i = 6;
                    } else {
                        cadFuncionarioMenu[i] = cadFuncionarioInput;
                    }
                }
                boolean cheio = Arrays.stream(cadFuncionarioMenu).noneMatch(Objects::isNull);
                if (cheio){
                    String funcaoInput = cadFuncionarioMenu[0];
                    Funcao funcao = Funcao.valueOf(funcaoInput.trim().toUpperCase());
                    String nome = cadFuncionarioMenu[1];
                    String nasc = cadFuncionarioMenu[2];
                    LocalDate dNasc = LocalDate.parse(nasc);
                    String telefone = cadFuncionarioMenu[3];
                    String cpf = cadFuncionarioMenu[4];
                    String salarioInput = cadFuncionarioMenu[5];
                    double salario = Double.parseDouble(salarioInput);
                    Funcionario funcionario = new Funcionario(funcao, salario, nome, dNasc, telefone, cpf);
                    restaurante.cadastrarFuncionario(funcionario);
                    System.out.println(funcionario.toString());
                    System.out.println("Funcionário cadastrado com sucesso");
                    cadFuncionario = false;
                    menuCentral = true;
                }
            }
            while (checkFuncionario) {
                String checkInput;

                System.out.println(restaurante.getFuncionarios());
                System.out.println("Pressione X para sair");
                checkInput = s.next();
                if (checkInput.equalsIgnoreCase("x")) {
                    checkFuncionario = false;
                    menuCentral = true;
                }

            }
            while (checkReservas) {
                String checkInput;

                System.out.println(restaurante.getReservas());
                System.out.println("Pressione X para sair");
                checkInput = s.next();
                if (checkInput.equalsIgnoreCase("x")) {
                    checkReservas = false;
                    menuCentral = true;
                }
            }
            while (cadReservas) {
                System.out.println("Pressione x para cancelar");
                String[] cadFuncionarioMenu = new String[6];
                String[] cadFuncionarioInst = new String[6];
                cadFuncionarioInst [0] = "DIGITE A ÁREA DO FUNCIONÁRIO\n"+"ATENDIMENTO | RECEPCAO\n"+"GERENCIA | COZINHA\n";
                cadFuncionarioInst [1] = "Digite o nome";
                cadFuncionarioInst [2] = "Digite a Data de nascimento : Ano-Mês-Dia";
                cadFuncionarioInst [3] = "Digite o Telefone";
                cadFuncionarioInst [4] = "Digite o cpf";
                cadFuncionarioInst [5] = "Digite o salário";

                for (int i = 0; i < 6; i++) {
                    System.out.println(cadFuncionarioInst[i]);
                    String cadFuncionarioInput = s.nextLine();
                    if (cadFuncionarioInput.equalsIgnoreCase("x")) {
                        System.out.println("Cancelado");
                        cadFuncionario = false;
                        menuCentral = true;
                        i = 6;
                    } else {
                        cadFuncionarioMenu[i] = cadFuncionarioInput;
                    }
                }
                boolean cheio = Arrays.stream(cadFuncionarioMenu).noneMatch(Objects::isNull);
                if (cheio){
                    String clienteTelefone = cadFuncionarioMenu[0];
                    String mesa = cadFuncionarioMenu[1];
                    String dataHoraInput = cadFuncionarioMenu[2];
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraInput);
                    String qtdPessoasInput = cadFuncionarioMenu[3];
                    int qtdPessoas = Integer.parseInt(qtdPessoasInput);
                    restaurante.criarReservas(clienteTelefone, mesa, dataHora, qtdPessoas);
                    cadReservas = false;
                    menuCentral = true;
                }
            }
        }

    }
}
