package com.example.parsingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ViewActivity extends AppCompatActivity {
    TextView ljson,lxml;
    int mode=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ljson=(TextView) findViewById(R.id.json_view);
        lxml=(TextView) findViewById(R.id.xml_view);
        mode=getIntent().getIntExtra("mode",0);
        if(mode==1){
            parsejson();
        }else if(mode==2){
            parsexml();
        } else if(mode==3){
            parseboth();
        }

    }

    private void parsejson(){
        try {
            InputStream inputStream = getAssets().open("Input.json");
            byte[] data=new byte[inputStream.available()];
            inputStream.read(data);
            String readData=new String(data);
            JSONObject jsonObject=new JSONObject(readData);
            JSONObject empobject=jsonObject.getJSONObject("employee");
            ljson.setText("CITY NAME: "+empobject.getString("city_name")+"\n");
            ljson.append("LATITUDE: "+empobject.getString("Latitude")+"\n");
            ljson.append("LONGITUDE: "+empobject.getString("Longitude")+"\n");
            ljson.append("TEMPERATURE: "+empobject.getString("Temperature")+"\n");
            ljson.append("HUMIDITY: "+empobject.getString("Humidity")+"\n");

        } catch(IOException e){
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
    private void parseboth(){
        try {
            InputStream inputStream = getAssets().open("Input.json");
            byte[] data=new byte[inputStream.available()];
            inputStream.read(data);
            String readData=new String(data);
            JSONObject jsonObject=new JSONObject(readData);
            JSONObject empobject=jsonObject.getJSONObject("employee");
            ljson.setText("CITY NAME: "+empobject.getString("city_name")+"\n");
            ljson.append("LATITUDE: "+empobject.getString("Latitude")+"\n");
            ljson.append("LONGITUDE: "+empobject.getString("Longitude")+"\n");
            ljson.append("TEMPERATURE: "+empobject.getString("Temperature")+"\n");
            ljson.append("HUMIDITY: "+empobject.getString("Humidity")+"\n");

            InputStream inputStream1=getAssets().open("Input.xml");
            DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document=documentBuilder.parse(inputStream1);
            NodeList nodeList=document.getElementsByTagName("employee");
            Node node=nodeList.item(0);
            Element emp=(Element) node;
            lxml.setText("CITY NAME: "+emp.getElementsByTagName("city_name").item(0).getTextContent()+"\n");
            lxml.append("LATITUDE: "+emp.getElementsByTagName("Latitude").item(0).getTextContent()+"\n");
            lxml.append("LONGITUDE: "+emp.getElementsByTagName("Longitude").item(0).getTextContent()+"\n");
            lxml.append("TEMPERATURE: "+emp.getElementsByTagName("Temperature").item(0).getTextContent()+"\n");
            lxml.append("HUMIDITY: "+emp.getElementsByTagName("Humidity").item(0).getTextContent()+"\n");

        } catch(IOException e){
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        }  catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        }

    }

    private void parsexml(){
        try{
            InputStream inputStream=getAssets().open("Input.xml");
            DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document=documentBuilder.parse(inputStream);
            NodeList nodeList=document.getElementsByTagName("employee");
            Node node=nodeList.item(0);
            Element emp=(Element) node;
            lxml.setText("CITY NAME: "+emp.getElementsByTagName("city_name").item(0).getTextContent()+"\n");
            lxml.append("LATITUDE: "+emp.getElementsByTagName("Latitude").item(0).getTextContent()+"\n");
            lxml.append("LONGITUDE: "+emp.getElementsByTagName("Longitude").item(0).getTextContent()+"\n");
            lxml.append("TEMPERATURE: "+emp.getElementsByTagName("Temperature").item(0).getTextContent()+"\n");
            lxml.append("HUMIDITY: "+emp.getElementsByTagName("Humidity").item(0).getTextContent()+"\n");
        } catch (IOException e){
            e.printStackTrace();
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        }

    }
}