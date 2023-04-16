import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Seguradora> ListaSeguradoras = new ArrayList<>();
        Seguradora s1 = new Seguradora("Porto Seguro", "aodasda", "l213437@gmail.com", "ofaajdasod");

        s1.cadastrarCliente("Leandro", "Rua COndessa do Pinhal", "M", new Date(2002/6/15), "Ensino superior incompleto", new Date(2002/6/15), "Baixa", "018.372.696-07");

        s1.cadastrarCliente("Unicamp", "Av. 1", new Date(66, 1, 1), "46.068.425/0001-33");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Cadastre um veículo para o cliente "+s1.listaClientes.get(0).getNome()+":\n");
        System.out.println("Placa: ");
        String placa = entrada.nextLine();
        System.out.println("Marca do veículo: ");
        String marca = entrada.nextLine();
        System.out.println("Modelo: ");
        String modelo = entrada.nextLine();

        s1.listaClientes.get(0).cadastrarVeiculo(placa, marca, modelo);
        s1.listaClientes.get(1).cadastrarVeiculo("AAA", "BBB", "CCC");

        s1.gerarSinistro("151", "fadadad", s1, s1.listaClientes.get(0), s1.listaClientes.get(0).listaVeiculos.get(0));
        s1.gerarSinistro("222", "kkkk", s1, s1.listaClientes.get(1), s1.listaClientes.get(1).listaVeiculos.get(0));

        System.out.println(s1.listarCliente("PJ"));
        System.out.println(s1.listarCliente("PF"));


        s1.listarSinistros();
        s1.visualizarSinistro(s1.listaClientes.get(0).getNome());

        Cliente a = s1.listaClientes.get(1);
        System.out.println("CNPJ " + ((ClientePJ)a).validarCNPJ());
        System.out.println("CPF "+ ((ClientePF)s1.listaClientes.get(0)).validarCPF());

        System.out.println(s1.listaClientes.get(0).toString());
        System.out.println(s1.listaClientes.get(1).toString());


        s1.removerCliente("Leandro");
        s1.removerCliente("Unicamp");

    }
}