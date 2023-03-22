
public class Main {
    public static void main(String[] args) {

        Cliente leandro = new Cliente("Leandro", "105.150.126-10", "15 de junho de 2002", 20, "unicampp");
        Veiculo v1 = new Veiculo("HGE-9443", "Volvo", "GLC-300");
        Seguradora s1 = new Seguradora("Porto Seguro", "34414271", "aaaaaaaa@unicamp.br", "Instituto de Computação da Unicamp");
        Sinistro sinistro1 = new Sinistro("31/02/2000", "IMECC");

        System.out.println(leandro);
        System.out.println(v1);
        System.out.println(s1);
        System.out.println(sinistro1);

        leandro.setNome("Henrique");
        System.out.println(leandro.getNome());
        System.out.println(leandro.getCpf());
        System.out.println(leandro.getDataNascimento());
        System.out.println(leandro.getIdade());
        System.out.println(leandro.getEndereco());

        v1.setPlaca("AAA-0000");
        System.out.println(v1.getPlaca());
        System.out.println(v1.getMarca());
        System.out.println(v1.getModelo());

        s1.setNome("Wiz");
        System.out.println(s1.getNome());
        System.out.println(s1.getTelefone());
        System.out.println(s1.getEmail());
        System.out.println(s1.getEndereco());

        sinistro1.setData("00/00/0000");
        System.out.println(sinistro1.getData());
        System.out.println(sinistro1.getEndereco());

        System.out.println(leandro.validarCPF());
    }
}