import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private Funcao funcao;
    private double salario;
    private String cpf;

    public Funcionario (Funcao funcao, double salario, String nome, LocalDate dNasc, String telefone, String cpf){
        super(nome, dNasc, telefone);
        this.funcao = funcao;
        this.salario = salario;
        this.cpf = cpf;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        var i = super.toString();
        return i + "Função : " + funcao + "\n" +
                "Salario :" + salario + "\n" +
                "Cpf : " + cpf + "\n";
    }
}
