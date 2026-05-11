import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurante {


    // esse <> no ArrayList significa o tipo de objeto guardado dentro da lista
    private List<Cliente> clientes;
    private List<Mesa> mesas;
    private List<Reserva> reservas;
    private List<Funcionario> funcionarios;
    private boolean autorizado;

    public Restaurante() {
        this.clientes = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente){
        var a = clientes.contains(cliente);
        this.clientes.add(cliente);
    }
    public void criarReservas(String cliente, String mesa, LocalDateTime dataHora, int qtdPessoas){
        Cliente cliente1 = null;
        Mesa mesa1 = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cliente)){
                cliente1 = clientes.get(i);
                break;
            }
        }
        for (int i = 0; i < clientes.size(); i++) {
            if (mesas.get(i).getNumeracao().equals(mesa)){
                mesa1 = mesas.get(i);
                break;
            }
        }

        Reserva reserva = new Reserva(cliente1, mesa1, dataHora, qtdPessoas);


        if (this.reservas.contains(reserva)) {
            System.out.println("Essa reserva já existe.");
        } else {
            this.reservas.add(reserva);
            System.out.println("Reserva feita!");
        }
    }

    public String getReservas(){
        if (this.reservas.isEmpty()) {
            return "Não existem reserva feitas.";
        }
        return this.reservas.stream().map(Reserva::toString).collect(Collectors.joining("\n"));
    }

    public int getClientesTamanho(){
        var clientesTamanho = clientes.size();
        return clientesTamanho;
    }

    public String getClientes(){
        String listaImpressa = clientes.stream().map(Cliente::toString).collect(Collectors.joining("\n"));
        return listaImpressa;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        var a = funcionarios.contains(funcionario);
        this.funcionarios.add(funcionario);
    }
    public String getFuncionarios(){
        String listaImpressa = funcionarios.stream().map(Funcionario::toString).collect(Collectors.joining("\n"));
        return listaImpressa;
    }
}