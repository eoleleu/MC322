import java.util.Date;

public class ClientePF  extends Cliente{

    public String cpf;
    private String genero;
    private Date dataNascimento;
    private String educacao;

    private String classeEconomica;
    private Date dataLicenca;

    public ClientePF(String nome, String endereco, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica, String cpf) {

        super(nome,endereco);
        this.cpf = cpf;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.dataLicenca = dataLicenca;
        this.educacao= educacao;
        this.dataNascimento = dataNascimento;
    }
    public boolean validarCPF(){
        int cont=10, soma=0, verificador =1, num,tamanhoCPF=0,cont_num_iguais=0;

        cpf = cpf.replaceAll("[^0-9]", "");

        for (int i=0;i<cpf.length();i++){
            tamanhoCPF = tamanhoCPF +1;
            if (cpf.charAt(i) == cpf.charAt(0)){
                cont_num_iguais+=1;
            }
        }
        if (tamanhoCPF ==11){
            for (int i=0;i<9;i++){
                num = Character.getNumericValue(cpf.charAt(i));
                soma = soma + num*cont;
                cont-=1;
            }
            int resto = soma%11;
            int digito = 11 - resto;

            if (resto < 2){
                if (cpf.charAt(9)!='0')
                    verificador =0;
            } else{
                if (digito != Character.getNumericValue(cpf.charAt(9))){
                    verificador =0;
                }

            }
            cont =11;
            soma =0;
            for (int i=0;i<10;i++){
                num = Character.getNumericValue(cpf.charAt(i));
                soma = soma + num*cont;
                cont-=1;
            }
            resto = soma%11;
            digito = 11-resto;
            if (resto<2){
                if (cpf.charAt(10)!='0'){
                    verificador=0;
                }
            } else {
                if (digito != Character.getNumericValue(cpf.charAt(10))){
                    verificador =0;
                }
            }
        } else {
            verificador =0;
        }

        if(verificador==1 && cont_num_iguais!= 11){
            return true;
        } else {
            return false;
        }


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

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String toString(){
        //return String.format("Nome: %s, Endereço: %s, Data Licença: "+ getDataLicenca()+" Educação: %s , Data de nascimento: ", getDataNascimento(), " Classe Econômica: %s, CPF: %s", getNome(), getEndereco(), getEducacao(), getClasseEconomica(), getCpf());
        return String.format("Nome: %s, Endereço: %s, Educação: %s, Classe econômica: %s, Cpf: %s", getNome(), getEndereco(), getEducacao(), getClasseEconomica(), getCpf() +", Data de nascimento: "+getDataNascimento()+", Data de licença: "+ getDataLicenca() );

    }
}
//String nome, String endereco, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica, String cpf
