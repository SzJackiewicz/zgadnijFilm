import com.sun.source.tree.WhileLoopTree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MovieList {
    ArrayList<String> tablicaFilmów;

    public MovieList(String pathname) {
        tablicaFilmów = new ArrayList<>();
        File file = new File("listafilmow.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                tablicaFilmów.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("plik nie istnieje");
        }
    }

    //poniżej metoda losująca film z tablicy.
    // czyli sprawdź ile ma elementów i wylosuj jeden z nich mając na uwadze wielkość tablicy
public String getRandomMovie(){
    int movieIndex = (int) (Math.random()*tablicaFilmów.size());
    return tablicaFilmów.get(movieIndex);
    }
}

