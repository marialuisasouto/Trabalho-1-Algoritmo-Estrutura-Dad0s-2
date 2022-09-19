import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Aplicativo {

    int contadorProblemas = 1;

    public void leArquivo(String nomeArquivo) throws IOException {
        Path path = Paths.get(nomeArquivo + ".txt");
        BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
        String linha = "";
        String separadorDeCampo = " ";

        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(separadorDeCampo);
            String capacidade1Str = dados[0];
            String capacidade2Str = dados[1];
            String capacidade3Str = dados[2];
            int capacidade1 = 0;
            int capacidade2 = 0;
            int capacidade3 = 0;
            try {
                capacidade1 = Integer.parseInt(capacidade1Str);
                capacidade2 = Integer.parseInt(capacidade2Str);
                capacidade3 = Integer.parseInt(capacidade3Str);
            } catch (NumberFormatException e) {
                System.err.println("Dados inválidos no arquivo.");
            } catch (Exception e) {
                System.err.println("Erro inesperado.");
            }

            linha = br.readLine();
            dados = linha.split(separadorDeCampo);
            String quantidadeContida1Str = dados[0];
            String quantidadeContida2Str = dados[1];
            String quantidadeContida3Str = dados[2];
            int quantidadeContida1 = 0;
            int quantidadeContida2 = 0;
            int quantidadeContida3 = 0;
            try {
                quantidadeContida1 = Integer.parseInt(quantidadeContida1Str);
                quantidadeContida2 = Integer.parseInt(quantidadeContida2Str);
                quantidadeContida3 = Integer.parseInt(quantidadeContida3Str);
            } catch (NumberFormatException e) {
                System.err.println("Dados inválidos no arquivo.");
            } catch (Exception e) {
                System.err.println("Erro inesperado.");
            }

            linha = br.readLine();
            dados = linha.split(separadorDeCampo);
            String quantidadeDesejada1Str = dados[0];
            String quantidadeDesejada2Str = dados[1];
            String quantidadeDesejada3Str = dados[2];
            int quantidadeDesejada1 = 0;
            int quantidadeDesejada2 = 0;
            int quantidadeDesejada3 = 0;
            try {
                quantidadeDesejada1 = Integer.parseInt(quantidadeDesejada1Str);
                quantidadeDesejada2 = Integer.parseInt(quantidadeDesejada2Str);
                quantidadeDesejada3 = Integer.parseInt(quantidadeDesejada3Str);
            } catch (NumberFormatException e) {
                System.err.println("Dados inválidos no arquivo.");
            } catch (Exception e) {
                System.err.println("Erro inesperado.");
            }

            Jarro jarro1 = new Jarro(capacidade1, quantidadeContida1, quantidadeDesejada1);
            Jarro jarro2 = new Jarro(capacidade2, quantidadeContida2, quantidadeDesejada2);
            Jarro jarro3 = new Jarro(capacidade3, quantidadeContida3, quantidadeDesejada3);

            balanceiaJarros(jarro1, jarro2, jarro3);

            br.readLine();
            br.readLine();
        }
    }

    public void balanceiaJarros(Jarro jarro1, Jarro jarro2, Jarro jarro3){
        int movimentos = 0;

        if(jarro1.getQuantidadeContida() > jarro1.getQuantidadeDesejada()){
            if(jarro2.precisaReceber() != 0){
                int value = jarro2.precisaReceber();
                if(jarro1.getQuantidadeContida() - jarro1.getQuantidadeDesejada() < value){
                    jarro1.enviaAgua(jarro2, jarro1.getQuantidadeContida() - jarro1.getQuantidadeDesejada());
                    movimentos++;
                } else {
                    jarro1.enviaAgua(jarro2, value);
                    movimentos++;
                }

            }
            if(jarro1.getQuantidadeContida() > jarro1.getQuantidadeDesejada()){
                int value = jarro3.precisaReceber();
                if(jarro1.getQuantidadeContida() - jarro1.getQuantidadeDesejada() < value){
                    jarro1.enviaAgua(jarro3, jarro1.getQuantidadeContida() - jarro1.getQuantidadeDesejada());
                    movimentos++;
                } else {
                    jarro1.enviaAgua(jarro3, value);
                    movimentos++;
                }
            }
        }

        System.out.println("Problema " + contadorProblemas + ":");
        System.out.println("Resultado: " + jarro1.getQuantidadeContida() + " " + jarro2.getQuantidadeContida() + " "
                + jarro3.getQuantidadeContida());
        System.out.println("Movimentos: " + movimentos);
        System.out.println("--------------------");
        contadorProblemas++;
    }
}
