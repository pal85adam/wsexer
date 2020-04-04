package wsexer;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Hello there ! ,, Please choose an option: "
                    + "\n(1) To retrieve pokemon basic information."
                    + "\n(2) To retrieve location translations information."
                    + "\nElse Exit.");

            int option = 0;
            // In case the user provides non numeric option
            try {
                option = Integer.parseInt(scanner.next());
            }catch (NumberFormatException e){
                // one way to exit the scope is to return;
                return;
            }

            switch (option){
                case 1: {

                    System.out.println("Enter a Pokemon name to retrieve its data: ");
                    String pokemonName = scanner.next();

                    System.out.println(PokemonDataHandler.printPokemonBasicInfo(pokemonName));

                } break;
                case 2: {

                    System.out.println("Enter a location name to retrieve its translations: ");
                    String locationName = scanner.next();

                    System.out.println(PokemonDataHandler.printLocationTranslations(locationName));

                } break;
                // one way to exit the scope is to return;
                default: return;
            }
        }
    }



}
