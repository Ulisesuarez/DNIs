package org.mvpigs.DNIregex;

import java.util.HashMap;
import java.util.Map;

public class RegexNIF {

    private Map<String, String> regexDiccionario = null;

    public RegexNIF(){
        this.regexDiccionario = new HashMap<String, String>();
    }

    public void addRegex(String key, String value) {
        this.regexDiccionario.put(key, value);
    }

    public Map<String, String> getRegex() {
        return this.regexDiccionario;
    }

    public String getRegexValue(String key) {
        return this.regexDiccionario.get(key);
    }

}
