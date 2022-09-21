package com.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import com.google.gson.*;

public class JSonTest {
    private static String x = 
    		"{\"data\": \"{\\\"name\\\": \\\"Sha Md. Masud Ikbal\\\",\\\"dob\\\": \\\"1986-01-29\\\",\\\"gender\\\": \\\"Male\\\",\\\"number\\\": \\\"+8801715469424\\\",\\\"email\\\": \\\"masud.cseu@gmail.com\\\",\\\"nid\\\": \\\"2692858515566\\\",\\\"father\\\": \\\"Md. Solaiman Patwari\\\",\\\"mother\\\": \\\"Mosa: Monowara Begum\\\",\\\"maritalStatus\\\": \\\"MARRIED\\\",\\\"address\\\": \\\"{\\\\\\\"presentAddress\\\\\\\":\\\\\\\"Home / Holding: 17, Village / Road: Baddanagar Lane, Ward No-22, Post Office: Newmarket-1205, Hazaribagh, Dhaka\\\\\\\",\\\\\\\"permanentAddress\\\\\\\":\\\\\\\"Home / Holding: , Village / Road: Ramakrishnapur,, Post Office: North Jaipur-, Lakshnipur Sadar, Lakshmipur\\\\\\\"}\\\",\\\"tinNumber\\\": \\\"6985552255\\\",\\\"occupation\\\": \\\"Farmer/Fisherman/Labourer\\\",\\\"monthlyIncome\\\": \\\"578412\\\",\\\"nominee\\\": \\\"{\\\\\\\"name\\\\\\\":\\\\\\\"Md.Solaiman Patowary\\\\\\\",\\\\\\\"relationship\\\\\\\":\\\\\\\"Father\\\\\\\",\\\\\\\"pidNumber\\\\\\\":\\\\\\\"BG232332224\\\\\\\",\\\\\\\"pidType\\\\\\\":\\\\\\\"Passport\\\\\\\"}\\\",\\\"photo\\\": \\\"E:/ekychome/data\\\",\\\"signature\\\": \\\"E:/ekychome/data\\\",\\\"tinDocument\\\": \\\"E:/ekychome/data\\\",\\\"nomineePidDocument\\\": \\\"E:/ekychome/data\\\"\\n}\"\r\n"
    		+ "}";
    public static void main(String[] args) {
        String text ="{data:{\"name\" : \"1234\", \"address\":\"sgf\"}}";
        Gson gson = new Gson();
        String t = gson.toJson(text);
        //x = x.replace("\\r", "");
        //x = x.replace("\\n", "");
      
       //System.out.println(x);
        //x = x.replaceAll("\\r", "").replaceAll("\\n", "").replaceAll("\\", "");
        JsonObject obj = new Gson().fromJson(x, JsonObject.class);
        Set<String> keys = obj.keySet();

        String finalJson = "";
        for(String key : keys) {
        	//System.out.println(obj.get(key).getAsString());
        	finalJson += obj.get(key).getAsString();
        }
        System.out.println(finalJson);
        
        JsonObject finalJsonObj = new Gson().fromJson(finalJson, JsonObject.class);
        System.out.println(finalJsonObj.toString());
		try (PrintWriter out = new PrintWriter(new FileWriter("d:/app.json"))) {
		    out.write(finalJsonObj.toString());
		} catch (Exception e) {
		    e.printStackTrace();
		}
        
		/*gson = new Gson();
		
		JsonElement element = gson.fromJson(finalJsonObj.toString(), JsonElement.class);
		try {
			gson.toJson(element, new FileWriter("d:/app.json"));
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
       
        
        
        
    }

}
