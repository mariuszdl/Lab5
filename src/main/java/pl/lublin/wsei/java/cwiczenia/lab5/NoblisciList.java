package pl.lublin.wsei.java.cwiczenia.lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class NoblisciList {
    public ArrayList<Noblista> noblisci;

    public NoblisciList() throws IOException {
        noblisci = new ArrayList<>();
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("nobel_prize_by_winner.csv", StandardCharsets.US_ASCII));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.charAt(0) != 'i') {
                    noblisci.add(new Noblista(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd wczytywania pliku nobel_prize_by_winner.csv => " + e.getLocalizedMessage());
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }

    }
}
