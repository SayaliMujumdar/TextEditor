package com.example.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner fontspinner ;
Spinner colorspinner;
Spinner stylespinner;
Button submit;
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       fontspinner=findViewById(R.id.fontspinner);
       colorspinner=findViewById(R.id.colorspinner);
       stylespinner=findViewById(R.id.facespinner);
        et=findViewById(R.id.editTextTextMultiLine);


       submit=findViewById(R.id.submit);

       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             // String font=(String) fontspinner.getSelectedItem()));
              //String color=android.graphics.Color.parseColor(String) colorspinner.getSelectedItem()));
               Toast.makeText(MainActivity.this,"Submitted",Toast.LENGTH_LONG).show();

           }
       });
       fontspinner.setOnItemSelectedListener(this);
       colorspinner.setOnItemSelectedListener(this);
       stylespinner.setOnItemSelectedListener(this);

    }

    private void populatestylesSpinner() {
        ArrayAdapter<String> stylesadapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.StylesArray));
        stylesadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontspinner.setAdapter(stylesadapter);
    }


    private void populatecolorsSpinner() {
        ArrayAdapter<String> coloradapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.colorsArray));
        coloradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontspinner.setAdapter(coloradapter);
    }

    private void populateFontsSpinner() {
        ArrayAdapter<String> fontadapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.FontsArray));
       fontadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       fontspinner.setAdapter(fontadapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
     if(parent.getId()==R.id.fontspinner)
     {
         String fontoftext=parent.getSelectedItem().toString();
         et.setTextSize(Integer.parseInt(fontoftext));
         Toast.makeText(MainActivity.this,"Submitted size "+fontoftext,Toast.LENGTH_LONG).show();

     }
     else if(parent.getId()==R.id.colorspinner)
     {
         String coloroftext=parent.getSelectedItem().toString();
         et.setTextColor(android.graphics.Color.parseColor(coloroftext));
     }
     else
     {
         String styleoftext=parent.getSelectedItem().toString();
       if(styleoftext.equals("bold"))
         {
             et.setTypeface(null,Typeface.BOLD);
         }
         if(styleoftext.equals("italic"))
         {
             et.setTypeface(null,Typeface.ITALIC);
         }
         if(styleoftext.equals("Normal"))
         {
             et.setTypeface(null,Typeface.NORMAL);
         }


     }




    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}