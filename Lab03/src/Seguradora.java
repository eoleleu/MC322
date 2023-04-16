import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    public List<Sinistro> listaSinistros = new ArrayList<>();
    public List<Cliente> listaClientes = new ArrayList<>();


    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }


    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String toString(){

        return String.format("Nome: %s,\nTelefone: %s,\nEmail: %s,\nEndereço: %s,\n", nome, telefone, email, endereco);
    }

    //Cadastra um cliente do tipo PF
    public boolean cadastrarCliente(String nome, String endereco, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica, String cpf){

        listaClientes.add(new ClientePF(nome, endereco,genero, dataLicenca, educacao, dataNascimento, classeEconomica, cpf));

        return true;
    }

    //Cadastra um cliente que tipo PJ
    public boolean cadastrarCliente(String nome, String endereco, Date dataFundacao, String cnpf){
        listaClientes.add(new ClientePJ(nome, endereco, dataFundacao, cnpf));
        return true;
    }

    // Remove um cliente da listaCliente com base no nome que passamos como parâmetro
    public boolean removerCliente(String nome){

        for(int i=0;i<listaClientes.size();i++){
            if(listaClientes.get(i).getNome().equals(nome)){
                listaClientes.remove(i);
                return true;
            }
        }
        return false;
    }

    // Mostra todos os clientes(PF ou PJ) que temos na listaCliente.
    public List<Cliente> listarCliente(String tipo){


        if(tipo.equals("PF")){
            List<Cliente> listaPF = new ArrayList<>();
            for (Cliente cliente : this.listaClientes) {
                if (cliente.getClass() ==ClientePF.class) {
                    listaPF.add(cliente);
                }

            }
            return listaPF;
        } else if(tipo.equals("PJ")){
            List <Cliente> listaPJ = new ArrayList<>();
            for (int i=0;i<listaClientes.size();i++){
                if(listaClientes.get(i).getClass() == ClientePJ.class){
                    listaPJ.add(listaClientes.get(i));
                }
            }
            return listaPJ;
        }

        return this.listaClientes;


    }

    // Cria um objeto do tipo sinistro com base nos parâmetros passado e adicina esse objeto na listaSinistros.
    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Cliente cliente, Veiculo veiculo){
        listaSinistros.add(new Sinistro(data, endereco, seguradora, cliente, veiculo));
        return true;
    }

    // Visualiza todos os sinistros de um cliente que passamos como parâmetro;
    public void visualizarSinistro(String cliente_nome){
        int i;
        List<Integer> lista = new ArrayList<>();
        for(i=0;i<listaSinistros.size();i++){
            if(listaSinistros.get(i).cliente.getNome() == cliente_nome){
                lista.add(i);

            }

        }

        for(i=0;i<lista.size();i++){

            System.out.printf("(%d) Data: %s, Endereço: %s, Seguradora: %s, Cliente: %s, Veiculo: %s\n",listaSinistros.get(i).getId(), listaSinistros.get(i).getData(), listaSinistros.get(i).cliente.getEndereco(), listaSinistros.get(i).seguradora.getNome(), listaSinistros.get(i).cliente.getNome(), listaSinistros.get(i).veiculo.getPlaca());
        }
    }

    // Mostra todos os sinistro na listaSinistros
    public void listarSinistros(){
        for (Sinistro listaSinistro : listaSinistros) {
            System.out.printf("(%d) Data: %s, Endereço: %s, Seguradora: %s, Cliente: %s, Veiculo: %s\n", listaSinistro.getId(), listaSinistro.getData(), listaSinistro.cliente.getEndereco(), listaSinistro.seguradora.getNome(), listaSinistro.cliente.getNome(), listaSinistro.veiculo.getPlaca());
        }
    }

}
