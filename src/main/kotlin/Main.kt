import java.util.*

fun main() {
    val app = Aplicativo()
    println ("Digite o nome do arquivo sem a extensão:")
    val teclado = Scanner(System.`in`)
    val nomeArquivo = teclado.nextLine()
    app.executa(nomeArquivo)
}