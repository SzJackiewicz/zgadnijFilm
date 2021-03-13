import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            //przywołuję klasę wraz z metodami
            GameAndList game = new GameAndList();
            String randomMovie = game.generateRandomMovie(game.getMovieList("listafilmow.txt"));
            game.setRandomMovie(randomMovie);
            String encryptedMovie = game.encryptMovie(randomMovie);
            game.setEncryptedMovie(encryptedMovie);
            Scanner input = new Scanner(System.in);
            char guess;
            int wrongAttempts = 0;
            game.setWrongAttempts(wrongAttempts);
            System.out.println("Witaj w grze ODGADNIJ FILM. Spróbuj odgadnąć ukryty tytuł filmu podając pojedyncze litery. Masz 10 prób. Powodzenia!");
            while (!game.gameOver()) {
                System.out.print("Ukryty tytuł to: ");
                System.out.println(game.getEncryptedMovie());
                System.out.print("W tytule nie ma litery:  (" + game.getWrongAttempts());
                System.out.println(game.getWrongGuesses());
                //wyświetl pozostałą ilość prób
                System.out.println("Pozostało Ci (" + game.getAttemptsLeft() + ") prób.");
                System.out.print("Podaj Literę ");
                //przerób wprowadzoną literę na małą
                guess = input.next().toLowerCase().charAt(0);
                //sprawdzaj czy użytkownik podał literę czy niedozwolony znak
                if (game.isValidGuess(guess)) {
                    if (!game.hasAlreadyGuessed(guess)) {
                        game.checkGuess(guess);
                    } else {
                        System.out.println("Odgadłeś:  '" + guess + "'.");
                    }
                } else {
                    System.out.println("Podawaj tylko litery.");
                }
                System.out.println();
            }
            //warunek wygranej
            if (game.gameWon()) {
                System.out.println("WYGRANA! ");
            } else {
                System.out.println("PORAŻKA!");
                System.out.println("Tytuł filmu to: " + randomMovie + "'.");
            }
            input.close();
        } catch(FileNotFoundException fnf) {
            System.out.println("nie znaleziono pliku z filmami");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
}
