
public class ClientePF  extends Cliente{

    private String cpf;

    public ClientePF(String nome,String dataNascimento, int idade, String endereco, String genero, String classeEconomica, String cpf) {

        super(nome,dataNascimento, idade, endereco, genero, classeEconomica);
        this.cpf = cpf;
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
}
