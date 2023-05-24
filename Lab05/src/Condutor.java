import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    public List<Sinistro> listaSinistros = new ArrayList<>();

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNascimento){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro){
        listaSinistros.add(new Sinistro(data,endereco, condutor, seguro));
        seguro.listaSinistros.add(new Sinistro(data, endereco, condutor, seguro));
        return true;
    }

    public String toString(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = dataNascimento.format(dateTimeFormatter);
        return String.format("Nome: %s Cpf: %s Data de Nascimento: %s", nome, cpf, data);
    }
}
