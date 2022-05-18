module pl.lublin.wsei.java.cwiczenia.lab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.lublin.wsei.java.cwiczenia.lab5 to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia.lab5;
}