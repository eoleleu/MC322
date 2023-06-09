import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientePJ extends Cliente{

    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdFuncionarios;
    public List<Frota> listaFrota = new ArrayList<>();

    public ClientePJ(String nome, String telefone, String endereco, String email, String cnpj, LocalDate dataFundacao, int qtdFuncionarios){
        super(nome, telefone, endereco, email);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public boolean cadastrarFrota(Frota frota){
        listaFrota.add(frota);
        return true;

    }

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public void getVeiculosPorFrota(int indice_frota){
        for(int i=0;i<listaFrota.get(indice_frota).listaVeiculos.size();i++){
            System.out.println(listaFrota.get(indice_frota).listaVeiculos);
        }
    }

    public void atualizarFrota(Veiculo veiculo, int ind_frota, int comando){
        if(comando ==1){
            listaFrota.get(ind_frota).addVeiculo(veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao());
        } else if(comando ==2){
            listaFrota.get(ind_frota).removeVeiculo(veiculo);
        }
    }

    public String toString(){

        return String.format("Nome: %s, Endereço: %s, Telefone: %s, Email: %s, CNPJ: %s, Quantidade de Funcionários: %d", getNome(), getEndereco(), getTelefone(), getEmail(), getCnpj(), getQtdFuncionarios());
    }
}
