package com.margun.financia.commons.responses;

import com.margun.financia.commons.helpers.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ResponseRest {

    private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getMetadata() {
        return metadata;
    }

    public void setMetadata(String message, String code, Date date) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("code", code);
        map.put("date", date.toString());
        this.metadata.add(map);
    }

    public void setMetadata(String message, String code, String date) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("code", code);
        map.put("date", date);
        this.metadata.add(map);
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
        this.metadata.add(map);
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
        this.metadata.add(map);
    }
}
