
public class Main {
    public static void main(String[] args) {
//        Sinistro batida = new Sinistro("aaa", "fsa");
//        System.out.printf("%d", batida.getId());
        Cliente leandro = new Cliente("Leandro", "111.444.777-35", "15 de junho de 2002", 20, "unicampp");
        System.out.println(leandro.validarCPF());
    }
}