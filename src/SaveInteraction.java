import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SaveInteraction {
    public static void createSave(String Username, String startinggift, String startingclass) throws IOException {

        JSONObject Save = new JSONObject();
        Save.put("Username", Username);
        Save.put("Starting Gift", startinggift);
        Save.put("Starting Class", startingclass);

        FileWriter writeToJSON = new FileWriter("saves/Save.json");
        writeToJSON.write(Save.toString());
        writeToJSON.close();



    }
    public static void loadSave() throws FileNotFoundException, IOException, ParseException{
        Object loader = new JSONParser().parse(new FileReader("saves/Save.json"));
        JSONObject Save = (JSONObject) loader;
        player Player = new player(Save.get("Username").toString(), Save.get("Starting Gift").toString(), Save.get("Starting Class").toString());

    }
    public static void start() throws FileNotFoundException, IOException, ParseException{
        File saveFile = new File("saves/Save.json");
            if(saveFile.exists() && !saveFile.isDirectory()) { 
                System.out.println("Loaded save");
                loadSave();
            }else{
                try {
                    System.out.println("Creating Save");
                    saveFile.createNewFile();
                    createSave("Username", "Key", "Theif");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
    }    
}
