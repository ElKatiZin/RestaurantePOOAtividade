public class Mesa {
    private String numeracao;
    private int capacidade;
    private boolean reservado;

    public Mesa (String numeracao, int capacidade){
        this.numeracao = numeracao;
        this.capacidade = capacidade;
        this.reservado = false;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}
