package gradledefinitivo;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    //Add books test 
    @Test
    void testAñadirLibro() {

        GestorDeLibros gestor = new GestorDeLibros();

        // HashMap que añade ñiros
        Map<String, Map<String, Boolean>> resultado = gestor.añadirLibro("Brandon Sanderso", "Mistbonr");
        //Libros marcados por defecto como no leidos
        assertTrue(resultado.containsKey("Brandon Sanderso"));
        assertTrue(resultado.get("Brandon Sanderso").containsKey("Mistbonr"));
        assertFalse(resultado.get("Brandon Sanderso").get("Mistbonr")); 
    }

    // Delete books 
    @Test
    void testEliminarLibro() {
        GestorDeLibros gestor = new GestorDeLibros();

        // Añadir un libro
        gestor.añadirLibro("Brandon Sanderso", "Mistbonr");

        // Eliminar el libro
        Map<String, Map<String, Boolean>> resultado = gestor.eliminarLibro("Brandon Sanderso", "Mistbonr");

        // Verificar si el libro ha sido eliminado correctamente
        assertFalse(resultado.containsKey("Brandon Sanderso"));
    }

    //Itinirate books 
    @Test
    void testEnumLibros() {
        GestorDeLibros gestor = new GestorDeLibros();

        //add some books here
        gestor.añadirLibro("Brandon Sanderso", "Mistbonr");
        gestor.añadirLibro("George R.R. Martin", "A Game of Thrones");

        // we got back the list 
        gestor.enumLibros();
    }

    // Test para marcar un libro como leído
    @Test
    void testMarcarLeido() {
        GestorDeLibros gestor = new GestorDeLibros();

        // Añadir un libro
        gestor.añadirLibro("Brandon Sanderso", "Mistbonr");

        // Marcar el libro como leído
        boolean resultado = gestor.marcarLeido("Brandon Sanderso", "Mistbonr");

        // Verificar si el libro ha sido marcado como leído correctamente
        assertTrue(resultado);
        assertTrue(gestor.marcarLeido("Brandon Sanderso", "Mistbonr"));
    }

    @Test
    void testVerLibrosLeidos() {
        GestorDeLibros gestor = new GestorDeLibros();
        gestor.añadirLibro("Brandon Sanderso", "Mistbonr");
        gestor.añadirLibro("Brandon Sanderso", "StormLigth");
        gestor.marcarLeido("Brandon Sanderso", "Mistbonr");
    
        // Ejecutamos el método que queremos probar
        String resultado = gestor.verLibrosLeidos("Brandon Sanderso");
    
        // Verificamos si el resultado contiene el libro esperado
        assertTrue(resultado.contains("Mistbonr=true"));

    }
}
