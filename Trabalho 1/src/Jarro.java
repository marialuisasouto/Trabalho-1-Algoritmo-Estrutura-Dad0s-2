import java.security.DrbgParameters.Capability;

public class Jarro {

    private int capacidade;
    private int quantidadeContida;
    private int quantidadeDesejada;

    public Jarro(int capacidade, int quantidadeContida, int quantidadeDesejada) {
        this.capacidade = capacidade;
        this.quantidadeContida = quantidadeContida;
        this.quantidadeDesejada = quantidadeDesejada;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getQuantidadeContida() {
        return quantidadeContida;
    }

    public void setQuantidadeContida(int quantidadeContida) {
        this.quantidadeContida = quantidadeContida;
    }

    public int getQuantidadeDesejada() {
        return quantidadeDesejada;
    }

    public void setQuantidadeDesejada(int quantidadeDesejada) {
        this.quantidadeDesejada = quantidadeDesejada;
    }

    public boolean testaResultado() {
        if (quantidadeDesejada == quantidadeContida) {
            return true;
        }
        return false;
    }

    public boolean testaCapacidadeDesejada() {
        if (quantidadeDesejada > capacidade) {
            return false;
        }
        return true;
    }

    public boolean testaCapacidadeContida() {

        if (quantidadeContida > capacidade) {
            return false;
        }
        return true;
    }

    public boolean testaPodeReceber(int valor) {

        if (capacidade >= quantidadeContida + valor) {
            return true;
        }
        return false;
    }

    public boolean enviaAgua(Jarro jarro, int valor) {

        if (jarro.testaPodeReceber(valor)) {
            jarro.setQuantidadeContida(jarro.getQuantidadeContida() + valor);
            this.setQuantidadeContida(this.getQuantidadeContida() - valor);
            return true;
        }
        return false;
    }

    public int precisaReceber() {

        if (quantidadeContida < quantidadeDesejada) {
            return quantidadeContida - quantidadeDesejada;
        }
        return 0;
    }
}