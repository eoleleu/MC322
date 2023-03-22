public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco){
        this.nome = nome;
        this.cpf = cpf;

        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    //O método validarCPF verifica se todos os dígitos são semelhantes, além
    // disso, calcular se o CPF de fato é válido calculando os dígitos finais.
    // Como também retira do CPF tudo aquilo que não for número.
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
    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String toString(){

        return String.format("Nome: %s,\nCPF: %s,\nData de Nascimento: %s,\nIdade: %d,\nEndereço: %s\n", nome, cpf, dataNascimento, idade, endereco);
    }
}
