package pl.lublin.wsei.java.cwiczenia.lab5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    public ListView lvNoblisci;
    public TextField tfRok;
    public TextField tfDziedzina;
    public TextField tfKraj;
    public TextField tfMotywacja;
    private Noblista aNoblista;

    ObservableList<String> tytuly = FXCollections.observableArrayList();
    NoblisciList noblisciList;

    @FXML
    public void initialize() throws IOException {
        noblisciList = new NoblisciList();

        for(Noblista nb: noblisciList.noblisci) {
            tytuly.add(nb.imie + " " + nb.nazwisko);
        }
        lvNoblisci.setItems(tytuly);

        lvNoblisci.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number old_val, Number new_val) {
                int index = new_val.intValue();
                if(index != -1) {
                    tfRok.setText("");
                    tfDziedzina.setText("");
                    tfKraj.setText("");
                    tfMotywacja.setText("");
                    aNoblista = noblisciList.noblisci.get(index);
                    tfRok.setText(aNoblista.rok);
                    tfDziedzina.setText(aNoblista.kategoria);
                    tfKraj.setText(aNoblista.kraj);
                    tfMotywacja.setText(aNoblista.uzasadnienie);
                } else {
                    tfRok.setText("");
                    tfDziedzina.setText("");
                    tfKraj.setText("");
                    tfMotywacja.setText("");
                }
            }
        });
    }

    public void btnExport(ActionEvent actionEvent) {

    }
}