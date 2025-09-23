package es.wara;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controlador de la paleta de colores.
 * <p>
 * Permite ajustar los valores de Rojo, Verde y Azul mediante sliders y actualiza el color
 * de un rectángulo en la interfaz. Además, muestra el código RGB resultante en un Label
 * que puede copiarse al portapapeles y registra los cambios mediante SLF4J.
 * </p>
 *
 * Funcionalidades principales:
 * <ul>
 *     <li>Actualizar el color del rectángulo según los sliders.</li>
 *     <li>Mostrar el código RGB en un Label.</li>
 *     <li>Copiar el valor RGB al portapapeles al hacer clic en el Label.</li>
 *     <li>Registrar los cambios de color y copias en el log.</li>
 * </ul>
 *
 * @author Wara Pacheco
 * @version 1.0
 */

public class PaletaController {

    /** Rectángulo que mostrará el color seleccionado */
    @FXML
    private Rectangle rectangulo;

    /** Slider para ajustar el valor del color azul (0-255) */
    @FXML
    private Slider sldAzul;

    /** Slider para ajustar el valor del color rojo (0-255) */
    @FXML
    private Slider sldRojo;

    /** Slider para ajustar el valor del color verde (0-255) */
    @FXML
    private Slider sldVerde;

    /** Label que muestra el código RGB resultante y permite copiarlo al portapapeles */
    @FXML
    private Label lblColor;

    /**
     * Logger para registrar eventos y depuración de la aplicación.
     * Utiliza SLF4J para proporcionar logging flexible durante la ejecución.
     */
    private static final Logger loger = LoggerFactory.getLogger(PaletaController.class);

    /**
     * Método de inicialización llamado automáticamente por JavaFX después de cargar el FXML.
     * <p>
     * Configura los sliders para actualizar el color del rectángulo al soltar el mouse
     * o al usar el teclado, establece el texto inicial del Label y el cursor para indicar
     * que es clickeable, y aplica el color inicial al rectángulo.
     * </p>
     */
    @FXML
    public void initialize() {
        // Configuración de los sliders para detectar cambios al soltar el mouse ("onchange")
        sldRojo.setOnMouseReleased(e -> actualizarColor());
        sldVerde.setOnMouseReleased(e -> actualizarColor());
        sldAzul.setOnMouseReleased(e -> actualizarColor());

        // Configuración de los sliders para detectar cambios al usar el teclado (flechas)
        sldRojo.setOnKeyReleased(e -> actualizarColor());
        sldVerde.setOnKeyReleased(e -> actualizarColor());
        sldAzul.setOnKeyReleased(e -> actualizarColor());

        // Texto inicial del Label y cursor de mano para indicar clickeable
        lblColor.setText("RGB:(0,0,0)");
        lblColor.setCursor(Cursor.HAND);

        // Color inicial del rectángulo
        actualizarColor();
    }

    /**
     * Actualiza el color del rectángulo según los valores actuales de los sliders.
     * <p>
     * También actualiza el Label con el valor RGB y registra la actualización mediante el logger.
     * </p>
     */
    private void actualizarColor() {
        int r = (int) sldRojo.getValue();
        int g = (int) sldVerde.getValue();
        int b = (int) sldAzul.getValue();

        // Actualiza el color del rectángulo
        rectangulo.setFill(Color.rgb(r, g, b));

        // Actualiza el Label con la información del color
        lblColor.setText("RGB("+r+", "+g+", "+b+")");

        // Log del color actual
        loger.info("Color actualizado a RGB({}, {}, {})", r, g, b);
    }

    /**
     * Copia el valor RGB mostrado en el Label al portapapeles.
     * <p>
     * Extrae únicamente los números, sin "RGB(" ni paréntesis, y registra la acción en el logger.
     * </p>
     *
     * @param event Evento de clic del mouse sobre el Label
     */
    @FXML
    void copiaPortapapeles(MouseEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        // Extrae solo los números del texto del Label
        String texto = lblColor.getText();
        String soloColor = texto.replaceAll("[^0-9,]", "");

        // Copia al portapapeles
        content.putString(soloColor);
        clipboard.setContent(content);

        // Log de la acción
        loger.info("Texto copiado al portapapeles: " + lblColor.getText());

        // Feedback visual: cambia el texto temporalmente
        String textoOriginal = lblColor.getText();
        lblColor.setText("¡Copiado!");

        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> lblColor.setText(textoOriginal));
        pause.play();
    }
}
