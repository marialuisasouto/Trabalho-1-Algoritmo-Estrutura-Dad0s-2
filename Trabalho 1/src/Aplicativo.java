import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Aplicativo {
    public void leArquivo(String nomeArquivo) throws IOException {
        Path path = Paths.get(nomeArquivo + ".txt");
        BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
        String linha = "";
        String separadorDeCampo = " ";

        while((linha = br.readLine()) != null){

        }
    }
}
