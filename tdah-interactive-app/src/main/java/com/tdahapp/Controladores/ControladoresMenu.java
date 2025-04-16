package com.tdahapp.Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ControladoresMenu {
    
    @FXML private TextField nombrePadreTutor;
    @FXML private TextField numeroTelefono;
    
    
    @FXML private PasswordField contraseñaOculta;
    @FXML private TextField contraseñaVisible;
    @FXML private Button btnToggleContraseña;
    @FXML private ImageView iconoContraseña;
    
    
    @FXML private PasswordField confirmarContraseñaOculta;
    @FXML private TextField confirmarContraseñaVisible;
    @FXML private Button btnToggleConfirmar;
    @FXML private ImageView iconoConfirmarContraseña;
    
    @FXML private Button btnRegistro;
   

    
    private static final String EYE_OPEN_PATH = "/imagenes/Ojoabierto.png";
    private static final String EYE_CLOSED_PATH = "/imagenes/Ojocerrado.png";
    private final Image eye = loadImage(EYE_OPEN_PATH);
    private final Image eyeSlash = loadImage(EYE_CLOSED_PATH);
    

    /**
     * Inicializa el controlador y configura los elementos de la UI
     */
    @FXML
    public void initialize() {
        setupPasswordFields();
        setupButtons();
    }

    
    private void setupPasswordFields() {
        // Configurar íconos iniciales
        iconoContraseña.setImage(eye);
        iconoConfirmarContraseña.setImage(eye);

        // Sincronizar campos de contraseña
        contraseñaVisible.textProperty().bindBidirectional(contraseñaOculta.textProperty());
        confirmarContraseñaVisible.textProperty().bindBidirectional(confirmarContraseñaOculta.textProperty());
    }

    private void setupButtons() {
        btnToggleContraseña.setOnAction(e -> togglePasswordVisibility(true));
        btnToggleConfirmar.setOnAction(e -> togglePasswordVisibility(false));
    }
    
     // Carga una imagen desde los recursos
     
    private Image loadImage(String path) {
        try {
            return new Image(getClass().getResourceAsStream(path));
        } catch (Exception e) {
            System.err.println("No se pudo cargar la imagen: " + path);
            e.printStackTrace();
            return null;
        }
    }

    // Alterna la visibilidad de los campos de contraseña
     
    private void togglePasswordVisibility(boolean isMainPassword) {
        if (isMainPassword) {
            boolean mostrar = !contraseñaVisible.isVisible();
            toggleVisibility(contraseñaOculta, contraseñaVisible, mostrar);
            iconoContraseña.setImage(mostrar ? eyeSlash : eye);
        } else {
            boolean mostrar = !confirmarContraseñaVisible.isVisible();
            toggleVisibility(confirmarContraseñaOculta, confirmarContraseñaVisible, mostrar);
            iconoConfirmarContraseña.setImage(mostrar ? eyeSlash : eye);
        }
    }

    //Alterna la visibilidad entre campos de contraseña oculta y visible
    
    private void toggleVisibility(PasswordField hidden, TextField visible, boolean mostrar) {
        visible.setVisible(mostrar);
        visible.setManaged(mostrar);
        hidden.setVisible(!mostrar);
        hidden.setManaged(!mostrar);
    }
    // endregion

    

    


}
