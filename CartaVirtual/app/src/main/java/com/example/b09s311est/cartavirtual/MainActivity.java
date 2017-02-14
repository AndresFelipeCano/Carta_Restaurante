package com.example.b09s311est.cartavirtual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.*;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton_Carta_del_Dia = (Button) findViewById(R.id.Boton_Carta);
        TextView texto_boton_Carta_del_Dia =(TextView) findViewById(R.id.textView);

    }

    public void OnClickBienvenida1(View v){


        Intent intencion = new Intent(this,Main2Activity.class);
        startActivity(intencion);

    }
}
