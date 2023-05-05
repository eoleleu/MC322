import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class ClientePF  extends Cliente{

    public String cpf;
    private String genero;
    private LocalDate dataNascimento;
    private String educacao;

    private String classeEconomica;
    private LocalDate dataLicenca;

    public ClientePF(String nome, String endereco, String genero, LocalDate dataLicenca, String educacao,
                     LocalDate dataNascimento, String classeEconomica, double valorSeguro, String cpf) {

        super(nome,endereco, valorSeguro);
        this.cpf = cpf;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.dataLicenca = dataLicenca;
        this.educacao= educacao;
        this.dataNascimento = dataNascimento;
    }



    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }


    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public LocalDate getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String toString(){
        return String.format("Nome: %s, Endereço: %s, Educação: %s, Classe econômica: %s, Cpf: %s", getNome(), getEndereco(), getEducacao(), getClasseEconomica(), getCpf() +", Data de nascimento: "+getDataNascimento()+", Data de licença: "+ getDataLicenca() );

    }

    public double calculaScore(){
        long idade1 = java.time.temporal.ChronoUnit.YEARS.between(dataNascimento, dataLicenca );
        double idade = (double) idade1;
        double n;
        if(idade>=18 && idade <=30){
            n = CalcSeguro.FATOR_18_30.getValor();
        } else if(idade > 30 && idade <=60){
            n = CalcSeguro.FATOR_30_60.getValor();
        } else{
            n = CalcSeguro.FATOR_60_90.getValor();
        }

        return CalcSeguro.VALOR_BASE.getValor()*n*listaVeiculos.size();
    }
}

