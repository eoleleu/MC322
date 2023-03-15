import java.util.Random;
public class Sinistro {
    private int id;
    private String data;
    private String endereco;

    public Sinistro(String data, String endereco){
        this.data = data;
        this.endereco = endereco;
        id = gerarID();
    }

    public int gerarID(){
        Random gerador = new Random();
        return gerador.nextInt(99999);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getData(){
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}
