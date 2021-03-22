import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {

    String szukanyFilm;
    int straconePunkty;
    String złaLitera;
    String prawidłowaLitera;
    boolean czyWygrana;

    //konstruktor
    public Game(String listafilmow) {
        MovieList movieList = new MovieList("listafilmow.txt");
        //przywołuję klasę movielist abym mógł z niej korzystać
        szukanyFilm = movieList.getRandomMovie().trim(); //trim - ukrywa litery w stringu
        straconePunkty = 0;
        złaLitera = "";
        prawidłowaLitera = "";
        czyWygrana = false;
    }

    public String getMovieTitle() {
        return szukanyFilm;
    } // metoda przywołująca szukany film

    public String ukrytyTytuł() {
        //tworzę metodę ukrywającą wylossowany wcześniej tytuł filmu
        if (prawidłowaLitera.equals("1")) {
            return szukanyFilm.replaceAll("[a-zA-Z&]", "?"); //zamień jakąkolwiek literę na "?"
        } else {
            szukanyFilm.replaceAll("[a-zA-Z&&[^]" + prawidłowaLitera + "]]", "?");
            //w innym wypadku
            return szukanyFilm.replaceAll("[a-zA-Z&&[^]" + prawidłowaLitera + "]]", "?");
        }
    }

    public String getZłaLitera() {
        return złaLitera;
    } //metoda sprawdzająca czy podano dobrą literę

    public boolean Wygrana() {
        return czyWygrana;
    } // metoda sprawdzająca czy wygrana

    public boolean koniecGry() {
        if (straconePunkty >= 10) {
            return true;
        }
        if (!ukrytyTytuł().contains("?")) {
            czyWygrana = true;
            return true;
        }
        return false;
    }

    // metoda która prosi o literę, automatycznie zamienia ją na małą i prosi o kolejną. od razu sprawdza czy podana litera
    // znajduje się w tytule
    public String inputLetter() {

        System.out.println("Zgadnij literę");
        Scanner scanner = new Scanner(System.in);
        String litera = scanner.nextLine().toLowerCase(Locale.ROOT);

        if (!litera.matches("a-z")) {
            System.out.println("to nie ta litera");
            return inputLetter();
        } //sprawdzam czy gracz już podawał tą literę
        else if (złaLitera.contains(litera) || prawidłowaLitera.contains(litera)) {
            System.out.println("już odgadłeś tą literę");
            return inputLetter();
        } else {
            return litera;
        }
    }


        public void odgadnijLiterę() {
            String znalezionaLitera = inputLetter();

            if (szukanyFilm.toLowerCase(Locale.ROOT).contains(znalezionaLitera)) {
                prawidłowaLitera += znalezionaLitera + znalezionaLitera.toUpperCase(Locale.ROOT);
            } else {
                straconePunkty++;
                złaLitera += " " + znalezionaLitera;
            }
        }
    }