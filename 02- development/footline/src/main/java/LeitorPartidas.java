import java.io.*;
/**
 * A classe <code>LeitorPartidas</code> implementa um leitor de arquivos de dados
 * contendo a descrição de partidas do campeonato.
 * 
 * @author Marcelo Cohen
 * @version 29/10/2008
 */
public class LeitorPartidas
{
	// Objeto que separa os elementos da entrada
    private StreamTokenizer st;
    
    // Objeto que provê acesso à leitura de um arquivo
    private BufferedReader in;

	/**
     * Construtor: inicia o processo de leitura do arquivo informado
     * 
     * @param  fileName   <code>String</code> contendo nome do arquivo de partidas a ser lido
     */
	public LeitorPartidas(String fileName)
	{
		in = null;

		try {
			in = new BufferedReader(new FileReader(fileName));
		}
		catch (FileNotFoundException e) {
			 System.out.println("LeitorPartidas: arquivo não encontrado!");
			 return;
		}

		st = new StreamTokenizer(in);

	}

	/**
     * Lê o próximo registro do arquivo de partidas.
     * 
     * @return objeto <code>Partida</code> ou <code>null</code> quando chegar ao
     *         fim do arquivo.
     */
	public Partida proximaPartida()
	{
		int token;
		try 
		{
			token = st.nextToken(); // nome do clube mandante

			if(token == StreamTokenizer.TT_EOF)
			{
				in.close();
				return null;
			}

			if(token != StreamTokenizer.TT_WORD) {
				System.out.println("LeitorPartidas.proximaPartida: definição incorreta do mandante");
				throw new IOException();
			}
			String mandante = st.sval;

			token = st.nextToken(); // gols do mandante
			if(token != StreamTokenizer.TT_NUMBER) {
				System.out.println("LeitorPartidas.proximaPartida: definição incorreta dos gols (mandante)");
				throw new IOException();
			}
			int golsM = (int) st.nval;

			token = st.nextToken(); // "X"

			token = st.nextToken(); // gols do visitante
			if(token != StreamTokenizer.TT_NUMBER) {
				System.out.println("LeitorPartidas.proximaPartida: definição incorreta dos gols (visit.)");
				throw new IOException();
			}
			int golsV = (int) st.nval;

			token = st.nextToken(); // nome do clube visitante
			if(token != StreamTokenizer.TT_WORD) {
				System.out.println("LeitorPartidas.proximaPartida: definição incorreta do visitante");
				throw new IOException();
			}
			String visitante = st.sval;

			return new Partida(mandante, visitante, golsM, golsV);
		}
		catch (IOException e) {
			System.out.println("LeitorPartidas.proximaPartida: Erro de leitura");
			return null;
		}
	}
}
