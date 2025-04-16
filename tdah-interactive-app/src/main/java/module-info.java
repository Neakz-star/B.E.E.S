module com.tdahapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    opens com.tdahapp to javafx.fxml;
    opens com.tdahapp.Controladores to javafx.fxml;
    
    exports com.tdahapp;
    exports com.tdahapp.Controladores;
}
