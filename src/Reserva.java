import java.time.LocalDateTime;

public class Reserva {
    private Cliente cliente;
    private Mesa mesa;
    private LocalDateTime dataHora;
    private int quantidadePessoas;
    private boolean ativa;

    public Reserva (Cliente cliente, Mesa mesa, LocalDateTime dataHora, int quantidadePessoas){
        this.cliente = cliente;
        this.mesa = mesa;
        this.dataHora = dataHora;
        this.quantidadePessoas = quantidadePessoas;
        this.ativa = true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
