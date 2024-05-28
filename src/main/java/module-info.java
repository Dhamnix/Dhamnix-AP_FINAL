module org.example.ap_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ap_final to javafx.fxml;
    exports org.example.ap_final;
}