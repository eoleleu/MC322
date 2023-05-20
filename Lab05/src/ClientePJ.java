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
}
