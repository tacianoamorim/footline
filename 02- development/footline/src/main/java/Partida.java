/**
 * A classe <code>Partida</code> representa uma partida do campeonato.
 * 
 * @author Marcelo Cohen
 * @version 29/10/2008
 */
public class Partida
{
	private String clubeMandante;
	private String clubeVisitante;
	private int golsMandante;
	private int golsVisitante;
	
    /**
     * Construtor: inicializa um objeto <code>Partida</code> com nome do clube
     *             mandante, nome do visitante, gols do mandante e visitante.
     * 
     * @param mandante nome do clube mandante.
     * @param visitante nome do clube visitante.
     * @param golsM gols do mandante.
     * @param golsV gols do visitante.
     */
	public Partida(String mandante, String visitante, int golsM, int golsV)
	{
		clubeMandante = mandante;
		clubeVisitante = visitante;
		golsMandante = golsM;
		golsVisitante = golsV;
	}

    /**
     * Retorna o nome do clube mandante.
     * 
     * @return nome do clube mandante.
     */
	public String getMandante() { return clubeMandante; }

    /**
     * Retorna o nome do clube visitante.
     * 
     * @return nome do clube visitante.
     */	
	public String getVisitante() { return clubeVisitante; }

    /**
     * Retorna o total de gols do clube mandante.
     * 
     * @return total de gols do clube mandante.
     */	
	public int getGolsMandante() { return golsMandante; }
	
    /**
     * Retorna o total de gols do clube visitante.
     * 
     * @return total de gols do clube visitante.
     */		
	public int getGolsVisitante() { return golsVisitante; }

    /**
     * Retorna uma representação da partida em forma textual.
     * 
     * @return a representação da partida como <code>String</code>.
     */
	public String toString() {
		return clubeMandante+" "+golsMandante+" x "+golsVisitante+" "+clubeVisitante;
	}
}
