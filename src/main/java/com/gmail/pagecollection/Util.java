package com.gmail.pagecollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Util {

  public static HashMap<Object, Object> map = new HashMap<>();

  public static Util instance = new Util();

  private Util() {}

  public static Util getInstance() {
    return instance;
  }

  public static String getValue(String key) {
    return String.valueOf(map.get(key));
  }


  public static void add(String key, String value) {
    map.put(key, value);
  }

  public static void add(String[][] pairs) {
    for (String[] pair : pairs) {
      map.put(pair[0], pair[1]);
    }
  }

  public static void add(String[] keys, String[] values) {
    for (int i = 0; i < keys.length; ++i) {
      map.put(keys[i], values[i]);
    }



  }


  public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
    Map<String, Object> retMap = new HashMap<String, Object>();
    if (json != JSONObject.NULL) {
      retMap = toMap(json);
    }
    return retMap;
  }

  public static Map<String, Object> toMap(JSONObject object) throws JSONException {
    Map<String, Object> map = new HashMap<String, Object>();
    Iterator<String> keysItr = object.keys();
    while (keysItr.hasNext()) {
      String key = keysItr.next();
      Object value = object.get(key);
      if (value instanceof JSONArray) {
        value = toList((JSONArray) value);
      } else if (value instanceof JSONObject) {
        value = toMap((JSONObject) value);
      }
      map.put(key, value);
    }
    return map;
  }

  public static List<Object> toList(JSONArray array) throws JSONException {
    List<Object> list = new ArrayList<Object>();
    for (int i = 0; i < array.length(); i++) {
      Object value = array.get(i);
      if (value instanceof JSONArray) {
        value = toList((JSONArray) value);
      } else if (value instanceof JSONObject) {
        value = toMap((JSONObject) value);
      }
      list.add(value);
    }
    return list;
  }

  

}
