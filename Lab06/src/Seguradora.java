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


    public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente){
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

    //Cadastra um cliente do tipo PJ
    public boolean cadastrarCliente(String nome, String telefone,String endereco, String email, String cnpj, LocalDate dataFundacao, int qtdFuncionarios){
        if(Validacao.validarCNPJ(cnpj) && Validacao.valinarNOMEcliente(nome)){
            listaClientes.add(new ClientePJ(nome, telefone, endereco, email, cnpj, dataFundacao, qtdFuncionarios));
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

    public double calcularReceita(){

        for(int i=0;i<listaSeguros.size();i++){
            if(listaSeguros.get(i) instanceof SeguroPF){
                int qtdVeiculosSegurados=0;
                for(int j=0;j<listaSeguros.size();j++){
                    if(listaSeguros.get(j) instanceof SeguroPF){

                        if(((SeguroPF) listaSeguros.get(j)).getVeiculo().getPlaca().equals(((SeguroPF) listaSeguros.get(i)).getVeiculo().getPlaca())){
                            qtdVeiculosSegurados+=1;
                        }
                    }
                }

                int qtdSinistrosCliente=0;
                for(int j=0;j<listaSeguros.size();j++){
                    if(listaSeguros.get(j) instanceof  SeguroPF){

                        if(((SeguroPF) listaSeguros.get(j)).getCliente().getCpf().equals(((SeguroPF) listaSeguros.get(i)).getCliente().getCpf())){
                            for(int k=0;k<listaSeguros.get(j).listaSinistros.size();k++)
                                if(listaSeguros.get(j).listaSinistros.get(k).getCondutor().getCpf().equals(((SeguroPF) listaSeguros.get(j)).getCliente().getCpf()))
                                    qtdSinistrosCliente+= listaSeguros.get(i).listaSinistros.size();
                        }
                    }
                }

                int qtdSinistroCondutores=0;

                for(int j=0;j<listaSeguros.get(i).listaCondutores.size();j++){
                    for(int k=0;k<listaSeguros.size();k++){
                        for(int m=0;m<listaSeguros.get(k).listaSinistros.size();m++){
                            if(listaSeguros.get(i).listaCondutores.get(j).getCpf().equals(listaSeguros.get(k).listaSinistros.get(m).getCondutor().getCpf())){
                                qtdSinistroCondutores+=1;
                            }
                        }
                    }
                }

                listaSeguros.get(i).calculaValor(qtdVeiculosSegurados, qtdSinistrosCliente, qtdSinistroCondutores);

            } else if(listaSeguros.get(i) instanceof SeguroPJ){

                int qtdSinistrosCliente=0;
                for(int j=0;j<listaSeguros.size();j++){
                    if(listaSeguros.get(j) instanceof SeguroPJ){

                        if(((SeguroPJ) listaSeguros.get(j)).getCliente().getCnpj().equals(((SeguroPJ) listaSeguros.get(i)).getCliente().getCnpj())){
                            qtdSinistrosCliente+= listaSeguros.get(i).listaSinistros.size();
                        }
                    }
                }

                int qtdVeiculosSegurados=0;
                for(int j=0;j<listaSeguros.size();j++){
                    if(listaSeguros.get(j) instanceof SeguroPJ){

                        if(((SeguroPJ) listaSeguros.get(j)).getCliente().getCnpj().equals(((SeguroPJ) listaSeguros.get(i)).getCliente().getCnpj())){
                            qtdVeiculosSegurados+=((SeguroPJ) listaSeguros.get(j)).getFrota().listaVeiculos.size();
                        }
                    }
                }

                int qtdSinistroCondutores=0;
                for(int j=0;j<listaSeguros.get(i).listaCondutores.size();j++){
                    for(int k=0;k<listaSeguros.size();k++){
                        for(int m=0;m<listaSeguros.get(k).listaSinistros.size();m++){
                            if(listaSeguros.get(i).listaCondutores.get(j).getCpf().equals(listaSeguros.get(k).listaSinistros.get(m).getCondutor().getCpf())){
                                qtdSinistroCondutores+=1;
                            }
                        }
                    }
                }

                listaSeguros.get(i).calculaValor(qtdVeiculosSegurados, qtdSinistrosCliente, qtdSinistroCondutores);





            }

        }




        double receita =0;
        for(int i=0;i<listaSeguros.size();i++){
            receita += listaSeguros.get(i).getValorMensal();
        }
        return receita;
    }

    public String toString(){
        return String.format("Nome: %s, Telefone: %s, Email: %s, Endereço: %s, CNPJ: %s", nome, telefone, email, endereco, cnpj);
    }


}
