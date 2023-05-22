import java.time.LocalDate;

public class SeguroPJ extends Seguro{
    private Frota frota;
    private ClientePJ cliente;
    public SeguroPJ(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
        super(id, dataInicio, dataFim, seguradora, 0);
        this.frota = frota;
        this.cliente = cliente;
        setValorMensal(calculaValor());
    }

    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    public double calculaValor(){
        int qtdSinistroCondutor =0;
        for (Condutor listaCondutore : listaCondutores) {
            qtdSinistroCondutor += listaCondutore.listaSinistros.size();
        }

        return 10*(10 + (cliente.getQtdFuncionarios())/10.0)*(1 + 1.0/(frota.listaVeiculos.size()+2))+(1+ 1.0/((LocalDate.now().getYear())-cliente.getDataFundacao().getYear() +2))*(2 + listaSinistros.size()/10.0)*(5 + qtdSinistroCondutor/10.0);
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
        condutor.gerarSinistro(data, endereco, condutor, seguro);
        return true;
    }

    public void calculaValor(int qtdVeiculosSegurados, int qtdSinistrosCliente,int qtdSinistroCondutores){
        int AnosPosFundacao =  LocalDate.now().getYear() - cliente.getDataFundacao().getYear();

        setValorMensal(10*(10+cliente.getQtdFuncionarios()/10.0)*(1+1.0/(qtdVeiculosSegurados+2))*(1+1.0/(AnosPosFundacao+2))*(2 + qtdSinistrosCliente/10.0)*(5 * qtdSinistroCondutores/10.0));
    }



}
