import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static void main() {
        Scanner s = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        boolean ativo = true;
        // Cadastro amostra
        restaurante.cadMesa(new Mesa("1", 6));
        restaurante.cadastrarCliente(new Cliente("Fulano Dital",LocalDate.of(2001, 9,11),"8112345678"));
        boolean menuCentral = true;
        boolean cadCliente = false;
        boolean cancelCliente = false;
        boolean cadFuncionario = false;
        boolean checkFuncionario = false;
        boolean cancelFuncionario = false;
        boolean checkCliente = false;
        boolean cadMesas = false;
        boolean checkMesas = false;
        boolean cancelMesas = false;
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
                        " 3 - Remover Clientes%n" +
                        " 4 - Cadastrar Funcionários%n" +
                        " 5 - Consultar Funcionário%n" +
                        " 6 - Remover Funcionário%n" +
                        " 7 - Cadastrar novas mesas%n" +
                        " 8 - Listar mesas disponíveis%n" +
                        " 9 - Remover mesas%n" +
                        " 10 - Fazer Reserva%n" +
                        " 11 - Buscar reservas por cliente%n" +
                        " 12 - Cancelar uma reserva%n" +
                        " 0 - Fechar Sistema%n"+
                        "===========================%n");

                menuInput = s.nextInt();
                s.nextLine();
                if (menuInput == 1) {
                    cadCliente = true;
                    menuCentral = false;
                } else if (menuInput == 2) {
                    checkCliente = true;
                    menuCentral = false;
                } else if (menuInput == 3) {
                    menuCentral = false;
                    cancelCliente = true;
                } else if (menuInput == 4) {
                cadFuncionario = true;
                menuCentral = false;
                } else if (menuInput == 5) {
                    menuCentral = false;
                    checkFuncionario = true;

                } else if (menuInput == 6) {
                    menuCentral = false;
                    cancelFuncionario = true;

                } else if (menuInput == 7) {
                    menuCentral = false;
                    cadMesas = true;

                } else if (menuInput == 8) {
                    menuCentral = false;
                    checkMesas = true;

                } else if (menuInput == 9) {
                    menuCentral = false;
                    cancelMesas= true;

                } else if (menuInput == 10) {
                menuCentral = false;
                cadReservas= true;

                } else if (menuInput == 11) {
                    menuCentral = false;
                    checkReservas = true;

                } else if (menuInput == 12) {
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
                String[] cadClienteInst = new String[3];
                cadClienteInst[0] = "Digite o nome do cliente";
                cadClienteInst[1] = "Digite a Data de nascimento : Dia/Mês/Ano";
                cadClienteInst[2] = "Digite o número de telefone do cliente";
                for (int i = 0; i < 3; i++) {
                    System.out.println(cadClienteInst[i]);
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
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dNasc = LocalDate.parse(nasc, format);
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
            while (cancelCliente){
                System.out.println("Digite o telefone do Cliente");
                String clienteId = s.nextLine();
                restaurante.removeCliente(clienteId);
                System.out.println("Deseja repetir operação? Digite S para sim ou X para finalizar");
                String input = s.nextLine();
                if(input.equalsIgnoreCase("x")){
                    cancelCliente = false;
                    menuCentral =  true;
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
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dNasc = LocalDate.parse(nasc, format);
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
            while (cancelFuncionario){
                System.out.println("Digite o telefone do Funcionário");
                String funcionarioId = s.nextLine();
                restaurante.removeCliente(funcionarioId);
                System.out.println("Deseja repetir operação? Digite S para sim ou X para finalizar");
                String input = s.nextLine();
                if(input.equalsIgnoreCase("x")){
                    cancelFuncionario = false;
                    menuCentral =  true;
                }
            }
            while (cadMesas) {
                System.out.println("Pressione x para cancelar");
                String[] cadMesaMenu = new String[2];
                String[] cadMesaInst = new String[2];
                cadMesaInst[0] = "Digite o número da Mesa";
                cadMesaInst[1] = "Digite a capacidade da mesa";
                for (int i = 0; i < 2; i++) {
                    System.out.println(cadMesaInst[i]);
                    String cadMesaInput = s.nextLine();

                    if (cadMesaInput.equalsIgnoreCase("x")) {
                        System.out.println("Cancelado");
                        cadMesas = false;
                        menuCentral = true;
                        i = 2;
                    } else {
                        cadMesaMenu[i] = cadMesaInput;
                    }
                }

                boolean cheio = Arrays.stream(cadMesaMenu).noneMatch(Objects::isNull);
                if (cheio){
                    String numero = cadMesaMenu[0];
                    String capacidade = cadMesaMenu[1];
                    int cap = Integer.parseInt(capacidade);
                    Mesa mesa = new Mesa(numero, cap);
                    restaurante.cadMesa(mesa);
                    System.out.println(mesa);
                    System.out.println("Mesa cadastrada com sucesso");
                    cadMesas = false;
                    menuCentral = true;
                }
            }
            while (checkMesas) {
                String checkInput;

                System.out.println(restaurante.getMesas());
                System.out.println("Pressione X para sair");
                checkInput = s.next();
                if (checkInput.equalsIgnoreCase("x")) {
                    checkMesas = false;
                    menuCentral = true;
                }

            }
            while (cadReservas) {
                System.out.println("Pressione x para cancelar");
                String[] cadReservaMenu = new String[4];
                String[] cadReservaInst = new String[4];
                cadReservaInst[0] = "Digite o numero do Cliente";
                cadReservaInst[1] = "Digite o número da mesa";
                cadReservaInst[2] = "Digite a Data e a Hora da reserva : Dia/Mês/Ano Hora:Minuto:Segundo";
                cadReservaInst[3] = "Digite o número de pessoas da reserva";


                for (int i = 0; i < 4; i++) {
                    System.out.println(cadReservaInst[i]);
                    String cadReservaInput = s.nextLine();
                    if (cadReservaInput.equalsIgnoreCase("x")) {
                        System.out.println("Cancelado");
                        cadReservas = false;
                        menuCentral = true;
                        i = 4;
                    } else {
                        cadReservaMenu[i] = cadReservaInput;
                    }

                }
                boolean cheio = Arrays.stream(cadReservaMenu).noneMatch(Objects::isNull);
                if (cheio){
                    String clienteTelefone = cadReservaMenu[0];
                    String mesa = cadReservaMenu[1];
                    String dataHoraInput = cadReservaMenu[2];
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraInput, format);
                    String qtdPessoasInput = cadReservaMenu[3];
                    int qtdPessoas = Integer.parseInt(qtdPessoasInput);
                    restaurante.criarReservas(clienteTelefone, mesa, dataHora, qtdPessoas);
                    cadReservas = false;
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
            while (cancelReservas){
                System.out.println("Digite o número da mesa reservada");
                String mesaId = s.nextLine();
                restaurante.cancelReserva(mesaId);
                System.out.println("Deseja repetir operação? Digite S para sim ou X para finalizar");
                String input = s.nextLine();
                if(input.equalsIgnoreCase("x")){
                    cancelReservas = false;
                    menuCentral =  true;
                }
            }

        }

    }
}
