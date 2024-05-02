package gradledefinitivo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMain {

    private Map<String, Map<String, Boolean>> biblioteca;

    public AppMain() {
        this.biblioteca = new HashMap<>();
    }

    public Map<String, Map<String, Boolean>> anadirLibro(String autor, String titulo) {
        if (!biblioteca.containsKey(autor)) {
            biblioteca.put(autor, new HashMap<>());
        }
        biblioteca.get(autor).put(titulo, false);
        return biblioteca;
    }

    public Map<String, Map<String, Boolean>> eliminarLibro(String autor, String titulo) {
        if (biblioteca.containsKey(autor)) {
            biblioteca.get(autor).remove(titulo);
            if (biblioteca.get(autor).isEmpty()) {
                biblioteca.remove(autor);
            }
        }
        return biblioteca;
    }

    public List<String> enumLibros() {
        List<String> libros = new ArrayList<>();
        for (String autor : biblioteca.keySet()) {
            for (String titulo : biblioteca.get(autor).keySet()) {
                boolean leido = biblioteca.get(autor).get(titulo);
                libros.add(String.format("Autor : %s, Titulo : %s, Leido :%s", autor, titulo, leido));
            }
        }
        return libros;
    }

    public boolean marcarLeido(String autor, String titulo) {
        if (biblioteca.containsKey(autor) && biblioteca.get(autor).containsKey(titulo)) {
            biblioteca.get(autor).put(titulo, true);
            return true;
        }
        return false;
    }

    public String verLibrosLeidos(String autor) {
        StringBuilder sb = new StringBuilder();
        if (biblioteca.containsKey(autor)) {
            for (String titulo : biblioteca.get(autor).keySet()) {
                boolean leido = biblioteca.get(autor).get(titulo);
                sb.append(String.format("%s=%s, ", titulo, leido));
            }
        }
        return sb.toString().trim();
    }
}
