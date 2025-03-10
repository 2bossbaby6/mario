module org.example.finalp_v {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.finalp_v to javafx.fxml;
    exports org.example.finalp_v;
    exports org.example.finalp_v.game;
    opens org.example.finalp_v.game to javafx.fxml;
}