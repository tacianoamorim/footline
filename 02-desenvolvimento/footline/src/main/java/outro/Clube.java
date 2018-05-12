package outro;
/**
 * A classe <code>Clube</code> representa um clube de futebol.
 * 
 * @author Marcelo Cohen
 * @version 29/10/2008
 */
public class Clube
{
    private String nomeClube;
    private String estadoClube;

    /**
     * Construtor: inicializa um objeto <code>Clube</code> com nome e estado.
     * 
     * @param nome nome do clube.
     * @param estado estado do clube.
     */
    public Clube(String nome, String estado)
    {
        nomeClube = nome;
        estadoClube = estado;
    }

    /**
     * Retorna o nome do clube.
     * 
     * @return nome do clube.
     */
    public String getNome() { return nomeClube; }
    
    /**
     * Retorna o estado do clube.
     * 
     * @return estado do clube.
     */
    public String getEstado() { return estadoClube; }

    /**
     * Retorna uma representa��o do clube em forma textual.
     * 
     * @return a representa��o do clube como <code>String</code>.
     */
    public String toString() {
        return nomeClube+"-"+estadoClube;
    }
}
