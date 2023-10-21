
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class AppMain {
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);

        List<Seguradora> ListaSeguradoras = new ArrayList<>();

        //Criando uma seguradora
        Seguradora s1 = new Seguradora("Porto Seguro", "aodasda", "l213437@gmail.com", "ofaajdasod", "46.068.425/0001-33");
        ListaSeguradoras.add(s1);

//        int menu_p = -1;
//        while (menu_p != 0) {
//            System.out.println("1 - Cadastros\n2 - Listar\n3 - Gerar Seguro\n4 - Excluir\n5 - Gerar Sinistro\n6 - Atualizar Frota\n7 - Calcular Receita Seguradora\n8 - Ler arquivos CSV\n0 - Sair");
//            menu_p = entrada.nextInt();
//
//
//        }




        String arquivoCSV = "Lab06/clientesPF.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        try {
            br = new BufferedReader(new FileReader("Lab06/veiculos.csv"));
            int cont=0;
            List<Veiculo> lista_veiculos = new ArrayList<>();
            while((linha = br.readLine())!= null){
                String[] linhaa = linha.split(csvDivisor);

                if(cont!=0){
                    lista_veiculos.add(new Veiculo(linhaa[0], linhaa[1], linhaa[2], Integer.parseInt(linhaa[3])));
                }
                cont+=1;
            }


            br = new BufferedReader(new FileReader("Lab06/clientesPF.csv"));
            cont=0;
            while ((linha = br.readLine()) != null) {

                String[] linhaa = linha.split(csvDivisor);
                if(cont!=0){
//                    String nome, String telefone,String genero, String educacao, String endereco, String email, String cpf, LocalDate dataNascimento
//                    for(int i=0;i<linhaa.length;i++){
//                        System.out.printf("%s %d||",linhaa[i], i);
//                    }
                    if(Validacao.validarCPF(linhaa[0])){
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        ListaSeguradoras.get(0).cadastrarCliente(linhaa[1], linhaa[2],linhaa[5], linhaa[6], linhaa[3], linhaa[4], linhaa[0], LocalDate.parse(linhaa[7], formatter));
                        for(int i=0;i<lista_veiculos.size();i++){
                            if(lista_veiculos.get(i).getPlaca().equals(linhaa[8])){
                                if(ListaSeguradoras.get(0).listaClientes.get(ListaSeguradoras.get(0).listaClientes.size()-1) instanceof ClientePF){
                                    ((ClientePF) ListaSeguradoras.get(0).listaClientes.get(ListaSeguradoras.get(0).listaClientes.size()-1)).cadastrarVeiculo(lista_veiculos.get(i).getPlaca(), lista_veiculos.get(i).getMarca(), lista_veiculos.get(i).getModelo(), lista_veiculos.get(i).getAnoFabricacao());
                                }

                            }
                        }
                    }

                }
                cont+=1;

            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println(        ((ClientePF)ListaSeguradoras.get(0).listaClientes.get(0)).listaVeiculos.get(0).getPlaca());
        System.out.println(        ((ClientePF)ListaSeguradoras.get(0).listaClientes.get(7)).listaVeiculos.get(0).getPlaca());


//        try {
//            BufferedWriter brr = new BufferedWriter(new FileWriter("Lab06/clientesTEST4.csv"));
//            PrintWriter out = new PrintWriter(brr);
//
//            out.append("21488869839 ,João da Silva ,(11) 1234-5678 ,Rua das Flores ,joao.silva@example.com ,Masculino ,Superior ,1980-05-10 ,ABC-1234");
//            out.newLine();
//            out.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            // O parametro é que indica se deve sobrescrever ou continua no
//            // arquivo.
//            FileWriter fw = new FileWriter("Lab06/clientesPF.csv", true);
//            BufferedWriter conexao = new BufferedWriter(fw);
//
//
//            conexao.write("vamos ver");
//            conexao.append(" carai");
//            conexao.newLine();
//            conexao.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }


}

