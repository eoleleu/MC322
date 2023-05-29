import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Seguro {
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    public List<Sinistro> listaSinistros = new ArrayList<>();
    public List<Condutor> listaCondutores = new ArrayList<>();
    private double valorMensal;

    public Seguro(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.valorMensal= valorMensal;
    }



    public int getId() {
        return id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }


    public abstract boolean autorizarCondutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNacimento);

    public abstract void desautorizarCondutor(String nome);

    public abstract boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro);

    public void calculaValor(int qtdVeiculosSegurados, int qtdSinistrosCliente, int qtdSinistroCondutores) {
    }







}
