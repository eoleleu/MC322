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

    @Override
    public double calculaValor(){
        int qtdSinistroCondutor =0;
        for(int i=0;i<listaCondutores.size();i++){
            qtdSinistroCondutor += listaCondutores.get(i).listaSinistros.size();
        }

        return 10*(10 + (cliente.getQtdFuncionarios())/10.0)*(1 + 1.0/(frota.listaVeiculos.size()+2))+(1+ 1.0/((LocalDate.now().getYear())-cliente.getDataFundacao().getYear() +2))*(2 + listaSinistros.size()/10.0)*(5 + qtdSinistroCondutor/10.0);
    }
}
