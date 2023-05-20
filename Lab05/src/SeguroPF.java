import java.time.LocalDate;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;


    public SeguroPF(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
        super(id, dataInicio, dataFim, seguradora,0);
        this.veiculo = veiculo;
        this.cliente = cliente;
        setValorMensal(calculaValor());

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

    @Override
    public double calculaValor(){
        int qtdSinistroCondutor =0;
        for(int i=0;i<listaCondutores.size();i++){
            qtdSinistroCondutor += listaCondutores.get(i).listaSinistros.size();
        }

        int idade =  LocalDate.now().getYear() - cliente.getDataNascimento().getYear();
        double fator;
        if(idade <30){
            fator = 1.25;
        } else if(idade <= 60){
            fator = 1.0;
        } else {
            fator = 1.5;
        }
        return 10*fator*(1+1/(cliente.listaVeiculos.size()+2.0))*(2 + listaSinistros.size()/10.0)*(5 * qtdSinistroCondutor/10.0);

    }
}
