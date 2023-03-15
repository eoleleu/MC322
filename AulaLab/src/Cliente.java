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
    public void validarCPF(){
        cpf = cpf.replaceAll("[^0-9]", "");

        int tamanhoCPF=0;
        for(int i=0;i<cpf.length();i++){
            tamanhoCPF = tamanhoCPF +1;
        }
        //System.out.println(tamanhoCPF);
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
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
}
