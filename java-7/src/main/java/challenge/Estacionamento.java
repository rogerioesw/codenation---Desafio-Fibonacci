package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> carrosEstacionados = new ArrayList<Carro>();
    private List<Carro> carrosPrioritarios = new ArrayList<Carro>();
    private List<Carro> carrosNaoPrioritarios = new ArrayList<Carro>();
    //private Integer qntEstacionados = 0;

    public void estacionar(Carro carro) {

        if(validaCarro(carro)) {
            if(carrosEstacionados.size() < 10) {
                if(carro.getMotorista().getIdade()>55) {
                    carrosPrioritarios.add(carro);
                } else {
                    carrosNaoPrioritarios.add(carro);
                }
                carrosEstacionados.add(carro);
                //qntEstacionados++;
            } else {
                if(carrosPrioritarios.size()<10) {
                    carrosEstacionados.remove(carrosNaoPrioritarios.get(0));
                    carrosNaoPrioritarios.remove(0);

                    if(carro.getMotorista().getIdade()>55) {
                        carrosPrioritarios.add(carro);
                    } else {
                        carrosNaoPrioritarios.add(carro);
                    }
                    carrosEstacionados.add(carro);
                } else {
                    throw new EstacionamentoException("Nao e possivel estacionar no momento!");
                }

            }
        }

    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        if(carrosEstacionados.contains(carro)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validaCarro(Carro c) {
        if((c.getMotorista()!=null)&&(c.getCor()!=null)&&(c.getPlaca()!=null)) {
            return true;
        } else if(c.getMotorista()==null) {
            throw new EstacionamentoException("Precisa ter motorista!");
        } else {
            return false;
        }
    }
}
