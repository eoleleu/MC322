
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class AppMain {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);

        List<Seguradora> ListaSeguradoras = new ArrayList<>();
//        LocalDateTime agora = LocalDateTime.now();
//        System.out.println(agora.getYear());
//        System.out.println(localDate.getYear());

        Seguradora s1 = new Seguradora("Porto Seguro", "aodasda", "l213437@gmail.com", "ofaajdasod");
        ListaSeguradoras.add(s1);

        s1.cadastrarCliente("Leandro", "Rua COndessa do Pinhal", "M", LocalDate.of(2018, 7, 22), "Ensino superior incompleto",LocalDate.of(2002, 6, 15), "Baixa",0,"018.372.696-02");
        s1.cadastrarCliente("Unicamp", "Av.1", LocalDate.of(1966, 10, 5), 8000, 0, "46.068.425/0001-33");
        s1.cadastrarCliente("Gustavo", "Rua COndessa do Pinhal", "M", LocalDate.of(2018, 7, 22), "Ensino superior incompleto",LocalDate.of(1975, 6, 15), "Baixa",0,"018.372.696-02");
        s1.cadastrarCliente("Ana", "Rua COndessa do Pinhal", "M", LocalDate.of(2018, 7, 22), "Ensino superior incompleto",LocalDate.of(1969, 7, 17), "Baixa",0,"018.372.696-02");


        s1.listaClientes.get(0).cadastrarVeiculo("HGE-9443", "Volks", "Fox", 2011);
        s1.listaClientes.get(1).cadastrarVeiculo("BBB-1111", "BMW", "Palio", 2021);
        s1.listaClientes.get(2).cadastrarVeiculo("CCC-2222", "Porsche", "Uno", 2001);
        s1.listaClientes.get(2).cadastrarVeiculo("MKT-8450", "Mercedes", "GLE", 2023);
        s1.listaClientes.get(3).cadastrarVeiculo("AAA-1111", "Volks", "Fox", 2011);

        s1.gerarSinistro(LocalDate.of(2022, 1,1), "av.2", ListaSeguradoras.get(0), ListaSeguradoras.get(0).listaClientes.get(0),ListaSeguradoras.get(0).listaClientes.get(0).listaVeiculos.get(0));
        s1.gerarSinistro(LocalDate.of(2021, 2,3), "av.1", ListaSeguradoras.get(0), ListaSeguradoras.get(0).listaClientes.get(1),ListaSeguradoras.get(0).listaClientes.get(1).listaVeiculos.get(0));

        System.out.println(s1.listarCliente("PF"));
        System.out.println(s1.listarCliente("PJ"));

        s1.visualizarSinistro(s1.listaClientes.get(0).getNome());

        s1.listarSinistros();

        s1.calcularReceita();

        s1.calcularPrecoSeguroCliente();
        System.out.printf("R$%.2f\n", s1.calcularReceita());



//        Seguradora s2 = new Seguradora("SulaAmerica", "aodasda", "l213437@gmail.com", "ofaajdasod");
//        ListaSeguradoras.add(s2);


        int menu_p = -1;
        while (menu_p != 0) {
            System.out.println("1 - Cadastros\n2 - Listar\n3 - Exclur\n4 - Gerar Sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n0 - Sair");
            menu_p = entrada.nextInt();

            if(menu_p == MenuOperacoes.CADASTRAR.getOperacao()){
                double menu_cadastrar=-1;
                while(menu_cadastrar!=0){

                    System.out.println("1.1 - Cadastrar Cliente PF/PJ\n1.2 - Cadastrar Veículo\n1.3 - Cadastrar Seguradora\n0 - Voltar");
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

                                System.out.println("Endereço:");
                                String endereco = entrada.next();

                                System.out.println("Gênero:");
                                String genero = entrada.next();

                                System.out.println("Educação:");
                                String educacao = entrada.next();

                                System.out.println("Data de nascimento (dd/MM/YYYY):");

                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                                String date = entrada.next();
                                //convert String to LocalDate
                                LocalDate data_nascimento = LocalDate.parse(date, formatter);

                                System.out.println("Classe econômica:");
                                String classeEconomica = entrada.next();

                                System.out.println("CPF:");
                                String cpf = entrada.next();
                                LocalDate agora = LocalDate.now();



                                if(ListaSeguradoras.size()==0){
                                    System.out.println("Ops, nenhuma seguradora cadastrada");
                                }
                                if(Validacao.validarCPF(cpf) && Validacao.valinarNOMEcliente(nome)){

                                    ListaSeguradoras.get(seg_c-1).cadastrarCliente(nome, endereco, genero,agora, educacao,
                                            data_nascimento, classeEconomica, 0.0, cpf);
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

                                System.out.println("Endereço:");
                                String endereco = entrada.next();

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

                                    ListaSeguradoras.get(0).cadastrarCliente(nome, endereco, data_fundacao,qtd_funcionarios,0, cnpj);
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
                                System.out.printf("%d - %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome());
                            }
                        }
                        System.out.println("Em qual seguradora gostaria de cadastrar um veículo?");
                        Scanner entrada_v = new Scanner(System.in);
                        int seg_v = entrada_v.nextInt();
                        System.out.printf("Em qual cliente da seguradora %s você deseja cadastrar um veículo?\n", ListaSeguradoras.get(seg_v-1).getNome());
                        int cliente_v = entrada_v.nextInt();
                        System.out.printf("Faça um cadastro de um veículo para o cliente %s\n", ListaSeguradoras.get(seg_v-1).listaClientes.get(cliente_v-1).getNome());

                        System.out.println("Placa:");
                        String placa = entrada_v.next();

                        System.out.println("Marca:");
                        String marca = entrada_v.next();

                        System.out.println("Modelo:");
                        String modelo = entrada_v.next();

                        System.out.println("Ano de fabricação:");
                        int ano = entrada_v.nextInt();

                        ListaSeguradoras.get(seg_v-1).listaClientes.get(cliente_v-1).cadastrarVeiculo(placa, marca, modelo, ano);

                    } else if(menu_cadastrar==1.3){

                        System.out.println("Nome:");
                        String nome = entrada.next();

                        System.out.println("Endereço:");
                        String endereco = entrada.next();

                        System.out.println("Telefone:");
                        String telefone = entrada.next();

                        System.out.println("Email:");
                        String email = entrada.next();

                        Seguradora seg = new Seguradora(nome, telefone, email, endereco);
                        ListaSeguradoras.add(seg);
                    } else if(menu_cadastrar==0) {
                        System.out.println("Saindo do menu de cadastros...");
                    } else{
                        System.out.println("Comando inválido!");
                    }

                }
            } else if(menu_p == MenuOperacoes.LISTAR.getOperacao()){
                double menu_listar=-1;
                while(menu_listar!=0){

                    System.out.println("2.1 - Listar Cliente (PF/PJ) por Seg.\n2.2 - Listar Sinistros por Seguradora\n2.3 - Listar Sinistro por Cliente\n2.4 - Listar Veiculo por Cliente\n2.5 - Listar Veiculo por Seguradora\n0 - Voltar");
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
                            ListaSeguradoras.get(i).listarSinistros();
//                            for(int j=0;j<ListaSeguradoras.get(i).listaSinistros.size();j++){
//                                System.out.printf("%d - %s\n", j+1, ListaSeguradoras.get(i).listaSinistros.get(j).toString());
//                            }
                        }
                    } else if(menu_listar==2.3){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                System.out.printf("%d - %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome());
                            }
                        }
                        System.out.println("Em qual seguradora gostaria de verificar um sinistro?");
                        Scanner entrada_s = new Scanner(System.in);
                        int seg_s = entrada_s.nextInt();
                        System.out.printf("Qual cliente da seguradora %s você deseja ver os sinistros?\n", ListaSeguradoras.get(seg_s-1).getNome());
                        int cliente_s = entrada_s.nextInt();

                        ListaSeguradoras.get(seg_s-1).visualizarSinistro(ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1).getNome());
                    } else if(menu_listar==2.4){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                System.out.printf("%d - %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome());
                            }
                        }
                        System.out.println("Em qual seguradora gostaria de verificar um veículo?");
                        Scanner entrada_s = new Scanner(System.in);
                        int seg_s = entrada_s.nextInt();
                        System.out.printf("Qual cliente da seguradora %s você deseja ver o(s) veículo?\n", ListaSeguradoras.get(seg_s-1).getNome());
                        int cliente_s = entrada_s.nextInt();

                        if(ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1).listaVeiculos.size()!=0){

                            ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1).listarVeiculos();
                        } else {
                            System.out.println("O cliente não possui nenhum veículo.");
                        }
                    } else if(menu_listar==2.5){
                        for (int i=0;i<ListaSeguradoras.size();i++){
                            System.out.println(ListaSeguradoras.get(i).getNome());
                            for (int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                ListaSeguradoras.get(i).listaClientes.get(j).listarVeiculos();
                            }
                        }
                    } else if(menu_listar==0){
                        System.out.println("Saindo do menu listar...");
                    } else {
                        System.out.println("Comando inválido!");
                    }


                }
            } else if(menu_p == MenuOperacoes.EXCLUIR.getOperacao()){
                double menu_excluir=-1;
                while(menu_excluir!=0){

                    System.out.println("3.1 - Excluir Cliente\n3.2 - Excluir Veiculo\n3.3 - Excluir Sinistro\n0 - Voltar");
                    menu_excluir= entrada.nextDouble();

                    if(menu_excluir==3.1){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                System.out.printf("%d - %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome());
                            }
                        }
                        System.out.println("Em qual seguradora gostaria excluir um cliente?");
                        Scanner entrada_e = new Scanner(System.in);
                        int seg_e = entrada_e.nextInt();
                        System.out.printf("Qual cliente da seguradora %s você deseja ver o(s) veículo?\n", ListaSeguradoras.get(seg_e-1).getNome());
                        int cliente_e = entrada_e.nextInt();

                        ListaSeguradoras.get(seg_e).removerCliente(ListaSeguradoras.get(seg_e).listaClientes.get(cliente_e).getNome());
                    } else if(menu_excluir==3.2){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            for(int j=0;j<ListaSeguradoras.get(i).listaClientes.size();j++){
                                System.out.printf("%d - %s\n", j+1, ListaSeguradoras.get(i).listaClientes.get(j).getNome());
                                for(int k=0;k<ListaSeguradoras.get(i).listaClientes.get(j).listaVeiculos.size();k++){
                                    System.out.printf("%d - %s", k+1, ListaSeguradoras.get(i).listaClientes.get(j).listaVeiculos.get(k).toString());
                                }

                            }
                        }
                        System.out.println("Em qual seguradora gostaria excluir um veiculo?");
                        Scanner entrada_e = new Scanner(System.in);
                        int seg_e = entrada_e.nextInt();
                        System.out.printf("Em qual cliente da seguradora %s você deseja ver excluir um veículo?\n", ListaSeguradoras.get(seg_e-1).getNome());
                        int cliente_e = entrada_e.nextInt();
                        System.out.printf("Qual veículo do cliente %s você deseja excluir?", ListaSeguradoras.get(seg_e).listaClientes.get(cliente_e-1).getNome());
                        int veiculo_e = entrada_e.nextInt();

                        ListaSeguradoras.get(seg_e).listaClientes.get(cliente_e).listaVeiculos.remove(veiculo_e-1);
                    } else if(menu_excluir==3.3){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                            ListaSeguradoras.get(i).listarSinistros();
                        }

                        System.out.println("Em qual seguradora gostaria excluir um sinistro?");
                        Scanner entrada_e = new Scanner(System.in);
                        int seg_e = entrada_e.nextInt();

                        ListaSeguradoras.get(seg_e).listarSinistros();

                        System.out.println("Digite o ID do sinistro que deseja excluir:");
                        int ID_e = entrada_e.nextInt();

                        ListaSeguradoras.get(seg_e).removerSinistro(ID_e);


                    }

                }
            } else if(menu_p == MenuOperacoes.GERAR_SINISTRO.getOperacao()){
                double menu_sinistro = -1;
                while (menu_sinistro!=0){

                    System.out.println("4.1 - Gerar novo sinistro\n0 - Voltar");
                    menu_sinistro= entrada.nextDouble();
                    if(menu_sinistro==4.1){


                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%s(%d)\n", ListaSeguradoras.get(i).getNome(), i+1);
                        }

                        System.out.println("Selecione em qual seguradora você deseja registrar o sinistro:");
                        Scanner entrada_s = new Scanner(System.in);
                        int seg_s = entrada_s.nextInt();

                        for(int i=0;i<ListaSeguradoras.get(seg_s-1).listaClientes.size();i++){
                            System.out.printf("%d - %s\n", i+1, ListaSeguradoras.get(seg_s-1).listaClientes.get(i).getNome());
                        }

                        System.out.println("Selecione em qual cliente você deseja registrar o sinistro:");
                        int cliente_s = entrada_s.nextInt();

                        for(int i=0;i<ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1).listaVeiculos.size();i++){
                            System.out.printf("%d - %s\n", i+1, ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1).listaVeiculos.get(i).getPlaca());
                        }

                        System.out.println("Selecione o veículo que deseja registrar o sinistro:");
                        int veiculo_s = entrada_s.nextInt();


                        System.out.println("Data do sinistro(DD/MM/YYYY):");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                        String date = entrada_s.next();

                        LocalDate data_sinistro = LocalDate.parse(date, formatter);

                        System.out.println("Endereço onde ocorrreu o sinistro:");
                        String endereco = entrada_s.next();

                        ListaSeguradoras.get(seg_s-1).gerarSinistro(data_sinistro, endereco, ListaSeguradoras.get(seg_s-1), ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1), ListaSeguradoras.get(seg_s-1).listaClientes.get(cliente_s-1).listaVeiculos.get(veiculo_s-1));
                        System.out.println("Sinistro gerado com sucesso!");
                    } else if(menu_sinistro==0){
                        System.out.println("Saindo do menu gerar sinistro...");
                    } else {
                        System.out.println("Ops, comando inválido!");
                    }



                }

            } else if(menu_p==MenuOperacoes.TRANSFERIR_SEGURO.getOperacao()){
                double menu_troca = -1;
                while(menu_troca!=0){
                    System.out.println("5.1 - Transferir seguro\n0 - Voltar");
                    menu_troca= entrada.nextDouble();

                    if(menu_troca==5.1){
                        for(int i=0;i<ListaSeguradoras.size();i++){
                            System.out.printf("%d - %s\n", i+1, ListaSeguradoras.get(i).getNome());
                        }
                        System.out.println("0 - Voltar");
                        System.out.println("Selecione a Seguradora na qual você deja fazer a transferência de seguro entre clientes");
                        Scanner entrada_tr = new Scanner(System.in);
                        int seg_tr = entrada_tr.nextInt();


                        for(int i=0;i<ListaSeguradoras.get(seg_tr-1).listaClientes.size();i++){
                            System.out.printf("%d - %s\n", i+1, ListaSeguradoras.get(seg_tr-1).listaClientes.get(i).getNome());
                        }
                        System.out.println("Selecione o cliente que receberá a transferência:");
                        int cliente1_tr = entrada_tr.nextInt();

                        System.out.println("Selecione o cliente que irá tranferir o seu seguro:");
                        int cliente2_tr = entrada_tr.nextInt();

                        for(int i=0;i<ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.size();i++){
                            ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente1_tr-1).cadastrarVeiculo(ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.get(i).getPlaca(),
                                    ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.get(i).getMarca(), ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.get(i).getModelo(),
                                    ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.get(i).getAnoFabricacao());
                        }

                        for(int i=0;i<ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.size();i++){
                            Veiculo v1 = ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.get(0);
                            ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.remove(v1);
                            i-=1;
                        }

                        if(ListaSeguradoras.get(seg_tr-1).listaClientes.get(cliente2_tr-1).listaVeiculos.size()==0){
                            System.out.println("Transferência realizada com sucesso!");
                        }


                    } else if(menu_troca==0){
                        System.out.println("Saindo do menu transferência de seguro");
                    } else{
                        System.out.println("Ops, comando inválido!");
                    }





                }
            } else if(menu_p ==MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.getOperacao()){
                int menu_receita=-1;
                while(menu_receita!=0){
                    System.out.println("Selecione a Seguradora na qual deseja calcular a receita:");

                    for(int i=0;i<ListaSeguradoras.size();i++){
                        System.out.printf("%d - %s\n", i+1, ListaSeguradoras.get(i).getNome());
                    }
                    System.out.println("0 - Voltar");
                    menu_receita= entrada.nextInt();
                    if(menu_receita!=0){
                        ListaSeguradoras.get(menu_receita-1).calcularPrecoSeguroCliente();
                        System.out.printf("A receita da seguradora %s é R$%.2f\n", ListaSeguradoras.get(menu_receita-1).getNome(), ListaSeguradoras.get(menu_receita-1).calcularReceita());
                    }

                }

            }else {
                if(menu_p == MenuOperacoes.SAIR.getOperacao()){
                    System.out.println("Saiu do sistema!");
                } else {

                    System.out.println("Comando inválido!");
                }
            }


        }
//        ListaSeguradoras.get(0).calcularPrecoSeguroCliente();
//        System.out.println(ListaSeguradoras.get(0).listaClientes.get(0).getValorSeguro());
    }
}
