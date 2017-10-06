package com.ehsaniara.dataStructureSample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/30/17.
 * From http://www.ehsaniara.com
 * <p>
 * <p>
 * Looking at the output, its clear that ConcurrentHashMap takes care of any new entry in the map whereas HashMap throws ConcurrentModificationException.
 */
public class ConcurrentHashMapExample {


    public static void main(String[] args) {

        //ConcurrentHashMap
        Map<String, String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: " + myMap);
        Iterator<String> it = myMap.keySet().iterator();

        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("3")) myMap.put(key + "new", "new3");
        }
        System.out.println("ConcurrentHashMap after iterator: " + myMap);

        //HashMap
        myMap = new HashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap before iterator: " + myMap);
        Iterator<String> it1 = myMap.keySet().iterator();

        while (it1.hasNext()) {
            String key = it1.next();
            if (key.equals("3")) {
                myMap.put(key + "new", "new3");
                //break; // to stop the loop
            }
        }
        System.out.println("HashMap after iterator: " + myMap);
    }


}
