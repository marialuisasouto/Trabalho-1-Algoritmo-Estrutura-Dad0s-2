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

}
