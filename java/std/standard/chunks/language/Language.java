package std.standard.chunks.language;

import org.bukkit.ChatColor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import std.standard.chunks.Chunks;
import std.standard.chunks.enums.LanguageEnum;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Language {

    /**
     * @param whatToChoose Choose it from LanguageEnum
     * @return Returns Selected Language
     */
    public String DeSeriallizer(LanguageEnum whatToChoose) {
        String rtn;
        try {
            JSONParser parser = new JSONParser();
            Reader langFile = new FileReader(Chunks.getPlugin().getDataFolder() + "\\configs\\lang.json");
            JSONObject object = (JSONObject) parser.parse(langFile);
            String curLang = (String) object.get("curLang");

            if(curLang != null) {
                rtn = (String) object.get(curLang + "_" + whatToChoose);
            } else {
                rtn = ChatColor.RED + "Invalid Language.";
            }
        } catch (IOException e) {
            rtn = ChatColor.RED + "Failed to read language json file.";
        } catch (ParseException e) {
            rtn = e.getLocalizedMessage();
        }

        return rtn;
    }

}
