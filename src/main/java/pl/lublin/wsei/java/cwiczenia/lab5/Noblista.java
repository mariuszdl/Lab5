package pl.lublin.wsei.java.cwiczenia.lab5;

public class Noblista {
    public String imie;
    public String nazwisko;
    public String rok;
    public String kategoria;
    public String uzasadnienie;
    public String kraj;
    public String dataRow;

    public Noblista(String tekst) {
        String[] items = tekst.split(",(?=\\S)");
        dataRow = tekst;
        imie = items[1];
        nazwisko = items[2];
        rok = items[12];
        kategoria = items[13];
        uzasadnienie = items[16];
        uzasadnienie = uzasadnienie.replace("\"", "");
        if(items.length > 19) {
            kraj = items[19];
        }
    }
}
