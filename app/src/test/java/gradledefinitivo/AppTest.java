package gradledefinitivo;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // Add books test
    @Test
    void testAnadirLibro() {

        AppMain gestor = new AppMain();

        // HashMap que añade ñiros
        Map<String, Map<String, Boolean>> resultado = gestor.anadirLibro("Brandon Sanderso", "Mistbonr");
        // Libros marcados por defecto como no leidos
        assertTrue(resultado.containsKey("Brandon Sanderso"));
        assertTrue(resultado.get("Brandon Sanderso").containsKey("Mistbonr"));
        assertFalse(resultado.get("Brandon Sanderso").get("Mistbonr"));
    }

    // Delete books
    @Test
    void testEliminarLibro() {
        AppMain gestor = new AppMain();

        // Añadir un libro
        gestor.anadirLibro("Brandon Sanderso", "Mistbonr");

        // Eliminar el libro
        Map<String, Map<String, Boolean>> resultado = gestor.eliminarLibro("Brandon Sanderso", "Mistbonr");

        // Verificar si el libro ha sido eliminado correctamente
        assertFalse(resultado.containsKey("Brandon Sanderso"));
    }

    @Test
    void testEnumLibros() {
        AppMain gestor = new AppMain();

        // Añadir algunos libros
        gestor.anadirLibro("Brandon Sanderso", "Mistbonr");
        gestor.anadirLibro("George R.R. Martin", "A Game of Thrones");

        // Obtener la lista de libros
        List<String> libros = gestor.enumLibros();

        // Crear una lista esperada de libros
        List<String> librosEsperados = Arrays.asList("Autor : Brandon Sanderso, Titulo : Mistbonr, Leido :false",
                "Autor : George R.R. Martin, Titulo : A Game of Thrones, Leido :false");

        // Verificar que la lista de libros devuelta sea igual a la lista esperada
        assertEquals(libros, librosEsperados);
    }

    // Test para marcar un libro como leído
    @Test
    void testMarcarLeido() {
        AppMain gestor = new AppMain();

        // Añadir un libro
        gestor.anadirLibro("Brandon Sanderso", "Mistbonr");

        // Marcar el libro como leído
        boolean resultado = gestor.marcarLeido("Brandon Sanderso", "Mistbonr");

        // Verificar si el libro ha sido marcado como leído correctamente
        assertTrue(resultado);

        //Verifies if the book has been marked as read
        assertTrue(gestor.marcarLeido("Brandon Sanderso", "Mistbonr"));
    }

    @Test
    void testVerLibrosLeidos() {
        AppMain gestor = new AppMain();
        //Adds books 
        gestor.anadirLibro("Brandon Sanderson", "Mistbonr");
        gestor.anadirLibro("Brandon Sands", "StormLigth");

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
