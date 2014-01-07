package com.snoopdogg.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFile
{
    public static void main(String[] args)
    {        
        readJsonFile();
    }

    public static void readJsonFile() {

        BufferedReader br = null;
        JSONParser parser = new JSONParser();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("C:\\Users\\stink_000.LJ\\Desktop\\ItemDef.json"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println("Record:\t" + sCurrentLine);

                Object obj;
                try {
                    obj = parser.parse(sCurrentLine);
                    JSONObject jsonObject = (JSONObject) obj;

                    long id = (long) jsonObject.get("id");
                    System.out.println(id);

                    long actions = (long) jsonObject.get("value");
                    System.out.println(actions);
                    
                    String name = (String) jsonObject.get("ground");
                    System.out.println(name);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}