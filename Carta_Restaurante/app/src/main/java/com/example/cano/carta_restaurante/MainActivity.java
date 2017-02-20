package com.example.cano.carta_restaurante;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import xyz.hanks.library.SmallBang;
import xyz.hanks.library.SmallBangListener;

/**
    Actividad principal del desarrollo de la aplicación carta virtual.
 **/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnsiguiente, btnanterior;
    ImageView imagen;

    //Se inicializará el vector de imagenes
    int[] imagenes={R.drawable.mar_encocado, R.drawable.serrano, R.drawable.envoliniti_de_quesos, R.drawable.pollo_al_aji_panka,
                    R.drawable.salmon_rosse, R.drawable.sombrero_vueltiao};

    int i=0;
    int total;


    //Aquí se creará la animación
    private SmallBang mSmallBang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        /**
         * Aquí se traen los contenidos de la actividad principal
         */
        btnsiguiente = (Button)findViewById(R.id.button_sgte);
        btnanterior = (Button)findViewById(R.id.button_atras);

        imagen = (ImageView) findViewById(R.id.imagenv);

        /**
         * Aquí se configurarán las acciones de ambos botones
         */

        btnanterior.setOnClickListener(this);
        btnsiguiente.setOnClickListener(this);

        total = imagenes.length;

        /**
         * Esta es una barra de opciones
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        **/

        //Implementación de la animación
        mSmallBang = SmallBang.attach2Window(this);
        fab.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               /**
                * Animación más navegación hacia la api de google maps
                */
               addNumber(v);

               Intent intent= new Intent(MainActivity.super.getApplicationContext(),localizanos.class);
               startActivity(intent);

           }
        });



    }
    public void addNumber(View view){
        mSmallBang.bang(view, new SmallBangListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
                    toast("!Localizanos¡");
            }
        });
    }
    private void toast(String text){
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id == R.id.button_sgte){
            i++;
            if(i == total )
                i=0;
        }if(id == R.id.button_atras){
            i--;
            if(i == -1)
                i=total-1;

        }
        imagen.setImageResource(imagenes[i]);


    }

}
