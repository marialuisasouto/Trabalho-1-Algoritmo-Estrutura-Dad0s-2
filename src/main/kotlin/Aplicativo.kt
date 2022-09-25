import java.io.File

class Aplicativo {

    val setDeJarroAlreadySeen = mutableListOf<SetDeJarro>()
    var caso = 1

    fun executa(nomeArquivo: String) {
        val inputStream = File(nomeArquivo + ".txt").inputStream()
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
        var linhaAtual = 0
        val jar1 = Jarro(0)
        val jar2 = Jarro(1)
        val jar3 = Jarro(2)
        lineList.forEach {
            if (it.isEmpty()) {
                linhaAtual = 0
                return@forEach
            }
            when (linhaAtual) {
                0 -> {
                    val capacidades = it.split(" ")
                    jar1.capacidade = capacidades[0].toInt()
                    jar2.capacidade = capacidades[1].toInt()
                    jar3.capacidade = capacidades[2].toInt()
                }
                1 -> {
                    val quantidadeContida = it.split(" ")
                    jar1.quantidadeContida = quantidadeContida[0].toInt()
                    jar2.quantidadeContida = quantidadeContida[1].toInt()
                    jar3.quantidadeContida = quantidadeContida[2].toInt()
                }
                2 -> {
                    val quantidadeDesejada = it.split(" ")
                    jar1.quantidadeDesejada = quantidadeDesejada[0].toInt()
                    jar2.quantidadeDesejada = quantidadeDesejada[1].toInt()
                    jar3.quantidadeDesejada = quantidadeDesejada[2].toInt()
                }
                else -> {
                    val jarrosIniciais = listOf(jar1, jar2, jar3)

                    println("Caso: ${caso}")
                    val currentTime = System.currentTimeMillis()
                    val maxLevel = 1000
                    val answer = getModificacoes(SetDeJarro(0, jarrosIniciais), maxNumOfLevels = maxLevel)

                    println("TEMPO DECORRIDO ${(System.currentTimeMillis() - currentTime).toFloat() / 1000f}s")
                    println()
                    if (answer > maxLevel) {
                        println("É impossível resolver este problema com o número de níveis fornecidos.")
                    } else {
                        println("Número mínimo de movimentos até o resultado: ${answer}")
                    }
                    println("===============================================")

                    setDeJarroAlreadySeen.clear()
                    caso++
                }
            }
            linhaAtual++
        }
    }

    /**
     * Método recursivo de criação de filhos com as opções de jarros e respectivos níveis
     */
    private fun getModificacoes(setDeJarro: SetDeJarro, maxNumOfLevels: Int = 15): Int {
        val novosSets = mutableListOf<SetDeJarro>()
        val currentLevel = setDeJarro.level + 1

        setDeJarro.jarros.forEachIndexed { i, _ ->
            setDeJarro.jarros.forEachIndexed { j, _ ->
                if (i != j) {
                    val candidate = criaNovoSetDeJarros(setDeJarro, i, j)

                    if (setDeJarroAlreadySeen.none { it.isTheSame(candidate) }) {
                        novosSets.add(candidate)
                        setDeJarroAlreadySeen.add(candidate)
                    }

                }
            }
        }

        if (novosSets.isQuantidadeDeAguaCerta()) {
            return currentLevel
        } else if (currentLevel == maxNumOfLevels) {
            return -1
        } else {
            val leveisCompletos = mutableListOf(Int.MAX_VALUE)

            novosSets.forEach {

                val currentLevel = getModificacoes(it.copy(level = currentLevel), maxNumOfLevels = maxNumOfLevels)

                if (currentLevel != -1) {
                    leveisCompletos.add(currentLevel)
                }
            }
            return leveisCompletos.min()
        }
    }

    /**
     * Testa se algum dos SetDeJarro tem os jarros com a quantidade correta de agua
     */
    fun List<SetDeJarro>.isQuantidadeDeAguaCerta(): Boolean {
        return this.any { it.isQuantidadeDeAguaCerta() }
    }

    /**
     * Cria um novo SetDeJarro depois de enviar a agua de um jarro para outro
     */
    fun criaNovoSetDeJarros(setDeJarro: SetDeJarro, indexFrom: Int, indexTo: Int): SetDeJarro {
        val origem = setDeJarro.jarros[indexFrom].copy()
        val destino = setDeJarro.jarros[indexTo].copy()

        origem.enviaAgua(destino);

        val mutableList = setDeJarro.jarros.toMutableList()

        mutableList.set(indexFrom, origem)

        mutableList.set(indexTo, destino)

        return SetDeJarro(setDeJarro.level + 1, mutableList)
    }
}