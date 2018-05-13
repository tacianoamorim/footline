package outro;
/**
 * Uma interface simples para ler n�meros e textos a partir do teclado e
 * apresentar n�meros e texto no v�deo.
 * 
 * Traduzida e baseada na classe Console de Cay Horstmann (1997)
 * - na leitura e escrita, a classe considera apenas duas casas decimais
 * - alterada a sobrecarga de print para formatar a sa�da.
 * - readChar verificam se o caractere foi obtido corretamente.
 * - removida a sobrecarga de print e println para int por causa do autoboxing para tipos primitivos
 * - leitura de reais: o separador de decimais � igual na entrada e na sa�da.
 * - revis�o e remo��o do modificador static
 * - inclu�do m�todo readFloat
 * - inclu�das vers�es sobrecarregadas dos m�todos sem prompt
 * - inclu�do wrappers para print, println e printf com tipos primitivos
 * - inclu�do wrapper  para println vazio
 * - inclu�do wrapper  para print e println com Object (para toString funcionar)
 * - inclu�do readChar para ler um �nico caractere
 * 
 * Utiliza��o:
 * Console cons = new Console();
 * 
 * int i = cons.readInt();
 * double d = cons.readDouble();
 * cons.print("Oi!");
 * cons.printf("Nota: %.2f\n", 9.8);
 * 
 * @version 2.09 23 Abr 2008
 * @author Marcelo Cohen, Marco Mangan
 */

import java.text.*;

public class Console
{
  /**
   * Exibe uma mensagem no terminal sem nova linha no final
   * 
   * @param prompt a mensagem a exibir
   */
  public void printPrompt(String prompt)
  {
     System.out.print(prompt + " ");
     System.out.flush();
  }
   
  /**
   * L� uma string do teclado, finalizada com ENTER
   * 
   * @return a string de entrada (sem o caractere de nova linha)
   */
  public String readLine()
  {
     int ch;
     String r = "";
     boolean done = false;
     while (!done)
     {
        try
        {
           ch = System.in.read();
           if (ch < 0 || (char)ch == '\n')
              done = true;
           else if ((char)ch != '\r') // weird--it used to do \r\n translation
              r = r + (char) ch;
        }
        catch(java.io.IOException e) {  done = true; }
     }
     return r;
  }

  /**
   * L� uma string do teclado, finalizada com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return a string de entrada (sem o caractere de nova linha)
   */
  public String readLine(String prompt)
  {
     printPrompt(prompt);
     return readLine();
  }

  /**
   * L� um caractere do teclado, finalizado com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return o caractere digitado
   */
  public char readChar(String prompt)
  {  
    while(true)
    {
        printPrompt(prompt);
        try
        {
            return readLine().trim().charAt(0);
        } catch(Exception e)
        {
            System.out.println("N�o � um caractere v�lido - digite novamente!");
        }
    }
  }

  /**
   * L� um caractere do teclado, finalizado com ENTER
   * 
   * @return o caractere digitado
   */
  public char readChar()
  {  
     while(true)
     {
        try
        {
            return readLine().trim().charAt(0);
        } catch(Exception e)
        {
            System.out.println("N�o � um caractere v�lido - digite novamente!");
        } 
     }
  }

  /**
   * L� um inteiro do teclado, finalizado com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return o valor de entrada como um int
   * @exception NumberFormatException se ocorrer entrada inv�lida
   */
  public int readInt(String prompt)
  {  
     while(true)
     {
        printPrompt(prompt);
        try
        {
            return Integer.valueOf(readLine().trim()).intValue();
        } catch(NumberFormatException e)
        {
            System.out.println("N�o � um inteiro - digite novamente!");
        }
     }
  }

  /**
   * L� um inteiro do teclado, finalizado com ENTER
   * 
   * @return o valor de entrada como um int
   * @exception NumberFormatException se ocorrer entrada inv�lida
   */
  public int readInt()
  {
     while(true)
     {  
        try
        {
            return Integer.valueOf(readLine().trim()).intValue();
        } catch(NumberFormatException e)
        {
            System.out.println("N�o � um inteiro - digite novamente!");
        }
     }
  }
  
  /**
   * L� um n�mero real (float) do teclado, finalizado com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return o valor de entrada como float
   * @exception NumberFormatException se ocorrer entrada inv�lida
   */
  public float readFloat(String prompt)
  {  
     while(true)
     {
        printPrompt(prompt);
        try
        {
//          return Float.parseFloat(readLine().trim());
            return convertFloatNumber(readLine().trim());
        } catch(Exception e)
        {
          System.out.println("N�o � um n�mero real - digite novamente!");
        }
     }
  }

  /**
   * L� um n�mero real (float) do teclado, finalizado com ENTER
   * 
   * @return o valor de entrada como float
   * @exception NumberFormatException se ocorrer entrada inv�lida
   */
  public float readFloat()
  {  
     while(true)
     {
        try
        {
//          return Float.parseFloat(readLine().trim());
            return convertFloatNumber(readLine().trim());
        } catch(Exception e)
        {
          System.out.println("N�o � um n�mero real - digite novamente!");
        }
     }
  }

  //http://www.javafree.org/javabb/viewtopic.jbb?t=850669
  private double convertDoubleNumber( String number) throws Exception {  
    DecimalFormat df = new DecimalFormat("0.00");  
    df.setDecimalFormatSymbols( new DecimalFormatSymbols() );  
    df.setGroupingSize( 3 );  
    df.setGroupingUsed( true );  
    return df.parse( number ).doubleValue();  
  } 

  private float convertFloatNumber( String number) throws Exception {  
    DecimalFormat df = new DecimalFormat("0.00");  
    df.setDecimalFormatSymbols( new DecimalFormatSymbols() );  
    df.setGroupingSize( 3 );  
    df.setGroupingUsed( true );  
    return df.parse( number ).floatValue();  
  } 

  /**
   * L� um n�mero real (double) do teclado, finalizado com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return o valor de entrada como float
   * @exception NumberFormatException se ocorrer entrada inv�lida
   */
  public double readDouble(String prompt)
  {
     while(true)
     {
        printPrompt(prompt);
        try
        {
//            return Double.parseDouble(readLine().trim());
            return convertDoubleNumber(readLine().trim());
        } catch(Exception e)
        {
            System.out.println("N�o � um n�mero real - digite novamente!");
        }
     }
  }
  
  /**
   * L� um n�mero real (double) do teclado, finalizado com ENTER
   * 
   * @return o valor de entrada como float
   * @exception NumberFormatException se ocorrer entrada inv�lida
   */
  public double readDouble()
  {
     while(true)
     {
        try
        {
//            return Double.parseDouble(readLine().trim());
            return convertDoubleNumber(readLine().trim());
        } catch(Exception e)
        {
            System.out.println("N�o � um n�mero real - digite novamente!");
        }
     }
  }

  /**
   * Escreve um objeto qualquer na tela (wrapper para System.out.print)
   * 
   * @param arg objeto a escrever (pode ser String ou qualquer outro)
   */
  public void print(Object arg)
  {
      System.out.print(arg);
  }
 
  /**
   * Escreve um objeto qualquer na tela (wrapper para System.out.print)
   * 
   * @param arg objeto a escrever (pode ser String ou qualquer outro)
   */
  public void print(float arg)
  {
      System.out.printf("%f", arg);
  }

  /**
   * Escreve um objeto qualquer na tela (wrapper para System.out.print)
   * 
   * @param arg objeto a escrever (pode ser String ou qualquer outro)
   */
  public void print(double arg)
  {
      System.out.printf("%f", arg);
  }
  
  
  /**
   * Escreve um objeto na tela (wrapper para System.out.println)
   * 
   * @param arg objeto a escrever (pode ser String ou qualquer outro)
   */
  public void println(Object arg)
  {
      print(arg);
      println();
  }

 
  /**
   * Pula uma linha (wrapper para System.out.println)
   * 
   */
  public void println()
  {
      System.out.println();
  }

  /**
   * Escreve com sa�da formatada (wrapper para System.out.printf)
   * 
   * @param format string que descreve o formato de sa�da e a ordem dos argumentos
   * @param args zero ou mais argumentos, na ordem especificada pela string de formato
   */
  public void printf(String format, Object ...args)
  {
      System.out.printf(format,args);
  }
}
