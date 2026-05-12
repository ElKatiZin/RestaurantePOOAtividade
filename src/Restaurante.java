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
            if (clientes.get(i).getTelefone().equals(cliente)){
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
        if (qtdPessoas > mesa1.getCapacidade()){
            System.out.println("Essa mesa só comporta "+mesa1.getCapacidade()+", tente novamente com outra mesa");
        }else {

            Reserva reserva = new Reserva(cliente1, mesa1, dataHora, qtdPessoas);
            mesa1.setReservado(true);
            if (this.reservas.contains(reserva)) {
                System.out.println("Essa reserva já existe.");
            } else {
                this.reservas.add(reserva);
                System.out.println("Reserva feita!");
            }
        }
    }


    public int getClientesTamanho(){
        var clientesTamanho = clientes.size();
        return clientesTamanho;
    }

    public String getClientes(){
        String listaImpressa = clientes.stream().map(Cliente::toString).collect(Collectors.joining("\n"));
        return listaImpressa;
    }
    public String getMesas(){
        String listaImpressa = mesas.stream().map(Mesa::toString).collect(Collectors.joining("\n"));
        return listaImpressa;
    }
    public String getReservas(){
        if (this.reservas.isEmpty()) {
            return "Não existem reserva feitas.";
        }
        String listaImpressa = reservas.stream().map(Reserva::toString).collect(Collectors.joining("\n"));
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
     public void cadMesa(Mesa mesa){
        mesas.add(mesa);
     }
     public void removeCliente(String clienteid){
         Cliente cliente1 = null;
         for (int i = 0; i < clientes.size(); i++) {
             if (clientes.get(i).getTelefone().equals(clienteid)){
                 cliente1 = clientes.get(i);
                 break;
             }
         }
         clientes.remove(cliente1);
         System.out.println("Cliente removido");
     }
    public void cancelReserva(String mesaid){
        Mesa m = null;
        Reserva r = null;
        for (int i = 0; i < mesas.size(); i++) {
            if (mesas.get(i).getNumeracao().equals(mesaid)){
                m = mesas.get(i);
            }
        }
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getMesa().equals(m)){
                r = reservas.get(i);
            }
        }
        reservas.remove(r);
        System.out.println("Reserva cancelada");
    }
     public void removeFuncionario(String funcionarioid){
        Funcionario funcionario = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (funcionarios.get(i).getTelefone().equals(funcionarioid)){
                funcionario = funcionarios.get(i);
                clientes.remove(funcionario);
                System.out.println("funcionário removido");
                break;
            }
        }

    }

}