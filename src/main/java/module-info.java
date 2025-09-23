/**
 * Módulo principal de la aplicación sliderApp.
 * Define los paquetes exportados y los módulos requeridos para el funcionamiento de la app JavaFX.
 */
module es.wara {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires org.slf4j;

    opens es.wara to javafx.fxml;
    exports es.wara;
}
