import java.util.Date;

public class ClientePJ extends Cliente{

    protected String cnpj;
    private Date dataFundacao;

    public ClientePJ(String nome, String endereco,Date dataFundacao,String cnpj) {
        super(nome, endereco);

        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }


    int verificador=1;
    int[] NumerosVeriicadores = {5,4,3,2,9,8,7,6,5,4,3,2};
    public boolean validarCNPJ(){
        cnpj = cnpj.replaceAll("[^0-9]", "");

        int soma=0, tamanhoCNPJ=0, num;
        for(int i=0;i<cnpj.length();i++){
            tamanhoCNPJ+=1;

        }

        if(tamanhoCNPJ==14){
            for(int i=0;i<NumerosVeriicadores.length;i++){
                num = Character.getNumericValue(cnpj.charAt(i));

                soma = soma + num*NumerosVeriicadores[i];
            }
            int resto = soma%11;
            int digito = 11-resto;

            if(resto <2){
                if(cnpj.charAt(12)!='0'){
                    verificador =0;
                }
            } else{
                if(digito != Character.getNumericValue(cnpj.charAt(12))){
                    verificador=0;
                }
            }
            int[] NumerosVerificadores2= {6,5,4,3,2,9,8,7,6,5,4,3,2};
            soma =0;
            for(int i=0;i<NumerosVerificadores2.length;i++){
                num = Character.getNumericValue(cnpj.charAt(i));
                soma = soma + num*NumerosVerificadores2[i];
            }
            resto = soma%11;
            digito = 11-resto;
            if(resto<2){
                if(cnpj.charAt(13)!=0){
                    verificador=0;
                }
            } else {
                if(digito != Character.getNumericValue(cnpj.charAt(13))){
                    verificador=0;
                }
            }

        } else {
            verificador=0;
        }


        if(verificador==1){
            return true;
        } else {
            return false;
        }


    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String toString(){

        return String.format("Nome: %s, Endereço: %s, Data da Fundação: "+getDataFundacao()+", CNPJ: %s", getNome(), getEndereco(), getCnpj());
    }
}
