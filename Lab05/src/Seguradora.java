import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private final String cnpj;
    public List<Seguro> listaSeguros = new ArrayList<>();
    public List<Cliente> listaClientes = new ArrayList<>();

    public Seguradora(String nome, String telefone, String email, String endereco, String cnpj){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
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


    }

    public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente){
        Random gerador = new Random();
        int id = gerador.nextInt(99999);

        listaSeguros.add(new SeguroPF(id, dataInicio, dataFim, seguradora, veiculo, cliente));
        return true;

    }


    public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal, Frota frota, ClientePJ cliente){
        Random gerador = new Random();
        int id = gerador.nextInt(99999);

        listaSeguros.add(new SeguroPJ(id, dataInicio, dataFim, seguradora, frota, cliente));
        return true;

    }

    public boolean cancelarSeguro(ClientePF cliente){
        for(int i=0;i<listaSeguros.size();i++){
            if(listaSeguros.get(i) instanceof SeguroPF){
                if(((SeguroPF) listaSeguros.get(i)).getCliente().getNome().equals(cliente.getNome())){
                    listaSeguros.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cancelarSeguro(ClientePJ cliente){
        for(int i=0;i<listaSeguros.size();i++){
            if(listaSeguros.get(i) instanceof SeguroPJ){
                if(((SeguroPJ) listaSeguros.get(i)).getCliente().getNome().equals(cliente.getNome())){
                    listaSeguros.remove(i);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean cadastrarCliente(String nome, String telefone,String genero, String educacao, String endereco, String email, String cpf, LocalDate dataNascimento){
        if (Validacao.validarCPF(cpf) && Validacao.valinarNOMEcliente(nome)){
            listaClientes.add(new ClientePF(nome, telefone, genero, educacao,endereco, email, cpf, dataNascimento));
            return true;
        }
        System.out.printf("CPF ou nome do cliente %s inválido(s)", nome);
        return false;

    }

    //Cadastra um cliente que tipo PJ
    public boolean cadastrarCliente(String nome, String telefone,String endereco, String email, String cnpj, LocalDate dataFundacao){
        if(Validacao.validarCNPJ(cnpj) && Validacao.valinarNOMEcliente(nome)){
            listaClientes.add(new ClientePJ(nome, telefone, endereco, email, cnpj, dataFundacao));
            return true;

        }
        System.out.printf("CNPJ ou nome da empresa %s inválido(s)", nome);
        return false;
    }

    public boolean removerCliente(String nome){

        for(int i=0;i<listaClientes.size();i++){
            if(listaClientes.get(i).getNome().equals(nome)){
                listaClientes.remove(i);
                return true;
            }
        }
        return false;
    }

    public List getSegurosPorCliente(ClientePF cliente){
        List<Seguro> lista = new ArrayList<>();
        for(int i=0;i<listaSeguros.size();i++){
            if(((SeguroPF) listaSeguros.get(i)).getCliente().getNome().equals(cliente.getNome())){
                lista.add(listaSeguros.get(i));
            }
        }
        return lista;
    }

    public List getSegurosPorCliente(ClientePJ cliente){
        List<Seguro> lista = new ArrayList<>();
        for(int i=0;i<listaSeguros.size();i++){
            if(((SeguroPJ) listaSeguros.get(i)).getCliente().getNome().equals(cliente.getNome())){
                lista.add(listaSeguros.get(i));
            }
        }
        return lista;
    }

    public List getSinistroPorCliente(ClientePF cliente){
        List<Sinistro> lista = new ArrayList<>();
        for(int i=0;i<listaSeguros.size();i++){
            if(((SeguroPF) listaSeguros.get(i)).getCliente().getNome().equals(cliente.getNome())){
                for(int j=0;j<listaSeguros.get(i).listaSinistros.size();i++){
                    lista.add(listaSeguros.get(i).listaSinistros.get(j));
                }
            }

        }
        return lista;
    }

    public List getSinistroPorCliente(ClientePJ cliente){
        List<Sinistro> lista = new ArrayList<>();
        for(int i=0;i<listaSeguros.size();i++){
            if(((SeguroPJ) listaSeguros.get(i)).getCliente().getNome().equals(cliente.getNome())){
                for(int j=0;j<listaSeguros.get(i).listaSinistros.size();i++){
                    lista.add(listaSeguros.get(i).listaSinistros.get(j));
                }
            }

        }
        return lista;
    }

    public int calcularReceita(){
        int receita =0;
        for(int i=0;i<listaSeguros.size();i++){
            receita += listaSeguros.get(i).getValorMensal();
        }
        return receita;
    }


}
