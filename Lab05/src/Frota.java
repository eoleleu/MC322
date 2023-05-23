import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frota {
    private final int code;
    public List<Veiculo> listaVeiculos = new ArrayList<>();

    public Frota(){
        Random gerador = new Random();
        this.code = gerador.nextInt(99999) ;
    }

    public boolean addVeiculo(Veiculo veiculo){
        listaVeiculos.add(veiculo);
        return true;
    }
    public boolean addVeiculo(String placa, String marca, String modelo, int anoFabricacao){
        listaVeiculos.add(new Veiculo(placa, marca, modelo, anoFabricacao));
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

    public int getCode() {
        return code;
    }

    public void listarVeiculosDaFrota(){
        for(int i=0;i<listaVeiculos.size();i++){
            System.out.println(listaVeiculos.get(i));
        }
    }




}
