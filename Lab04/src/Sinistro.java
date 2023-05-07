import java.time.LocalDate;
import java.util.Random;

import java.util.Date;
public class Sinistro {
    private int id;
    private LocalDate data;
    private String endereco;
    public Seguradora seguradora;
    public Cliente cliente;
    public Veiculo veiculo;


    public Sinistro(LocalDate data, String endereco, Seguradora seguradora, Cliente cliente, Veiculo veiculo) {
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.cliente = cliente;
        this.veiculo = veiculo;
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
    public String toString(){
        return String.format("ID: %d,\nCliente: %s\nVeículo: %s\nEndereço: %s\n",id,cliente.getNome(), veiculo.toString(), endereco);
    }

}
