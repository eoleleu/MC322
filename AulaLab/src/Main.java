import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
//        Sinistro batida = new Sinistro();
//        System.out.printf("%d", batida.getId());
        Cliente leandro = new Cliente("Leandro", "018.372.696-02", "15 de junho de 2002", 20, "unicampp");
        leandro.validarCPF();
        System.out.println(leandro.getCpf());
    }
}