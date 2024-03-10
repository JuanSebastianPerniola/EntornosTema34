package gradledefinitivo;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // Add books test
    @Test
    void testAñadirLibro() {

        App gestor = new App();

        // HashMap que añade ñiros
        Map<String, Map<String, Boolean>> resultado = gestor.añadirLibro("Brandon Sanderso", "Mistbonr");
        // Libros marcados por defecto como no leidos
        assertTrue(resultado.containsKey("Brandon Sanderso"));
        assertTrue(resultado.get("Brandon Sanderso").containsKey("Mistbonr"));
        assertFalse(resultado.get("Brandon Sanderso").get("Mistbonr"));
    }

    // Delete books
    @Test
    void testEliminarLibro() {
        App gestor = new App();

        // Añadir un libro
        gestor.añadirLibro("Brandon Sanderso", "Mistbonr");

        // Eliminar el libro
        Map<String, Map<String, Boolean>> resultado = gestor.eliminarLibro("Brandon Sanderso", "Mistbonr");

        // Verificar si el libro ha sido eliminado correctamente
        assertFalse(resultado.containsKey("Brandon Sanderso"));
    }

    @Test
    void testEnumLibros() {
        App gestor = new App();

        // Añadir algunos libros
        gestor.añadirLibro("Brandon Sanderso", "Mistbonr");
        gestor.añadirLibro("George R.R. Martin", "A Game of Thrones");

        // Obtener la lista de libros
        List<String> libros = gestor.enumLibros();

        // Crear una lista esperada de libros
        List<String> librosEsperados = Arrays.asList("Autor : Brandon Sanderso, Titulo : Mistbonr, Leído :false",
                "Autor : George R.R. Martin, Titulo : A Game of Thrones, Leído :false");

        // Verificar que la lista de libros devuelta sea igual a la lista esperada
        assertEquals(libros, librosEsperados);
    }

    // Test para marcar un libro como leído
    @Test
    void testMarcarLeido() {
        App gestor = new App();

        // Añadir un libro
        gestor.añadirLibro("Brandon Sanderso", "Mistbonr");

        // Marcar el libro como leído
        boolean resultado = gestor.marcarLeido("Brandon Sanderso", "Mistbonr");

        // Verificar si el libro ha sido marcado como leído correctamente
        assertTrue(resultado);

        //Verifies if the book has been marked as read
        assertTrue(gestor.marcarLeido("Brandon Sanderso", "Mistbonr"));
    }

    @Test
    void testVerLibrosLeidos() {
        App gestor = new App();
        //Adds books 
        gestor.añadirLibro("Brandon Sanderson", "Mistbonr");
        gestor.añadirLibro("Brandon Sands", "StormLigth");

        gestor.marcarLeido("Brandon Sanderson", "Mistbonr");
        gestor.marcarLeido("Brandon Sands", "StormLigth");
        // Ejecutamos el método que queremos probar

        String resultado = gestor.verLibrosLeidos("Brandon Sanderson");
        String resultado2 = gestor.verLibrosLeidos("Brandon Sands");

        //leido true 
        assertTrue(resultado.contains("Mistbonr=true"));
        assertTrue(resultado2.contains("StormLigth=true"));

    }

    // aaaaaa
}
