import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frota {
    private String code;
    public List<Veiculo> listaVeiculos = new ArrayList<>();

    public Frota(String code){
        this.code = code;
    }

    public boolean addVeiculo(Veiculo veiculo){
        listaVeiculos.add(veiculo);
        return true;
    }

    public boolean removeVeiculo(Veiculo veiculo){
        for(int i=0;i<listaVeiculos.size();i++){
            if(listaVeiculos.get(i).getPlaca().equals(veiculo.getPlaca())){
                listaVeiculos.remove(i);
                return true;
            }
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
