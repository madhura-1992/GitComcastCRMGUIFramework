package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fr=new FileReader("./configAppData/commondataforvtiger.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject jObj=(JSONObject)obj;
		String data = jObj.get(key).toString();
		return data;
	}
}
