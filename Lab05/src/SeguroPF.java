import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;


    public SeguroPF(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
        super(id, dataInicio, dataFim, seguradora,0);
        this.veiculo = veiculo;
        this.cliente = cliente;


    }



    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    public boolean autorizarCondutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNacimento){
        if(Validacao.validarCPF(cpf) && Validacao.valinarNOMEcliente(nome)){
            listaCondutores.add(new Condutor(cpf, nome, telefone, endereco, email, dataNacimento));
            return true;
        }
        return false;
    }

    public void desautorizarCondutor(String nome){
        for(int i=0;i<listaCondutores.size();i++){
            if(listaCondutores.get(i).getNome().equals(nome)){
                listaCondutores.remove(i);
                break;
            }
        }

    }

    public boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro){
        listaSinistros.add(new Sinistro(data,endereco, condutor, seguro));
        condutor.listaSinistros.add(new Sinistro(data, endereco, condutor, seguro));
        return true;
    }





    public void calculaValor(int qtdVeiculosSegurados, int qtdSinistrosCliente,int qtdSinistroCondutores){

        int idade =  LocalDate.now().getYear() - cliente.getDataNascimento().getYear();

        double fator;
        if(idade <30){
            fator = 1.25;
        } else if(idade <= 60){
            fator = 1.0;
        } else {
            fator = 1.5;
        }


        setValorMensal(10.0*fator*(1.0+1.0/(cliente.listaVeiculos.size()+2.0))*(2.0 + listaSinistros.size()/10.0)*(5.0 + qtdSinistroCondutores/10.0));

    }

    public String toString(){
        return String.format("Nome: %s", cliente.getNome());
    }



}
