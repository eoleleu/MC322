import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String educacao;
    private String dataNascimento;
    private int idade;
    private String endereco;
    private String genero;
    private String classeEconomica;
    public List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Cliente(String nome, String dataNascimento, int idade, String endereco, String genero, String classeEconomica){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
    }

    //O método validarCPF verifica se todos os dígitos são semelhantes, além
    // disso, calcular se o CPF de fato é válido calculando os dígitos finais.
    // Como também retira do CPF tudo aquilo que não for número.

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
    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }
    public String toString(){

        return String.format("Nome: %s,\nCPF: %s,\nData de Nascimento: %s,\nIdade: %d,\nEndereço: %s\n", nome, dataNascimento, idade, endereco);
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

    public boolean cadastrarVeiculo(String placa, String marca, String modelo){
        listaVeiculos.add(new Veiculo(placa, marca, modelo));
        return true;
    }
    public void listarVeiculos(){
        for(int i=0;i< listaVeiculos.size();i++){
            System.out.printf("Veículo %d -> Placa: %s, Marca: %s, Modelo: %s\n",i+1, listaVeiculos.get(i).getPlaca(), listaVeiculos.get(i).getMarca(), listaVeiculos.get(i).getMarca());
        }

    }


}
