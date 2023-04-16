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

    //O método validarCPF verifica se todos os dígitos são semelhantes, além
    // disso, calcular se o CPF de fato é válido calculando os dígitos finais.
    // Como também retira do CPF tudo aquilo que não for número.
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


//    public String toString(){
//
//        return String.format("Nome: %s,Endereço: %s\n", nome, endereco);
//    }



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
