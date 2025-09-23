# Ejercicio: Práctica con JavaFX, FXML y Sliders - Paleta de Colores

Este proyecto es un ejercicio para explorar las funcionalidades de los **Sliders** para crear una paleta de colores interactiva, además de practicar habilidades aprendidas en JavaFX, el uso de Logger, la empaquetación de aplicaciones en archivos .jar ejecutables y el uso de FXML.

## Descripción

La aplicación implementa una paleta de colores interactiva con interfaz gráfica utilizando JavaFX. La interfaz permite al usuario ajustar los valores de color RGB (Rojo, Verde, Azul) mediante sliders y visualizar el resultado en tiempo real. El color resultante se muestra tanto visualmente como en formato de código RGB que puede copiarse al portapapeles.

## Objetivos

- Practicar el uso de Sliders para controles interactivos en JavaFX.
- Integrar sistema de logging con SLF4J y Logback.
- Generar un archivo .jar ejecutable con todas las dependencias.
- Crear una aplicación JavaFX bien estructurada y documentada que cumpla el 'hexálogo' ^-^
- Implementar interacción con el portapapeles del sistema.

## Características

- **Interfaz gráfica**: Diseñada con FXML y estilizada con CSS.
- **Sliders RGB**: Tres controles deslizantes para ajustar valores de Rojo, Verde y Azul (0-255)
- **Vista previa en tiempo real**: Rectángulo que muestra el color resultante.
- **Código RGB**: Etiqueta que muestra el valor RGB actual en formato de texto.
- **Copia al portapapeles**: Funcionalidad para copiar el código RGB con un clic.
- **Sistema de logging**: Registra eventos de la aplicación para depuración.
- **Ventana redimensionable**: Con tamaño mínimo configurado (340x480 píxeles).
- **Animaciones**: Feedback visual al copiar valores al portapapeles.

## Requisitos

- **Java 11** o superior
- **Maven 3.8** o superior
- **Dependencias gestionadas automáticamente** por Maven (ver `pom.xml`):
  - JavaFX Controls (21.0.5)
  - JavaFX FXML (21.0.5)
  - SLF4J API (2.0.13)
  - Logback Classic y Core (1.5.13)

## Ejecución

### Con Maven (Recomendado)
Para compilar y ejecutar el proyecto con Maven:

```bash
mvn clean javafx:run
```

### Compilación y empaquetado
Para crear un JAR ejecutable con todas las dependencias:

```bash
mvn clean package
```

Esto generará un archivo JAR en `target/` junto con las librerías necesarias en `target/libs/`.

### Ejecución del JAR
Una vez compilado, puedes ejecutar el JAR directamente:

```bash
java -jar target/sliderApp-1.0-SNAPSHOT.jar
```

## Documentación

Para generar la documentación JavaDoc:

```bash
mvn javadoc:javadoc
```

## Logging

La aplicación incluye un sistema de logging configurado con Logback. Los logs se generan en:
- `logs/appSliderPane-all.log` - Todos los eventos (DEBUG, INFO, WARN, ERROR)
- `logs/appSliderPane-info.log` - Solo eventos informativos y superiores

Los logs registran:
- Inicio y carga de la aplicación
- Carga de archivos FXML y CSS
- Cambios de valores en los sliders
- Copias de códigos RGB al portapapeles

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── es/wara/
│   │       ├── Lanzador.java          # Clase principal para empaquetado
│   │       ├── SliderApp.java         # Aplicación JavaFX principal
│   │       └── PaletaController.java  # Controlador FXML
│   └── resources/
│       └── es/wara/
│           ├── fxml/
│           │   └── paletaColores.fxml # Interfaz de usuario
│           └── css/
│               └── style.css          # Estilos personalizados
```

## Uso de la Aplicación

1. **Ajustar colores**: Mueve los sliders de Rojo, Verde y Azul para cambiar el color
2. **Ver resultado**: El rectángulo central muestra el color resultante en tiempo real
3. **Copiar código**: Haz clic en la etiqueta RGB para copiar el código al portapapeles
4. **Feedback visual**: La aplicación muestra una animación al copiar exitosamente

---

*Ejercicio de DEIN para reforzar conceptos de JavaFX, FXML y el uso de Sliders como controles interactivos.*
