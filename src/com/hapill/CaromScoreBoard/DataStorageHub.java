package com.hapill.CaromScoreBoard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class DataStorageHub {
	private String mFileName = "userdata.txt";
	public String getmFileName() {
		return mFileName;
	}
	public void setmFileName(String mFileName) {
		this.mFileName = mFileName;
	}
	private String mJsonCache; // 매번 파일 쓰기 하면 곤란하니까 캐시로 ... 아직 미구현
	private static DataStorageHub singleton = new DataStorageHub();
    private DataStorageHub(){
    }
    public static DataStorageHub getInstance(){
        return singleton;
    } 
    public void setFileName(String fileName)
    {
    	mFileName = fileName;
    }
    private String getFileData()
    {
    	BufferedReader reader;
    	String buf;
    	String data = "";
		try {
			reader = new BufferedReader(new FileReader(mFileName));
			while((buf = reader.readLine()) != null)
			{
				data += buf;
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "{}";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
    }
    public void put(String field, String value)
    {
    	JSONObject json = null;
		try {
			json = new JSONObject(getFileData());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			json.put(field, value);
			BufferedWriter writer = new BufferedWriter(new FileWriter(mFileName));
			writer.write(json.toString());
			writer.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    public void put(String field, int value)
    {
    	JSONObject json;
		try {
			json = new JSONObject(getFileData());
			json.put(field, value);
			BufferedWriter writer = new BufferedWriter(new FileWriter(mFileName));
			writer.write(json.toString());
			writer.close();
		} catch (JSONException e) {
			//  AutoTODO-geneatrated cch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public String getString(String field)
    {
    	JSONObject json = null;
    	String temp = getFileData();
    	try {
			json = new JSONObject(getFileData());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "";
		}
    	
    	String retValue = null;
    	try {
			retValue = json.getString(field);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // 한글 한글날아온 불j빛 조용ㅏㅏㅏh
			return "";
		}
		return retValue;
    }
    public int getInt(String field)
    {
    	JSONObject json = null;
    	
    	try {
			json = new JSONObject(getFileData());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	int retValue = 0;
    	try {
			retValue = json.getInt(field);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retValue;	
    }
}
