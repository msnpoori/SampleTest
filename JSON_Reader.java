package country;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_Reader
{
    public static String getJson() throws FileNotFoundException, IOException, ParseException
    {
        JSONParser parser = new JSONParser();
        Object object = parser
                    .parse(new FileReader("/Users/RED7830/Documents/ws/sri1/country/src/main/resources/country.json"));
        //convert Object to JSONObject
       JSONObject jsonObject = (JSONObject)object;
      return jsonObject.toJSONString();
   
    }
}
