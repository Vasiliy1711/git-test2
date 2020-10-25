package com.example.musicshop;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopData
{
    public static ArrayList<String> list = new ArrayList<String>()
    {{
        add("Bajaj");
        add("BMW");
        add("Suzuki");
        add("KTM");
    }};
    public static HashMap createMap()
    {
        HashMap map = new HashMap();
        map.put("Bajaj", 2000.0);
        map.put("BMW", 18000.0);
        map.put("Suzuki", 17000.0);
        map.put("KTM", 16000.0);
        return map;
    }
}
