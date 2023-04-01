import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String nome = entrada.next();
        String data = entrada.next();
        String endereco = entrada.next();
        String genero = entrada.next();
        String classe = entrada.next();
        String cpf = entrada.next();
        int idade = entrada.nextInt();

        ClientePF pf = new ClientePF(nome, data, idade, endereco, genero, classe,cpf);
        ClientePJ pj = new ClientePJ("Multilaser", "15/06/1991", 32, "Unicampp", "m", "A", "12.528.708/0001-07");

        System.out.println(pf.validarCPF());
        System.out.println(pj.validarCNPJ()+"\n");


        List<Seguradora> ListaSeguradoras = new ArrayList<>();
        Seguradora s1 = new Seguradora("Porto Seguro", "aodasda", "leleuresende@gmail.com", "ofaajdasod");

        s1.cadastrarCLiente("joao", "32", 44, "aaaaaaa", "m", "A","105.150.126-10");
        s1.cadastrarCLiente("Leandro", "515", 15, "ldjada", "m", "A","12.528.708/0001-02");

        s1.listaClientes.get(0).cadastrarVeiculo("HGE", "BMW", "3200");
        s1.listaClientes.get(1).cadastrarVeiculo("AAA", "BBB", "CCC");

        s1.gerarSinistro("151", "fadadad", s1, s1.listaClientes.get(0), s1.listaClientes.get(0).listaVeiculos.get(0));
        s1.gerarSinistro("222", "kkkk", s1, s1.listaClientes.get(1), s1.listaClientes.get(1).listaVeiculos.get(0));

        s1.listarCliente();

        System.out.println();

        s1.visualizarSinistro(s1.listaClientes.get(0).getNome());

        System.out.println();

        s1.listarSinistros();

        s1.removerCliente(0);
//
//        s1.listaClientes.get(0).listarVeiculos();

        //s1.removerCliente(0);
        //Veiculo v1 = new Veiculo("hge", "bmw", "3200");
        //ClientePF c1 = new ClientePF("joao", "32", 44, "aaaaaaa", "m", "A","105.150.126-10");
        //c1.cadastrarVeiculo("hge", "bmw", "3200");
        //c1.cadastrarVeiculo("aaa", "bbb", "cccc");

        //System.out.println(s1.listaClientes.get(0).getNome());

        //System.out.println(s1.listaClientes.get(0).getNome());

        //System.out.println(s1.listaClientes.get(0).listaVeiculos.size());
        //s1.listarCliente();
//        int menu=1;
//        while(menu==1){
//            Scanner entrada = new Scanner(System.in);
//            System.out.printf("Menu Cliente(1)\nMenu Veiculo(2)\nMenu Sinistro(3)\nMenu Seguradora(4)\nSair(0)\n");
//            int comando = entrada.nextInt();
//            if(comando==0){
//                menu = 0;
//            } else if(comando ==1){
//
//                while(comando !=0){
//
//                    System.out.printf("Cadastrar cliente(1)\nRemover cliente(2)\nMostrar clientes(3)\nVoltar(0)\n");
//                    comando = entrada.nextInt();
//
//                    if(comando ==1){
//                        Scanner entradas_cliente = new Scanner(System.in);
//
//                        String nome;
//                        System.out.printf("Nome: ");
//                        nome = entradas_cliente.nextLine();
//
//                        int idade;
//                        System.out.printf("Idade: ");
//                        idade = entradas_cliente.nextInt();
//
//                        String dataNascimento;
//                        System.out.printf("Data de Nascimento: ");
//                        dataNascimento = entradas_cliente.nextLine();
//
//                        String classeEconomica;
//                        System.out.printf("Classe Economica: ");
//                        classeEconomica = entradas_cliente.nextLine();
//
//                        String endereco;
//                        System.out.printf("Endereco:");
//                        endereco = entradas_cliente.nextLine();
//
//                        String cpf;
//                        System.out.printf("CPF: ");
//                        cpf = entradas_cliente.nextLine();
//
//                        String genero;
//                        System.out.printf("Genero: ");
//                        genero = entradas_cliente.nextLine();
//
//                        ClientePF c1 = new ClientePF(nome, dataNascimento, idade, endereco, genero, classeEconomica, cpf);
//
//                        if(c1.validarCPF()){
//                            System.out.printf("Client cadastrado com sucesso!\n\n");
//                        }
//
//                    }
//                }
//            } else if(comando==4){
//                while(comando!=0){
//                    System.out.printf("Cadastrar Seguradora(1)\nRemover Seguradora(2)\nMostrar Seguradoras(3)\nVoltar(0)\n");
//                    comando = entrada.nextInt();
//                    if(comando==1){
//                        Scanner entradas_seguradora = new Scanner(System.in);
//
//                        String nome;
//                        System.out.printf("Nome: ");
//                        nome = entradas_seguradora.nextLine();
//
//                        String telefone;
//                        System.out.printf("Telefone: ");
//                        telefone = entradas_seguradora.nextLine();
//
//                        String email;
//                        System.out.printf("Email: ");
//                        email = entradas_seguradora.nextLine();
//
//                        String endereco;
//                        System.out.printf("Endereço: ");
//                        endereco = entradas_seguradora.nextLine();
//
//                        ListaSeguradoras.add(new Seguradora(nome, telefone, email, endereco));
//
//                        System.out.println("Seguradora cadastrada com sucesso!\n");
//
//                    } else if(comando ==3){
//                        for(int i=0;i<ListaSeguradoras.size();i++){
//                            System.out.println(ListaSeguradoras.get(i));
//                        }
//                    } else if(comando ==2){
//                        Scanner entrada_remove = new Scanner(System.in);
//                        int num_seg;
//                        System.out.println("Qual seguradora você deseja remover?");
//                        num_seg = entrada_remove.nextInt();
//
//                        ListaSeguradoras.remove(num_seg);
//                    }
//                }
//            }
//        }





//        ClientePF leandro = new ClientePF("Lealdrno", "515", 15, "ldjada", "m", "A","105.150.126-10");
//        System.out.println(leandro.validarCPF());
//        ClientePJ PJ = new ClientePJ("leandro0", "dasda", 23, "dasda", "d", "das", "11.222.333/0001-81");
//        System.out.println(PJ.validarCNPJ());
        //Cliente leandro = new Cliente("Leandro", "105.150.126-10", "15 de junho de 2002", 20, "unicampp");,
//        Veiculo v1 = new Veiculo("HGE-9443", "Volvo", "GLC-300");
//        Seguradora s1 = new Seguradora("Porto Seguro", "34414271", "aaaaaaaa@unicamp.br", "Instituto de Computação da Unicamp");
//        Sinistro sinistro1 = new Sinistro("31/02/2000", "IMECC");
//
//        System.out.println(leandro);
//        System.out.println(v1);
//        System.out.println(s1);
//        System.out.println(sinistro1);
//
//        leandro.setNome("Henrique");
//        System.out.println(leandro.getNome());
//        //System.out.println(leandro.getCpf());
//        System.out.println(leandro.getDataNascimento());
//        System.out.println(leandro.getIdade());
//        System.out.println(leandro.getEndereco());
//
//        v1.setPlaca("AAA-0000");
//        System.out.println(v1.getPlaca());
//        System.out.println(v1.getMarca());
//        System.out.println(v1.getModelo());
//
//        s1.setNome("Wiz");
//        System.out.println(s1.getNome());
//        System.out.println(s1.getTelefone());
//        System.out.println(s1.getEmail());
//        System.out.println(s1.getEndereco());
//
//        sinistro1.setData("00/00/0000");
//        System.out.println(sinistro1.getData());
//        System.out.println(sinistro1.getEndereco());

        //System.out.println(leandro.validarCPF());
    }
}