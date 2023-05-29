import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientePF extends Cliente{

    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento;
    public List<Veiculo> listaVeiculos = new ArrayList<>();

    public ClientePF(String nome, String telefone, String genero, String educacao,String endereco, String email, String cpf, LocalDate dataNascimento){
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.educacao = educacao;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }


    //Cria um objeto do tipo Veiculo com base nos parâmetros que passamos e adiciona esse objeto em um ArrayList chamado listaVeiculos
    public void cadastrarVeiculo(String placa, String marca, String modelo, int ano){
        listaVeiculos.add(new Veiculo(placa, marca, modelo, ano));

    }
    public void removerVeiculo(String placa){
        for(int i=0;i<listaVeiculos.size();i++){
            if(listaVeiculos.get(i).getPlaca().equals(placa)){
                listaVeiculos.remove(i);
                break;
            }
        }
    }
    public void listarVeiculos(){
        for(int i=0;i< listaVeiculos.size();i++){
            System.out.printf("Veículo %d -> Placa: %s, Marca: %s, Modelo: %s\n",i+1, listaVeiculos.get(i).getPlaca(), listaVeiculos.get(i).getMarca(), listaVeiculos.get(i).getMarca());
        }

    }

    public String toString(){
        return String.format("Nome: %s, Endereço: %s, Educação: %s, Email: %s, Cpf: %s", getNome(), getEndereco(), getEducacao(), getEmail(), getCpf());
    }
}
