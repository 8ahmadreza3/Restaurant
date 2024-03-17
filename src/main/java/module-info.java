module org.example.restaurant {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.restaurant to javafx.fxml;
    exports org.example.restaurant;
}