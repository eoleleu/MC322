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

    public boolean cadastrarCliente(String nome, String endereco, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica, String cpf){

        listaClientes.add(new ClientePF(nome, endereco,genero, dataLicenca, educacao, dataNascimento, classeEconomica, cpf));

        return true;
    }
    public boolean cadastrarCliente(String nome, String endereco, Date dataFundacao, String cnpf){
        listaClientes.add(new ClientePJ(nome, endereco, dataFundacao, cnpf));
        return true;
    }


//    public boolean cadastrarCLiente(String nome,String dataNascimento, int idade, String endereco, String genero, String classeEconomica, String cpfORcnpj){
//        String aux = cpfORcnpj.replaceAll("[^0-9]", "");
//        //System.out.println(aux.length());
//
//        if(aux.length() == 11){
////            ClientePF pf = new ClientePF(nome, dataNascimento, idade, endereco, genero, classeEconomica, cpfORcnpj);
////            listaClientes.add(pf);
//            listaClientes.add(new ClientePF(nome, dataNascimento, idade, endereco, genero, classeEconomica, cpfORcnpj));
//            return true;
//            //System.out.println("a");
//
//
//        } else if(aux.length()==14){
////            ClientePJ pj = new ClientePJ(nome, dataNascimento, idade, endereco, genero, classeEconomica, cpfORcnpj);
////            listaClientes.add(pj);
//            listaClientes.add(new ClientePJ(nome, dataNascimento, idade, endereco, genero, classeEconomica, cpfORcnpj));
//            //System.out.println("b");
//            return true;
//        }
//
//        return false;
//    }

    public boolean removerCliente(String nome){

        for(int i=0;i<listaClientes.size();i++){
            if(listaClientes.get(i).getNome().equals(nome)){
                listaClientes.remove(i);
                return true;
            }
        }
        return false;
    }
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

//        for(int i=0;i<listaClientes.size();i++){
//            System.out.printf("Cliente %d -> Nome: %s, Data de nascimento: %s, Endereço: %s, Gênero: %s, Classe Econômica: %s\n", i+1, listaClientes.get(i).getNome(),
//                    listaClientes.get(i).getDataNascimento(), listaClientes.get(i).getEndereco(), listaClientes.get(i).getGenero(), listaClientes.get(i).getClasseEconomica());
//        }
    }
    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Cliente cliente, Veiculo veiculo){
        listaSinistros.add(new Sinistro(data, endereco, seguradora, cliente, veiculo));
        return true;
    }


    public void visualizarSinistro(String cliente_nome){
        int i;
        List<Integer> lista = new ArrayList<>();
        for(i=0;i<listaSinistros.size();i++){
            if(listaSinistros.get(i).cliente.getNome() == cliente_nome){
                lista.add(i);
                //break;
            }
            //i++;
        }
        //System.out.println(i);
        //System.out.println(listaSinistros.get(0).cliente.);
        for(i=0;i<lista.size();i++){

            System.out.printf("(%d) Data: %s, Endereço: %s, Seguradora: %s, Cliente: %s, Veiculo: %s\n",listaSinistros.get(i).getId(), listaSinistros.get(i).getData(), listaSinistros.get(i).cliente.getEndereco(), listaSinistros.get(i).seguradora.getNome(), listaSinistros.get(i).cliente.getNome(), listaSinistros.get(i).veiculo.getPlaca());
        }
    }


    public void listarSinistros(){
        for (Sinistro listaSinistro : listaSinistros) {
            System.out.printf("(%d) Data: %s, Endereço: %s, Seguradora: %s, Cliente: %s, Veiculo: %s\n", listaSinistro.getId(), listaSinistro.getData(), listaSinistro.cliente.getEndereco(), listaSinistro.seguradora.getNome(), listaSinistro.cliente.getNome(), listaSinistro.veiculo.getPlaca());
        }
    }

//    public boolean cadastrarCliente(String nome, String dataNascimento, int idade, String endereco, String genero, String classeEconomica, String cnpj){
//        listaClientes.add(new ClientePJ(nome, dataNascimento, idade, endereco, genero, classeEconomica, cnpj));
//        return true;
//    }
}
