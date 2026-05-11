import java.time.LocalDate;

public class Cliente extends Pessoa {
    private double conta;
    private String cpf;

    public Cliente (String nome, LocalDate dNasc, String telefone){
        super(nome, dNasc, telefone);
        this.conta = conta;
    }

    public double getConta() {
        return conta;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        var i = super.toString();
        return i + "Conta : " + conta;
    }


}
