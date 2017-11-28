package com.example.tmp_sda_1139.json_osama;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    String jcolors;
    String text="";
    TextView textView;
    HashSet<String> text2=new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());


        jcolors= " [\n" +
                " {\n" +
                "   \"color\": \"black\",\n" +
                "   \"category\" : \"hue\",\n" +
                "   \"type\": \"primary\",\n" +
                "   \"code\": {\n" +
                "     \"rgba\": [255, 255, 255, 1],\n" +
                "     \"hex\": \"#000\"\n" +
                "   }\n" +
                "  },\n" +
                "   {\n" +
                "   \"color\": \"white\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 0, 1], \n " +
                "   \"hex\": \"#FFF\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"red\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 0, 0, 1], \n " +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"blue\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 255, 1], \n" +
                "   \"hex\": \"#00F\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"yellow\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 0, 1], \n" +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "  {\n" +
                "    \"color\": \"green\",\n" +
                "    \"category\" : \"hue\",\n" +
                "    \"type\": \"secondary\",\n" +
                "    \"code\": {\n" +
                "       \"rgba\": [0, 255, 0, 1],\n" +
                "       \"hex\": \"#0F0\"\n" +
                "     }\n" +
                "   }\n" +
                " ]" ;
    }



    public void count(View view) throws JSONException
    {
        try {
            JSONArray colors = (JSONArray) new JSONTokener(jcolors).nextValue();
            int count=0;

            for(int i=0;i<colors.length();i++) {

                JSONObject color = colors.getJSONObject(i);

                JSONObject colorcode = color.getJSONObject("code");

                JSONArray rgba = (JSONArray) colorcode.get("rgba");

                String countcolor=rgba.toString();

                String [] colorList =countcolor.split(",");

                if (colorList[1].equals("255")){
                    count++;
                    //text+= (String)color.get("color")+"\n";

                text2.add(color.get("color")+"\n");
                }
            }
            textView.setText("the number of colors is "+count);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void list(View view) throws JSONException
    {
            count(view);

            textView.setText("the wanted colors are\n"+ text2.toString());

    }



    public void modify(View view) throws JSONException
    {
        try {

            JSONArray colors = (JSONArray) new JSONTokener(jcolors).nextValue();
            JSONObject orange= new JSONObject();
            orange.put("color", "orange");
            orange.put("category","hue");
            JSONObject code = new JSONObject();
            code.put("rgba", new JSONArray("[255, 255, 0, 1]") );
            code.put("hex","#FA0");
            orange.put("code", code);
            colors.put(orange);
            textView.setText(colors.toString(3));



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}