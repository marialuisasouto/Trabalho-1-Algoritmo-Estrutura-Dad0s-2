public class Main {
    public static void main(String[] args) {
        Aplicativo app = new Aplicativo();
        try{
            app.leArquivo("Testes");
        } catch (Exception e){
            System.err.println("Arquivo não encontrado.");
        }

    }
}
