data class SetDeJarro(val level: Int, val jarros: List<Jarro>) {

    /**
     * Testa se todos os jarros do SetDeJarros contém a quantidade correta de agua
     */
    fun isQuantidadeDeAguaCerta(): Boolean {
        return jarros.all { it.isQuantidadeDeAguaCerta() }
    }

    /**
     * Testa se o SetDeJarro que chamou a função é igual ao que foi passado por parâmetro
     */
    fun isTheSame(other: SetDeJarro?): Boolean {
        return this.jarros == other?.jarros
    }

    /**
     * Testa se o SetDeJarro que chamou a função é diferente ao que foi passado por parâmetro
     */
    fun isDifferent(other: SetDeJarro?): Boolean {
        return !isTheSame(other)
    }
}