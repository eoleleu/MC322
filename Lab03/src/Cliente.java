import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String endereco;
    public List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;

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

    //Cria um objeto do tipo Veiculo com base nos parâmetros que passamos e adiciona esse objeto em um ArrayList chamado listaVeiculos
    public boolean cadastrarVeiculo(String placa, String marca, String modelo, int ano){
        listaVeiculos.add(new Veiculo(placa, marca, modelo, ano));
        return true;
    }

    //Mostra todos os veículos na listaVeiculo;
    public void listarVeiculos(){
        for(int i=0;i< listaVeiculos.size();i++){
            System.out.printf("Veículo %d -> Placa: %s, Marca: %s, Modelo: %s\n",i+1, listaVeiculos.get(i).getPlaca(), listaVeiculos.get(i).getMarca(), listaVeiculos.get(i).getMarca());
        }

    }


}
