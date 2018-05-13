package outro;
/**
 * Aplica��o principal.
 * 
 * @author Marcelo Cohen
 * @version 29/10/2008
 */
public class App
{
    /**
     * Programa principal: l� e exibe os clubes na tela,
     * depois l� e exibe as partidas na tela.
     */
    public void executa()
    {
    	
    	String path = ClassLoader.getSystemResource("").getPath();
		System.out.println("usando ClassLoader.getSystemResource(\"\"): " + path);
		path = System.getProperty("user.dir");
		System.out.println("Usando propriedade user.dir: " + path);
		
        Console cons = new Console();
        // Cria um LeitorClubes e l� todos os clubes do
        // arquivo, exibindo cada um na tela
        LeitorClubes leitor = new LeitorClubes(ClassLoader.getSystemResource("").getPath()+"clubes.txt");
        Clube c;
        do
        {
            c = leitor.proximoClube();
            if(c != null) cons.println(c);
        } while (c != null);

        // Cria um LeitorPartidas e l� todas as partidas do
        // arquivo, exibindo cada uma na tela
        LeitorPartidas leitor2 = new LeitorPartidas(ClassLoader.getSystemResource("").getPath()+"partidas.txt");
        Partida p;
        do
        {
            p = leitor2.proximaPartida();
            if(p != null) cons.println(p);
        } while (p != null);
    }

    /**
     * Executa o programa principal.
     * 
     * @param args argumentos via linha de comando (opcional).
     */
    public static void main(String args[])
    {
        new App().executa();
    }
}
