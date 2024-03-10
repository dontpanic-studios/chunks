package std.standard.chunks.language;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import std.standard.chunks.Chunks;
import std.standard.chunks.enums.LanguageEnum;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Language {

    public String DeSeriallizer(LanguageEnum whatToChoose)
    {
        String rtn;
        String raw;
        try {
            JSONParser parser = new JSONParser();
            Reader langFile = new FileReader(Chunks.getPlugin().getDataFolder() + "\\configs\\lang.json");
            JSONObject object = (JSONObject) parser.parse(langFile);
            String curLang = (String) object.get("curLang");

            if(curLang != null) {
                raw = korToUni(object.get(curLang + "_" + whatToChoose).toString());
                rtn = uniToKor(raw);
            } else {
                rtn = "Invalid Language";
            }
        } catch (IOException e) {
            rtn = "Failed to read language json file.";
        } catch (ParseException e) {
            rtn = e.getLocalizedMessage();
        }

        return rtn;
    }
    public String korToUni(String kor){
        StringBuffer result = new StringBuffer();

        for(int i=0; i<kor.length(); i++){
            int cd = kor.codePointAt(i);
            if (cd < 128) {
                result.append(String.format("%c", cd));
            } else{
                result.append(String.format("\\u%04x", cd));
            }
        }
        return result.toString();
    }

    public String uniToKor(String uni){
        StringBuffer result = new StringBuffer();

        for(int i=0; i<uni.length(); i++) {
            if(uni.charAt(i) == '\\' &&  uni.charAt(i+1) == 'u'){
                Character c = (char)Integer.parseInt(uni.substring(i+2, i+6), 16);
                result.append(c);
                i+=5;
            } else {
                result.append(uni.charAt(i));
            }
        }
        return result.toString();
    }

}
