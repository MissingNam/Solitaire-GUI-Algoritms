module org.sunburn.solitairegui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens org.sunburn.solitairegui to javafx.fxml;
    exports org.sunburn.solitairegui;
}