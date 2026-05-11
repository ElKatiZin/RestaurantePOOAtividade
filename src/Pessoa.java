import java.time.LocalDate;

abstract class Pessoa {

    private String nome;
    private LocalDate dNasc;
    private String telefone;

    public Pessoa (String nome, LocalDate dNasc, String telefone){
        this.dNasc = dNasc;
        this.telefone = telefone;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getdNasc() {
        return dNasc;
    }

    public void setdNasc(LocalDate dNasc) {
        this.dNasc = dNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return
                "================"+"\n"+"Nome : " + nome + "\n" +
                "Data Nascimento : " + dNasc + "\n" +
                "Telefone : " + telefone + "\n";
    }
}
