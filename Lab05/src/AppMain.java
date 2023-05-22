import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);

        List<Seguradora> ListaSeguradoras = new ArrayList<>();

        Seguradora s1 = new Seguradora("Porto Seguro", "aodasda", "l213437@gmail.com", "ofaajdasod", "46.068.425/0001-33");
        ListaSeguradoras.add(s1);

        s1.cadastrarCliente("Leandro", "34557063", "M","Ensino superior","Rua condessa do pinhal","l213437@dac.unicamp.br","018.372.696-02", LocalDate.of(2002, 7, 22));
        s1.cadastrarCliente("Unicamp", "000000000","Av.1","@unicamp.br", "46.068.425/0001-33",LocalDate.of(1966, 10, 5), 8000);
        s1.cadastrarCliente("Gustavo", "11946336399", "M","Ensino superior","Rua condessa do pinhal","g123456@dac.unicamp.br","006.419.986-00", LocalDate.of(1999, 7, 22));
        s1.cadastrarCliente("Bandejao", "000000000","Av.2","bandeco.com.br", "46.068.425/0001-33",LocalDate.of(1966, 10, 5), 200);

        ((ClientePF)s1.listaClientes.get(0)).cadastrarVeiculo("HGE-9443", "Volks", "Fox", 2011);
        ((ClientePF)s1.listaClientes.get(2)).cadastrarVeiculo("MKT-8450", "Mercedes", "GLE", 2023);

        Frota f1 = new Frota();
        f1.addVeiculo("BBB-1111", "BMW", "Palio", 2021);
        f1.addVeiculo("CCC-2222", "Porsche", "Uno", 2001);
        f1.addVeiculo("DDD-3333", "Van", "Gle", 2005);
        f1.addVeiculo("EEE-4444", "Kombi", "trend", 2010);

        Frota f2 = new Frota();
        f1.addVeiculo("GSA-2727", "BMW", "Palio", 2021);
        f1.addVeiculo("GEF-6787", "Porsche", "Uno", 2001);
        f1.addVeiculo("LUY-6721", "Van", "Gle", 2005);
        f1.addVeiculo("VSD-2457", "Kombi", "trend", 2010);
        ((ClientePJ)s1.listaClientes.get(3)).cadastrarFrota(f2);

        System.out.println(s1.listarCliente("PF"));
        System.out.println(s1.listarCliente("PJ"));

        //LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal, Frota frota, ClientePJ cliente
        //LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente
        s1.gerarSeguro(LocalDate.of(2021, 6, 20), LocalDate.of(2026, 9, 11), s1, ((ClientePF) s1.listaClientes.get(0)).listaVeiculos.get(0), (ClientePF) s1.listaClientes.get(0));

//        s1.listaClientes.get(0).cadastrarVeiculo("HGE-9443", "Volks", "Fox", 2011);

    }
}