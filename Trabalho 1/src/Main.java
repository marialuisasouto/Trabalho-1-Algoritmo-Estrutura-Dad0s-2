import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Aplicativo app = new Aplicativo();
        try{
            System.out.println("Por favor, digite o nome do arquivo sem a extensão.");
            String nomeArquivo = in.nextLine();
            app.leArquivo(nomeArquivo);
        } catch (Exception e){
            System.err.println("Arquivo não encontrado.");
        }

    }
}
