import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {

        //Lista do que tenho que fazer
        // CADASTRAR CONDUTORES
        // LISTAR CONDUTORES DO SEGURO
        // EXCLUIR CONDUTOR
        // GERAR SINISTRO



        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);

        List<Seguradora> ListaSeguradoras = new ArrayList<>();

        Seguradora s1 = new Seguradora("Porto Seguro", "aodasda", "l213437@gmail.com", "ofaajdasod", "46.068.425/0001-33");
        ListaSeguradoras.add(s1);

        Seguradora s2 = new Seguradora("SulAmerica", "aodasda", "l213437@gmail.com", "ofaajdasod", "46.068.425/0001-33");
        ListaSeguradoras.add(s2);

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
        ((ClientePJ)s1.listaClientes.get(1)).cadastrarFrota(f1);



        Frota f2 = new Frota();
        f2.addVeiculo("GSA-2727", "BMW", "Palio", 2021);
        f2.addVeiculo("GEF-6787", "Porsche", "Uno", 2001);
        f2.addVeiculo("LUY-6721", "Van", "Gle", 2005);
        f2.addVeiculo("VSD-2457", "Kombi", "trend", 2010);
        ((ClientePJ)s1.listaClientes.get(3)).cadastrarFrota(f2);

//        System.out.println(s1.listarCliente("PF"));
//        System.out.println(s1.listarCliente("PJ"));

        //LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal, Frota frota, ClientePJ cliente
        //LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente
        s1.gerarSeguro(LocalDate.of(2021, 6, 20), LocalDate.of(2026, 9, 11), s1, ((ClientePF) s1.listaClientes.get(0)).listaVeiculos.get(0), (ClientePF) s1.listaClientes.get(0));
        s1.gerarSeguro(LocalDate.of(2009, 7, 14), LocalDate.of(2030, 1, 7), s1, ((ClientePJ)s1.listaClientes.get(3)).listaFrota.get(0), (ClientePJ)s1.listaClientes.get(3));

        s1.gerarSeguro(LocalDate.of(2014, 4, 4), LocalDate.of(2026, 9, 11), s1, ((ClientePF) s1.listaClientes.get(0)).listaVeiculos.get(0), (ClientePF) s1.listaClientes.get(0));

        s1.listaSeguros.get(0).autorizarCondutor(((ClientePF) s1.listaClientes.get(0)).getCpf(), ((ClientePF) s1.listaClientes.get(0)).getNome(), ((ClientePF) s1.listaClientes.get(0)).getTelefone(),
                ((ClientePF) s1.listaClientes.get(0)).getEndereco(), ((ClientePF) s1.listaClientes.get(0)).getEmail(), ((ClientePF) s1.listaClientes.get(0)).getDataNascimento());


        s1.listaSeguros.get(0).gerarSinistro(LocalDate.of(2022, 3, 1), "daojda", s1.listaSeguros.get(0).listaCondutores.get(0), s1.listaSeguros.get(0));
        s1.listaSeguros.get(0).gerarSinistro(LocalDate.of(2018, 8, 23), "fasdfdsafdas", s1.listaSeguros.get(0).listaCondutores.get(0), s1.listaSeguros.get(2));

        System.out.println(s1.calcularReceita());

        System.out.println(((SeguroPF)s1.listaSeguros.get(0)).getCliente().getNome());


//        s1.listaClientes.get(0).cadastrarVeiculo("HGE-9443", "Volks", "Fox", 2011);


        int menu_p = -1;
        while (menu_p != 0) {
            System.out.println("1 - Cadastros\n2 - Listar\n3 - Gerar Seguro\n4 - Excluir\n5 - Gerar Sinistro\n6 - Calcular Receita Seguradora\n0 - Sair");
            menu_p = entrada.nextInt();

            if(menu_p == MenuOperacoes.CADASTRAR.getOperacao()){
                double menu_cadastrar=-1;
                while(menu_cadastrar!=0){

                    System.out.println("1.1 - Cadastrar Cliente PF/PJ\n1.2 - Cadastrar Veículo\n1.3 - Cadastrar Seguradora\n1.4 - Cadastrar Frota\n1.5 - Cadastrar condutor\n0 - Voltar");
                    menu_cadastrar = entrada.nextDouble();

                    if(menu_cadastrar ==1.1){

                        int menu_PF_ou_PJ=-1;
                        while(menu_PF_ou_PJ != 0){
                            System.out.println("Você deseja cadastrar um cliente:\n1 - PF\n2 - PJ\n0 - Voltar");
                            menu_PF_ou_PJ = entrada.nextInt();

                            if(menu_PF_ou_PJ==1){
                                System.out.println("           LISTA DE SEGURADORAS");
                                for(int i=0;i<ListaSeguradoras.size();i++){
                                    System.out.println((i+1)+" - "+ListaSeguradoras.get(i).getNome());
                                }
                                System.out.println("Em qual seguradora gostaria de cadastrar um cliente?");
                                Scanner entrada_c = new Scanner(System.in);
                                int seg_c = entrada_c.nextInt();


                                System.out.println("Nome:");
                                String nome = entrada.next();

                                System.out.println("Telefone:");
                                String telefone = entrada.next();

                                System.out.println("Gênero:");
                                String genero = entrada.next();

                                System.out.println("Educação:");
                                String educacao = entrada.next();

                                System.out.println("Endereço:");
                                String endereco = entrada.next();

                                System.out.println("Email:");
                                String email = entrada.next();


                                System.out.println("Data de nascimento (dd/MM/YYYY):");

                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                                String date = entrada.next();
                                //convert String to LocalDate
                                LocalDate data_nascimento = LocalDate.parse(date, formatter);

                                System.out.println("CPF:");
                                String cpf = entrada.next();
                                LocalDate agora = LocalDate.now();



                                if(ListaSeguradoras.size()==0){
                                    System.out.println("Ops, nenhuma seguradora cadastrada");
                                }
                                if(Validacao.validarCPF(cpf) && Validacao.valinarNOMEcliente(nome)){

                                    ListaSeguradoras.get(seg_c-1).cadastrarCliente(nome, telefone, genero, educacao,endereco, email, cpf, data_nascimento);
                                } else {
                                    if(!Validacao.validarCPF(cpf) && Validacao.valinarNOMEcliente(nome)){
                                        System.out.println("Seu CPF é INVÁLIDO!");
                                    } else if(!Validacao.valinarNOMEcliente(nome) && Validacao.validarCPF(cpf)){
                                        System.out.println("Nome do cliente INVÁLIDO!");
                                    } else if(!Validacao.validarCPF(cpf)&& !Validacao.valinarNOMEcliente(nome)){
                                        System.out.println("Nome e cpf do cliente inválidos!");
                                    }
                                    System.out.println("Tente novamente.");
                                }

                            } else if(menu_PF_ou_PJ==2){
                                System.out.println("Nome:");
                                String nome = entrada.next();

                                System.out.println("Telefone:");
                                String telefone = entrada.next();

                                System.out.println("Endereço:");
                                String endereco = entrada.next();

                                System.out.println("Email:");
                                String email = entrada.next();

                                System.out.println("Data da fundação:");
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                                String date = entrada.next();
                                //convert String to LocalDate
                                LocalDate data_fundacao = LocalDate.parse(date, formatter);

                                System.out.println("Quantidade de funcionários:");
                                int qtd_funcionarios = entrada.nextInt();

                                System.out.println("CNPJ:");
                                String cnpj = entrada.next();

                                if(ListaSeguradoras.size()==0){
                                    System.out.println("Ops, nenhuma seguradora cadastrada");
                                }
                                if(Validacao.validarCNPJ(cnpj) && Validacao.valinarNOMEcliente(nome)){

                                    ListaSeguradoras.get(0).cadastrarCliente(nome, telefone, endereco, email, cnpj, data_fundacao, qtd_funcionarios);
                                } else {
                                    if(!Validacao.validarCNPJ(cnpj) && Validacao.valinarNOMEcliente(nome)){
                                        System.out.println("Seu CPF é INVÁLIDO!");
                                    } else if(!Validacao.valinarNOMEcliente(nome) && Validacao.validarCNPJ(cnpj)){
                                        System.out.println("Nome do cliente INVÁLIDO!");
                                    } else if(!Validacao.validarCNPJ(cnpj)&& !Validacao.valinarNOMEcliente(nome)){
                                        System.out.println("Nome e cpf do cliente inválidos!");
                                    }
                                    System.out.println("Tente novamente.");
                                }
                            } else {
                                System.out.println("Comando inválido!");
                            }
                        }

                    } else if(menu_cadastrar==1.2){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                String pf_or_pj;
                                if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                                    pf_or_pj = "(Pessoa física)";
                                } else {
                                    pf_or_pj = "(Pessoa jurídica)";
                                }
                                System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);

                            }
                        }
                        System.out.println("Em qual SEGURADORA gostaria de cadastrar um veículo?");
                        Scanner entrada_v = new Scanner(System.in);
                        int seg_v = entrada_v.nextInt();
                        System.out.printf("Em qual cliente da seguradora %s você deseja cadastrar um veículo? (Apenas cliente PF)\n", ListaSeguradoras.get(seg_v-1).getNome());


                        int cliente_v = entrada_v.nextInt();

                        if(ListaSeguradoras.get(seg_v-1).listaClientes.get(cliente_v-1) instanceof ClientePF){
                            System.out.printf("Faça um cadastro de um veículo para o cliente %s\n", ListaSeguradoras.get(seg_v-1).listaClientes.get(cliente_v-1).getNome());

                            System.out.println("Placa:");
                            String placa = entrada_v.next();

                            System.out.println("Marca:");
                            String marca = entrada_v.next();

                            System.out.println("Modelo:");
                            String modelo = entrada_v.next();

                            System.out.println("Ano de fabricação:");
                            int ano = entrada_v.nextInt();

                            ((ClientePF)ListaSeguradoras.get(seg_v-1).listaClientes.get(cliente_v-1)).cadastrarVeiculo(placa, marca, modelo, ano);
                        } else {
                            System.out.println("Este cliente não é uma pessoa física!\n");
                        }


                    } else if(menu_cadastrar==1.3){

                        System.out.println("Nome:");
                        String nome = entrada.next();

                        System.out.println("Endereço:");
                        String endereco = entrada.next();

                        System.out.println("Telefone:");
                        String telefone = entrada.next();

                        System.out.println("Email:");
                        String email = entrada.next();

                        System.out.println("Cnpj:");
                        String cnpj = entrada.next();

                        Seguradora seg = new Seguradora(nome, telefone,  email, endereco, cnpj);
                        ListaSeguradoras.add(seg);
                    } else if(menu_cadastrar == 1.4){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                String pf_or_pj;
                                if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                                    pf_or_pj = "(Pessoa física)";
                                } else {
                                    pf_or_pj = "(Pessoa jurídica)";
                                }
                                System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);

                            }
                        }

                        System.out.println("Em qual SEGURADORA gostaria de cadastrar uma frota?");
                        Scanner entrada_f = new Scanner(System.in);
                        int seg_f = entrada_f.nextInt();

                        System.out.printf("Em qual cliente da seguradora %s você deseja cadastrar um veículo? (Apenas cliente PJ)\n", ListaSeguradoras.get(seg_f-1).getNome());

                        int cliente_f = entrada_f.nextInt();

                        if(ListaSeguradoras.get(seg_f-1).listaClientes.get(cliente_f-1) instanceof ClientePJ){

                            Frota f = new Frota();
                            System.out.println("Deseja cadastrar quantos veículos na frota?");

                            int qtd_veiculos_frota = entrada_f.nextInt();
                            for(int i=0;i<qtd_veiculos_frota;i++){
                                System.out.printf("%d° veículo\n",  i+1);
                                System.out.println("Placa:");
                                String placa = entrada_f.next();

                                System.out.println("Marca:");
                                String marca = entrada_f.next();

                                System.out.println("Modelo:");
                                String modelo = entrada_f.next();

                                System.out.println("Ano de fabricação:");
                                int ano = entrada_f.nextInt();

                                f.addVeiculo(new Veiculo(placa, marca, modelo, ano));
                            }

                            ((ClientePJ) ListaSeguradoras.get(seg_f-1).listaClientes.get(cliente_f-1)).cadastrarFrota(f);
                            System.out.println("Frota cadastrada!");
                        } else {
                            System.out.println("Este cliente não é uma pessoa jurídica!\n");
                        }

                    } else if(menu_cadastrar==1.5){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaSeguros.size();j++){
                                if(ListaSeguradoras.get(i).listaSeguros.get(j) instanceof SeguroPF){
                                    System.out.printf("%d - (%d) Cliente: %s Veículo: %s\n",j+1,ListaSeguradoras.get(i).listaSeguros.get(j).getId() ,((SeguroPF)ListaSeguradoras.get(i).listaSeguros.get(j)).getCliente().getNome(), ((SeguroPF)ListaSeguradoras.get(i).listaSeguros.get(j)).getVeiculo().getPlaca());
                                } else if(ListaSeguradoras.get(i).listaSeguros.get(j) instanceof SeguroPJ) {
                                    System.out.printf("%d - (%d) Cliente: %s\n", j+1,ListaSeguradoras.get(i).listaSeguros.get(j).getId(),((SeguroPJ)ListaSeguradoras.get(i).listaSeguros.get(j)).getCliente().getNome() );
                                }
                            }
                        }

                        System.out.println("Em qual seguradora gostaria de adicionar um condutor?");
                        Scanner entrada_s = new Scanner(System.in);
                        int seg_s = entrada_s.nextInt();
                        System.out.printf("Em qual seguro da seguradora %s você deseja adicionar um condutor?\n", ListaSeguradoras.get(seg_s-1).getNome());
                        int seguro_s = entrada_s.nextInt();

                        System.out.println("Nome:");
                        String nome = entrada_s.next();

                        System.out.println("Cpf:");
                        String cpf = entrada_s.next();

                        System.out.println("Telefone:");
                        String telefone = entrada_s.next();

                        System.out.println("Endereço:");
                        String endereco = entrada_s.next();

                        System.out.println("Email:");
                        String email = entrada_s.next();

                        System.out.println("Data de nascimento:");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                        String date = entrada_s.next();
                        //convert String to LocalDate
                        LocalDate data_nascimento = LocalDate.parse(date, formatter);

                        ListaSeguradoras.get(seg_s-1).listaSeguros.get(seguro_s-1).autorizarCondutor(cpf, nome, telefone, endereco, email, data_nascimento);

                    }else if(menu_cadastrar==0) {
                        System.out.println("Saindo do menu de cadastros...");
                    } else{
                        System.out.println("Comando inválido!");
                    }

                }
            } else if(menu_p == MenuOperacoes.LISTAR.getOperacao()){
                double menu_listar=-1;
                while(menu_listar!=0){

                    System.out.println("2.1 - Listar Cliente (PF/PJ) por Seg.\n2.2 - Listar Seguros por Seguradora\n2.3 - Listar Veículos por Cliente\n2.4 - Listar Frota por Cliente\n2.5 - Listar Sinistros por Seguradora\n2.6 - Listar Sinistros por Cliente\n2.7 - Listar Condutores por Seguro\n0 - Voltar");
                    menu_listar = entrada.nextDouble();

                    if(menu_listar==2.1){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);

                            System.out.println("CLIENTES PESSOA FÍSICA:");
                            List<Cliente> pf = ListaSeguradoras.get(i).listarCliente("PF");
                            for (Cliente cliente : pf) {
                                System.out.println(cliente);
                            }

                            System.out.println("CLIENTES PESSOA JURÍDICA:");
                            List<Cliente> pj = ListaSeguradoras.get(i).listarCliente("PJ");
                            for (Cliente cliente : pj) {
                                System.out.println(cliente);
                            }


//                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
//                                System.out.printf("%d - %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome());
//                            }
                        }
                    } else if(menu_listar==2.2){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaSeguros.size();j++){
                                if(ListaSeguradoras.get(i).listaSeguros.get(j) instanceof SeguroPF){
                                    System.out.printf("(%d) Cliente: %s Veículo: %s\n",ListaSeguradoras.get(i).listaSeguros.get(j).getId() ,((SeguroPF)ListaSeguradoras.get(i).listaSeguros.get(j)).getCliente().getNome(), ((SeguroPF)ListaSeguradoras.get(i).listaSeguros.get(j)).getVeiculo().getPlaca());
                                } else if(ListaSeguradoras.get(i).listaSeguros.get(j) instanceof SeguroPJ) {
                                    System.out.printf("(%d) Cliente: %s\n", ListaSeguradoras.get(i).listaSeguros.get(j).getId(),((SeguroPJ)ListaSeguradoras.get(i).listaSeguros.get(j)).getCliente().getNome() );
                                    ((SeguroPJ)ListaSeguradoras.get(i).listaSeguros.get(j)).getFrota().listarVeiculosDaFrota();
                                }
                            }
                        }
                    } else if(menu_listar==2.3){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                String pf_or_pj;
                                if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                                    pf_or_pj = "(Pessoa física)";
                                } else {
                                    pf_or_pj = "(Pessoa jurídica)";
                                }
                                System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);
                            }
                        }
                        System.out.println("Em qual seguradora gostaria de verificar um veículo?");
                        Scanner entrada_s = new Scanner(System.in);
                        int seg_s = entrada_s.nextInt();
                        System.out.printf("Qual cliente da seguradora %s você deseja ver o(s) veículo? (Apenas Pessoa Física)\n", ListaSeguradoras.get(seg_s-1).getNome());
                        int cliente_s = entrada_s.nextInt();

                        if(ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1) instanceof ClientePF){

                            if(((ClientePF)ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1)).listaVeiculos.size()!=0){

                                ((ClientePF) ListaSeguradoras.get(seg_s - 1).listaClientes.get(cliente_s - 1)).listarVeiculos();
                            } else {

                                System.out.println("O cliente não possui nenhum veículo.");
                            }
                        } else {
                            System.out.println("Este cliente não é uma pessoa física!\n");
                        }

                    } else if(menu_listar == 2.4){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                String pf_or_pj;
                                if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                                    pf_or_pj = "(Pessoa física)";
                                } else {
                                    pf_or_pj = "(Pessoa jurídica)";
                                }
                                System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);
                            }
                        }
                        System.out.println("Em qual seguradora gostaria de verificar uma frota?");
                        Scanner entrada_s = new Scanner(System.in);
                        int seg_s = entrada_s.nextInt();
                        System.out.printf("Qual cliente da seguradora %s você deseja ver a frota? (Apenas Pessoa Jurídica)\n", ListaSeguradoras.get(seg_s-1).getNome());
                        int cliente_s = entrada_s.nextInt();

                        if(ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1) instanceof ClientePJ){
                            for(int i=0;i<((ClientePJ)ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1)).listaFrota.size();i++){
                                System.out.printf("Frota %d:\n", i+1);
                                ((ClientePJ)ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1)).listaFrota.get(i).listarVeiculosDaFrota();
                            }
                        } else {
                            System.out.println("Este cliente não é uma pessoa física!\n");
                        }

                    }else if(menu_listar == 2.5){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                        }

                        System.out.println("Em qual seguradora verificar os sinistros?");
                        Scanner entrada_s = new Scanner(System.in);
                        int seg_l = entrada_s.nextInt();

                        for(int i=0;i<ListaSeguradoras.get(seg_l-1).listaSeguros.size();i++){
                            if(ListaSeguradoras.get(seg_l-1).listaSeguros.get(i).listaSinistros.size()>0){

                                for(int j=0;j<ListaSeguradoras.get(seg_l-1).listaSeguros.get(i).listaSinistros.size();j++){

                                    System.out.println(ListaSeguradoras.get(seg_l-1).listaSeguros.get(i).listaSinistros.get(j).toString());
                                }
                            }
                        }



                    }else if(menu_listar == 2.6){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                String pf_or_pj;
                                if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                                    pf_or_pj = "(Pessoa física)";
                                } else {
                                    pf_or_pj = "(Pessoa jurídica)";
                                }
                                System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);
                            }
                        }
                        System.out.println("Em qual seguradora gostaria de verificar um sinistro?");
                        Scanner entrada_s = new Scanner(System.in);
                        int seg_s = entrada_s.nextInt();
                        System.out.printf("Qual cliente da seguradora %s você deseja ver os sinistros?\n", ListaSeguradoras.get(seg_s-1).getNome());
                        int cliente_s = entrada_s.nextInt();

                        //System.out.println(ListaSeguradoras.get(seg_s-1).listaSeguros.get(cliente_s-1).listaSinistros.size());

                        for(int i=0;i<ListaSeguradoras.get(seg_s-1).listaSeguros.size();i++){
                            if(ListaSeguradoras.get(seg_s-1).listaSeguros.get(i) instanceof SeguroPF && ListaSeguradoras.get(seg_s-1).listaSeguros.get(cliente_s-1) instanceof SeguroPF){


                                    if(((SeguroPF)ListaSeguradoras.get(seg_s-1).listaSeguros.get(i)).getCliente().getCpf().equals(((SeguroPF)ListaSeguradoras.get(seg_s-1).listaSeguros.get(cliente_s-1)).getCliente().getCpf()))
                                        for(int j=0;j<ListaSeguradoras.get(seg_s-1).listaSeguros.get(i).listaSinistros.size();j++){
                                            System.out.println(ListaSeguradoras.get(seg_s-1).listaSeguros.get(i).listaSinistros.get(j).toString());
                                        }

                            } else if(ListaSeguradoras.get(seg_s-1).listaSeguros.get(i) instanceof SeguroPJ && ListaSeguradoras.get(seg_s-1).listaSeguros.get(cliente_s-1) instanceof SeguroPJ){


                                    if(((SeguroPJ)ListaSeguradoras.get(seg_s-1).listaSeguros.get(i)).getCliente().getCnpj().equals(((SeguroPJ)ListaSeguradoras.get(seg_s-1).listaSeguros.get(cliente_s-1)).getCliente().getCnpj()))

                                        for(int j=0;j<ListaSeguradoras.get(seg_s-1).listaSeguros.get(i).listaSinistros.size();j++){
                                            System.out.println(ListaSeguradoras.get(seg_s-1).listaSeguros.get(i).listaSinistros.get(j).toString());
                                        }

                            }
                        }

                    }else if(menu_listar == 2.7){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaSeguros.size();j++){
                                if(ListaSeguradoras.get(i).listaSeguros.get(j) instanceof SeguroPF){
                                    System.out.printf("%d - (%d) Cliente: %s Veículo: %s\n",j+1, ListaSeguradoras.get(i).listaSeguros.get(j).getId() ,((SeguroPF)ListaSeguradoras.get(i).listaSeguros.get(j)).getCliente().getNome(), ((SeguroPF)ListaSeguradoras.get(i).listaSeguros.get(j)).getVeiculo().getPlaca());
                                } else if(ListaSeguradoras.get(i).listaSeguros.get(j) instanceof SeguroPJ) {
                                    System.out.printf("%d - (%d) Cliente: %s\n", j+1, ListaSeguradoras.get(i).listaSeguros.get(j).getId(),((SeguroPJ)ListaSeguradoras.get(i).listaSeguros.get(j)).getCliente().getNome() );

                                }
                            }
                        }

                        System.out.println("Em qual seguradora ver os condutores?");
                        Scanner entrada_s = new Scanner(System.in);
                        int  seg_s= entrada_s.nextInt();
                        System.out.printf("Para qual seguro da seguradora %s você deseja ver os condutores?\n", ListaSeguradoras.get(seg_s-1).getNome());
                        int cliente_s = entrada_s.nextInt();

                        for(int i=0;i<ListaSeguradoras.get(seg_s-1).listaSeguros.get(cliente_s-1).listaCondutores.size();i++){
                            System.out.printf("Condutor %d -> ", i+1 );
                            System.out.println(ListaSeguradoras.get(seg_s-1).listaSeguros.get(cliente_s-1).listaCondutores.get(i));
                        }



                    }else if(menu_listar==0){
                        System.out.println("Saindo do menu listar...");
                    } else {
                        System.out.println("Comando inválido!");
                    }


                }
            } else if(menu_p == 3){
                for(int i=0;i<ListaSeguradoras.size();i++){
                    System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                    for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                        String pf_or_pj;
                        if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                            pf_or_pj = "(Pessoa física)";
                        } else {
                            pf_or_pj = "(Pessoa jurídica)";
                        }
                        System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);
                    }
                }
                System.out.println("Em qual seguradora gostaria de gerar um seguro?");
                Scanner entrada_s = new Scanner(System.in);
                int  seg_s= entrada_s.nextInt();
                System.out.printf("Para qual cliente da seguradora %s você deseja ver gerar um seguro?\n", ListaSeguradoras.get(seg_s-1).getNome());
                int cliente_s = entrada_s.nextInt();

                if(ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1) instanceof ClientePF){
                    if(((ClientePF)ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1)).listaVeiculos.size()==0){
                        System.out.println("Este cliente não possui veículos!");
                    } else {
                        for(int i=0;i<((ClientePF)ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1)).listaVeiculos.size();i++){
                            System.out.printf("%d - %s\n", i+1,((ClientePF)ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1)).listaVeiculos.get(i));
                        }

                        System.out.printf("Para qual veículo você deseja fazer o seguro?\n");

                        int  vei_s= entrada_s.nextInt();

                        //id, dataInicio, dataFim, seguradora, veiculo, cliente

                        System.out.println("Data da início:");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                        String date = entrada.next();
                        //convert String to LocalDate
                        LocalDate data_inicio = LocalDate.parse(date, formatter);

                        System.out.println("Data do fim:");
                        date = entrada.next();
                        //convert String to LocalDate
                        LocalDate data_fim = LocalDate.parse(date, formatter);

                        ListaSeguradoras.get(seg_s-1).gerarSeguro(data_inicio, data_fim,ListaSeguradoras.get(seg_s-1), ((ClientePF)ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1)).listaVeiculos.get(vei_s-1), ((ClientePF)ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1)) );
                        System.out.println("Seguro feito!");
                    }

                }
            } else if(menu_p == 4){

                double menu_excluir=-1;
                while(menu_excluir!=0){

                    System.out.println("4.1 - Excluir Cliente\n4.2 - Excluir Veículo\n4.3 - Excluir Frota\n4.4 - Excluir Sinistro\n0 - Sair");
                    menu_excluir = entrada.nextDouble();
                    if(menu_excluir == 4.1){

                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                String pf_or_pj;
                                if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                                    pf_or_pj = "(Pessoa física)";
                                } else {
                                    pf_or_pj = "(Pessoa jurídica)";
                                }
                                System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);

                            }
                        }
                        System.out.println();

                        System.out.println("Em qual seguradora gostaria de excluir um clente?");
                        Scanner entrada_e = new Scanner(System.in);
                        int  seg_e= entrada_e.nextInt();
                        System.out.printf("Para qual cliente da seguradora %s você deseja excluir um cliente?\n", ListaSeguradoras.get(seg_e-1).getNome());
                        int cliente_e = entrada_e.nextInt();



                        for(int i=0;i<ListaSeguradoras.get(seg_e-1).listaSeguros.size();i++){
                            if(ListaSeguradoras.get(seg_e-1).listaSeguros.get(i) instanceof SeguroPF){

                                    if(((SeguroPF)ListaSeguradoras.get(seg_e-1).listaSeguros.get(i)).getCliente().getCpf().equals(((ClientePF)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).getCpf())){
                                        ListaSeguradoras.get(seg_e-1).listaSeguros.remove(i);
                                    }


                            } else if(ListaSeguradoras.get(seg_e-1).listaSeguros.get(i) instanceof SeguroPJ) {

                                    if(((SeguroPJ)ListaSeguradoras.get(seg_e-1).listaSeguros.get(i)).getCliente().getCnpj().equals(((ClientePJ)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).getCnpj())){
                                        ListaSeguradoras.get(seg_e-1).listaSeguros.remove(i);
                                    }

                            }
                        }
                        ListaSeguradoras.get(seg_e-1).listaClientes.remove(cliente_e-1);

                    } else if(menu_excluir == 4.2){

                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                String pf_or_pj;
                                if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                                    pf_or_pj = "(Pessoa física)";
                                } else {
                                    pf_or_pj = "(Pessoa jurídica)";
                                }
                                System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);
                            }
                        }
                        System.out.println("Em qual seguradora gostaria de excluir um veículo?");
                        Scanner entrada_e = new Scanner(System.in);
                        int seg_e = entrada_e.nextInt();
                        System.out.printf("Qual cliente da seguradora %s você deseja excluir um veículo? (Apenas Pessoa Física)\n", ListaSeguradoras.get(seg_e-1).getNome());
                        int cliente_e = entrada_e.nextInt();

                        if(ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1) instanceof ClientePF){

                            if(((ClientePF)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).listaVeiculos.size()!=0){

                                ((ClientePF) ListaSeguradoras.get(seg_e - 1).listaClientes.get(cliente_e - 1)).listarVeiculos();

                                System.out.println("Qual veículo gostaria de excluir?");

                                int veiculo_e = entrada_e.nextInt();

                                for(int i=0;i<ListaSeguradoras.get(seg_e-1).listaSeguros.size();i++){
                                    if(ListaSeguradoras.get(seg_e-1).listaSeguros.get(i) instanceof SeguroPF){

                                        if(((SeguroPF)ListaSeguradoras.get(seg_e-1).listaSeguros.get(veiculo_e-1)).getVeiculo().getPlaca().equals((((SeguroPF)ListaSeguradoras.get(seg_e-1).listaSeguros.get(i)).getVeiculo().getPlaca()))){
                                            ListaSeguradoras.get(seg_e-1).listaSeguros.remove(i);
                                        }


                                    }
                                }


                            } else {

                                System.out.println("O cliente não possui nenhum veículo.");
                            }
                        } else {
                            System.out.println("Este cliente não é uma pessoa física!\n");
                        }

//                        for(int i=0;i<(((ClientePF)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).listaVeiculos.size());i++){
//                            System.out.printf("%d - " + ((ClientePF)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).listaVeiculos.get(i), i+1);
//                        }
//                        if(ListaSeguradoras.get(seg_e).listaClientes.get(cliente_e-1) instanceof ClientePF){
//
//                        } else {
//                            System.out.println("Este cliente não é um");
//                        }


                    } else if(menu_excluir == 4.3){

                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                String pf_or_pj;
                                if(ListaSeguradoras.get(i).listaClientes.get(j) instanceof ClientePF){
                                    pf_or_pj = "(Pessoa física)";
                                } else {
                                    pf_or_pj = "(Pessoa jurídica)";
                                }
                                System.out.printf("%d - %s %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome(), pf_or_pj);
                            }
                        }
                        System.out.println("Em qual seguradora gostaria de excluir uma frota?");
                        Scanner entrada_e = new Scanner(System.in);
                        int seg_e = entrada_e.nextInt();
                        System.out.printf("Qual cliente da seguradora %s você excluir uma frota? (Apenas Pessoa Jurídica)\n", ListaSeguradoras.get(seg_e-1).getNome());
                        int cliente_e = entrada_e.nextInt();

                        if(ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1) instanceof ClientePJ){
                            for(int i=0;i<((ClientePJ)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).listaFrota.size();i++){
                                System.out.printf("Frota %d:\n", i+1);
                                ((ClientePJ)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).listaFrota.get(i).listarVeiculosDaFrota();

                                System.out.println("Qual frota gostaria de excluir?");

                                int frota_e = entrada_e.nextInt();


                                for(int j=0;j<ListaSeguradoras.get(seg_e-1).listaSeguros.size();j++){
                                    if(ListaSeguradoras.get(seg_e-1).listaSeguros.get(j) instanceof SeguroPJ){

                                        if(((SeguroPJ)ListaSeguradoras.get(seg_e-1).listaSeguros.get(j)).getFrota().getCode()==((ClientePJ)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).listaFrota.get(frota_e-1).getCode()){
                                            ListaSeguradoras.get(seg_e-1).listaSeguros.remove(j);
                                        }

                                    }
                                }


                            }
                        } else {
                            System.out.println("Este cliente não é uma pessoa física!\n");
                        }

//                        if(ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1) instanceof ClientePJ){
//
//                            if(((ClientePJ)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).listaFrota.size()!=0){
//
//                                for(int k=0;k<((ClientePJ)ListaSeguradoras.get(seg_e-1).listaClientes.get(cliente_e-1)).listaFrota.size();k++){
//                                    System.out.println();
//                                }
//                                ((ClientePJ) ListaSeguradoras.get(seg_e - 1).listaClientes.get(cliente_e - 1)).listarVeiculos();
//
//                                System.out.println("Qual veículo gostaria de excluir?");
//
//                                int veiculo_e = entrada_e.nextInt();
//
//                                for(int i=0;i<ListaSeguradoras.get(seg_e-1).listaSeguros.size();i++){
//                                    if(ListaSeguradoras.get(seg_e-1).listaSeguros.get(i) instanceof SeguroPF){
//
//                                        if(((SeguroPF)ListaSeguradoras.get(seg_e-1).listaSeguros.get(veiculo_e-1)).getVeiculo().getPlaca().equals((((SeguroPF)ListaSeguradoras.get(seg_e-1).listaSeguros.get(i)).getVeiculo().getPlaca()))){
//                                            ListaSeguradoras.get(seg_e-1).listaSeguros.remove(i);
//                                        }
//
//
//                                    }
//                                }


                    } else if(menu_excluir == 0){
                        System.out.println("Saindo do menu excluir...");
                    }
                }



            } else if(menu_p == 5){
                for(int i=0;i<ListaSeguradoras.size();i++){
                    System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                    for(int j=0;j<ListaSeguradoras.get(i).listaSeguros.size();j++){
                        if(ListaSeguradoras.get(i).listaSeguros.get(j) instanceof SeguroPF){
                            System.out.printf("%d - (%d) Cliente: %s Veículo: %s\n",j+1, ListaSeguradoras.get(i).listaSeguros.get(j).getId() ,((SeguroPF)ListaSeguradoras.get(i).listaSeguros.get(j)).getCliente().getNome(), ((SeguroPF)ListaSeguradoras.get(i).listaSeguros.get(j)).getVeiculo().getPlaca());
                        } else if(ListaSeguradoras.get(i).listaSeguros.get(j) instanceof SeguroPJ) {
                            System.out.printf("%d - (%d) Cliente: %s\n", j+1, ListaSeguradoras.get(i).listaSeguros.get(j).getId(),((SeguroPJ)ListaSeguradoras.get(i).listaSeguros.get(j)).getCliente().getNome() );

                        }
                    }
                }

                System.out.println("Em qual seguradora deseja gerar um sinistro?");
                Scanner entrada_s = new Scanner(System.in);
                int  seg_s= entrada_s.nextInt();
                if(ListaSeguradoras.get(seg_s-1).listaSeguros.size()>0){
                    System.out.printf("Para qual seguro da seguradora %s você deseja gerar um sinistro?\n", ListaSeguradoras.get(seg_s-1).getNome());
                    int seguro_s = entrada_s.nextInt();


                    if(ListaSeguradoras.get(seg_s-1).listaSeguros.get(seguro_s-1).listaCondutores.size()>0){
                        for(int i=0;i<ListaSeguradoras.get(seg_s-1).listaSeguros.get(seguro_s-1).listaCondutores.size();i++){
                            System.out.printf("Condutor %d -> ", i+1 );
                            System.out.println(ListaSeguradoras.get(seg_s-1).listaSeguros.get(seguro_s-1).listaCondutores.get(i));
                        }

                        System.out.printf("Para qual condutor deseja gerar o sinistro?\n", ListaSeguradoras.get(seg_s-1).getNome());
                        int condutor_s = entrada_s.nextInt();

                        System.out.println("Endereço:");
                        String endereco = entrada_s.next();

                        System.out.println("Data do Sinistro:");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                        String date = entrada.next();
                        //convert String to LocalDate
                        LocalDate data_sinistro = LocalDate.parse(date, formatter);

                        ListaSeguradoras.get(seg_s-1).listaSeguros.get(seguro_s-1).gerarSinistro(data_sinistro, endereco, ListaSeguradoras.get(seg_s-1).listaSeguros.get(seguro_s-1).listaCondutores.get(condutor_s-1), ListaSeguradoras.get(seg_s-1).listaSeguros.get(seguro_s-1));

                        System.out.println("Sinistro gerado com sucesso!");
                    } else {
                        System.out.println("Este seguro não possui nenhum condutor cadastrado!");
                    }

                } else {
                    System.out.println("Essa seguradora não possui nenhum seguro cadastrado!");
                }

            } else if(menu_p == 6){
                for(int i=0;i<ListaSeguradoras.size();i++){
                    System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                }
                System.out.println("Gostaria de ver a receita de qual seguradora?");
                Scanner entrada_e = new Scanner(System.in);
                int seg_e = entrada_e.nextInt();

                System.out.printf("A receita da seguradora %s é R$%.2f\n",ListaSeguradoras.get(seg_e-1).getNome(), ListaSeguradoras.get(seg_e-1).calcularReceita());


            }


        }
    }
}