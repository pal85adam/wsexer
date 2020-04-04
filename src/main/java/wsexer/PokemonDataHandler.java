package wsexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonDataHandler {

    public static String printPokemonBasicInfo(String pokemonName){

        if(isNumeric(pokemonName)) return "Please enter a valid pokemon name!";

        String pokemonJSONString= HTTPRequester.makeHTTPRequest("pokemon", pokemonName);

        if(pokemonJSONString != null) {

        Map<String,Object> pokemon = JSONMapper.jsonToMap(pokemonJSONString);

            return "Pokemon ID: " + pokemon.get("id")
                    + "\nName: " + pokemon.get("name")
                    + "\nHeight: " + pokemon.get("height")
                    + "\nWeight: " + pokemon.get("weight");
        }else{
            return "No date retrieved for the pokemon you provided!";
        }
    }

    public static String printLocationTranslations(String locationName){
        if(isNumeric(locationName)) return "Please enter a valid location name!";

        String locationJSONString = HTTPRequester.makeHTTPRequest("location",locationName);

        if(locationJSONString != null) {

            Map<String,Object> location = JSONMapper.jsonToMap(locationJSONString);

            List<Map<String,Object>> names = (List<Map<String, Object>>) location.get("names");

            return names.stream()
                    .map(name -> "Location Name: "
                            + (String)name.get("name") + " Language: "
                            + ((Map<String, Object>)name.get("language")).get("name")
                            + "\n")
                    .reduce("",(result, name)->{ return result + name; });

        }else{
            return "No date retrieved for the location you provided!";
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
