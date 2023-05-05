import java.time.LocalDate;
import java.util.Date;

public class ClientePJ extends Cliente{

    protected String cnpj;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;

    public ClientePJ(String nome, String endereco,LocalDate dataFundacao, int qtdeFuncionarios, double valorSeguro,String cnpj) {
        super(nome, endereco, valorSeguro);

        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public String toString(){

        return String.format("Nome: %s, Endereço: %s, Data da Fundação: "+getDataFundacao()+", CNPJ: %s", getNome(), getEndereco(), getCnpj());
    }
    public double calculaScore(){
        double funcionarios = this.qtdeFuncionarios;
        return CalcSeguro.VALOR_BASE.getValor()*(1+(funcionarios)/100)*listaVeiculos.size();
    }


}
