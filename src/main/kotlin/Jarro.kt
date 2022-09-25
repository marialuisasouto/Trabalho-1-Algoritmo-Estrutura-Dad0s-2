data class Jarro(
    var id: Int = 0,
    var capacidade: Int = 0,
    var quantidadeContida: Int = 0,
    var quantidadeDesejada: Int = 0
) {

    /**
     * Testa se a quantidade de agua do jarro é a desejada
     */
    fun isQuantidadeDeAguaCerta(): Boolean {
        return quantidadeDesejada == quantidadeContida
    }

    /**
     * Envia agua do jarro que chamou a função para o jarro passado por parâmetro
     */
    fun enviaAgua(jarro: Jarro) {
        var quantidadeSoma = this.quantidadeContida + jarro.quantidadeContida
        val sobra = quantidadeSoma - jarro.capacidade

        if (sobra > 0) {
            this.quantidadeContida = sobra
            quantidadeSoma -= sobra
        } else {
            this.quantidadeContida = 0
        }
        jarro.quantidadeContida = quantidadeSoma
    }
}