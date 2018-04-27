import java.io.*;
/**
 * A classe <code>LeitorClubes</code> implementa um leitor de arquivos de dados
 * contendo a descriao de clubes.
 * 
 * @author Marcelo Cohen
 * @version 29/10/2008
 */
public class LeitorClubes
{
    // Objeto que separa os elementos da entrada
    private StreamTokenizer st;
    
    // Objeto que prov acesso� leitura de um arquivo
    private BufferedReader in;

    /**
     * Construtor: inicia o processo de leitura do arquivo informado.
     * 
     * @param  fileName   String contendo nome do arquivo a ser lido.
     */
    public LeitorClubes(String fileName)
    {
        in = null;

        try {
            in = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e) {
             System.out.println("LeitorClubes: arquivo no encontrado!");
             return;
        }

        st = new StreamTokenizer(in);

    }

    /**
     * L o pximo registro do arquivo de clubes.
     * 
     * @return objeto <code>Clube</code> ou <code>null</code> quando
     *         chegar ao fim do arquivo.
     */
    public Clube proximoClube()
    {
        int token;
        try 
        {
            token = st.nextToken();

            if(token == StreamTokenizer.TT_EOF)
            {
                in.close();
                return null;
            }

            if(token != StreamTokenizer.TT_WORD) {
                System.out.println("LeitorClubes.proximoClube: definio incorreta do nome");
                throw new IOException();
            }
            String nomeClube = st.sval;

            token = st.nextToken(); // estado do clube
            if(token != StreamTokenizer.TT_WORD) {
                System.out.println("LeitorClubes.proximoClube: definio incorreta do estado");
                throw new IOException();
            }
            String estado = st.sval;

            return new Clube(nomeClube, estado);
        }
        catch (IOException e) {
            System.out.println("LeitorClubes.proximoClube: Erro de leitura");
            return null;
        }
    }
}
