public class Main {

    public static void main(String[] args) {
        Game game = new Game("listafilmow.txt"); // przywołuję klasę Game oraz metody w niej zawarte

        //komunikaty powitalne poniżej:

        System.out.println("Witaj w Grze odgadnij film");
        System.out.println("Twoim zadaniem jest odgadnąć ukryty tytuł filmu, litera po literze");
        System.out.println("jeśli odgadniesz literę, możesz próbować dalej");
        System.out.println("jeśli nie odgadniejsz = tracisz punk");
        System.out.println("uważaj bo masz tylko 10 prób!");
        System.out.println("Powodzenia!");
        System.out.println("Tytuł filmu ma: " + game.szukanyFilm.length() + " liter");

        while (!game.koniecGry()){
            System.out.println("Odgadujesz: " + game.ukrytyTytuł());
            System.out.println("Odgadłeś (" + game.getZłaLitera().length()/2 + " ) złe litery: " + game.getZłaLitera());
        game.odgadnijLiterę();
        }
        if(game.Wygrana()){
            System.out.println("Wygrałeś!");
            System.out.println("Odgadłeś: " + game.getMovieTitle());
        } else {
            System.out.println("Odgadłeś (" + game.getZłaLitera().length()/2 + ") złych liter" + game.getZłaLitera());
            System.out.println("Przegrałeś!");
            System.out.println("Ukryty tytuł to: " + game.getMovieTitle());
        }
    }
}
