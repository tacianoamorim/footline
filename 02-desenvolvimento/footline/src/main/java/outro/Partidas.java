package outro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Partidas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> clubes = new ArrayList<String>();
    System.out.println("Entre com o nome dos clubes. Deixe em branco para terminar.");
    String clube = "";
    do {
        clube = in.nextLine().trim();
        if (!clube.isEmpty()) {
            clubes.add(clube);
        }
    } while (!clube.isEmpty());

    if (clubes.size() % 2 == 1) {
        clubes.add(0, "");
    }

    int t = clubes.size();
    int m = clubes.size() / 2;
    for (int i = 0; i < t - 1; i++) {
        System.out.print((i + 1) + "a rodada: ");
        for (int j = 0; j < m; j++) {
            //Clube est� de fora nessa rodada?              
            if (clubes.get(j).isEmpty())
                continue;

            //Teste para ajustar o mando de campo
            if (j % 2 == 1 || i % 2 == 1 && j == 0)
                System.out.print(clubes.get(t - j - 1) + " x " + clubes.get(j) + "   ");
            else
                System.out.print(clubes.get(j) + " x " + clubes.get(t - j - 1) + "   ");
        }
        System.out.println();
        //Gira os clubes no sentido hor�rio, mantendo o primeiro no lugar
        clubes.add(1, clubes.remove(clubes.size()-1));
    }
}
}