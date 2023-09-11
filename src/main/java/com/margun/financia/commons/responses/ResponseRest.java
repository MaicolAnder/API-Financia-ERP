package com.margun.financia.commons.responses;

import com.margun.financia.commons.helpers.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Class for general api rest response
 * @author Miguel A Tunubalá
 */
public class ResponseRest {

    private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getMetadata() {
        return this.metadata;
    }

    /**
     * Add to metadata ArrayList HashMap item
     * @param map HashMap String and String
     */
    public void setMetadata(HashMap<String, String> map) {
        this.getMetadata().add(map);
    }

    /**
     * Set message, code and date as String in metadata for response
     * @param message string
     * @param code string
     * @param date util.Date
     */
    public void setMetadata(String message, String code, Date date) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("code", code);
        map.put("date", date.toString());
        setMetadata(map);
    }

    /**
     * Set message, code and date as String in metadata for response
     * @param message string
     * @param code string
     * @param date string
     */
    public void setMetadata(String message, String code, String date) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("code", code);
        map.put("date", date);
        setMetadata(map);
    }

    /**
     * Set message and code in metadata for response
     * @param message
     * @param code
     */
    public void setMetadata(String message, String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("code", code);
        map.put("date", Utils.getCurrenDate());
        setMetadata(map);
    }

    /**
     * Set message for a success response
     * @param message
     */
    public void setMetadata(String message) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("code", "200");
        map.put("date", Utils.getCurrenDate());
        setMetadata(map);
    }
}
