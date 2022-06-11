package pl.lublin.wsei.java.cwiczenia.lab5;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.*;

public class Export {
    public TextField tfRokE;
    public TextField tfDziedzinaE;
    public TextField tfKrajE;

    public void exportToFile(ActionEvent actionEvent) throws IOException {
        NoblisciList noblisciList = new NoblisciList();
        String line;

        try {
            PrintStream out = new PrintStream(new FileOutputStream("nobel_filtered.csv"));
            out.println(NoblisciList.header);

            for(Noblista nb: noblisciList.noblisci) {
                line = "";
                if (tfRokE.getText().length() > 0) {
                    if (nb.rok != null && nb.rok.equals(tfRokE.getText())) {
                        line = nb.dataRow;
                    } else {
                        continue;
                    }
                }
                if (tfDziedzinaE.getText().length() > 0) {
                    if (nb.kategoria != null && nb.kategoria.equals(tfDziedzinaE.getText())) {
                        line = nb.dataRow;
                    } else {
                        continue;
                    }
                }
                if (tfKrajE.getText().length() > 0) {
                    if (nb.kraj != null && nb.kraj.equals(tfKrajE.getText())) {
                        line = nb.dataRow;
                    } else {
                        continue;
                    }
                }
                if (tfRokE.getText().length() == 0 && tfDziedzinaE.getText().length() == 0 && tfKrajE.getText().length() == 0) {
                    line = nb.dataRow;
                }
                if (line.length() > 0) {
                    out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        } finally {
            Runtime.getRuntime().exec("explorer.exe /select," + "nobel_filtered.csv");
        }
    }
}
