import java.time.LocalDate;
import java.util.Random;

public class Sinistro {
    private int id;
    private LocalDate data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;


    public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) {
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
        id = gerarID();
    }

    //O método retorna um número inteiro aleatório de 0 até 99999.
    public int gerarID(){
        Random gerador = new Random();
        return gerador.nextInt(99999);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getData(){
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
//    public String toString(){
//        return String.format("ID: %d,\nCliente: %s\nVeículo: %s\nEndereço: %s\n",id,cliente.getNome(), veiculo.toString(), endereco);
//    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}
