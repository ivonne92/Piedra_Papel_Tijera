package com.example.doris.piedra_papel_tijera;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class IniciarJuego extends AppCompatActivity {
    TextView puntos,nick,ganados, perdidos, empates;
    Random pc;
    Button bt, fin;
    String [] mano = {"PIEDRA", "PAPEL","TIJERA","PIEDRA", "PAPEL","TIJERA"};
    int min = 0;
    int max = 5;
    int contaganes=0,contaperdido=0,empa=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_juego);

        bt = (Button)findViewById(R.id.button6);
        fin = (Button)findViewById(R.id.button5);
        puntos = (TextView)findViewById(R.id.textView7);
        nick = (TextView)findViewById(R.id.textView11);
        ganados = (TextView)findViewById(R.id.textView13);
        perdidos = (TextView)findViewById(R.id.textView15);
        empates = (TextView)findViewById(R.id.textView17);

        //obteniendo el nombre del jugador
        Bundle datos = this.getIntent().getExtras();
        nick.setText(datos.getString("jugador"));

        pc = new Random();
       // int i1 = r.nextInt(max - min + 1) + min;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_iniciar_juego, menu);
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
     String generaricono(String x){
         String ret = null;
        if(x=="PAPEL"){
            ret = "[_]";
        }
         if(x=="TIJERA"){
             ret = "X";
         }
         if(x=="PIEDRA"){
             ret="O";
         }
         return ret;
    }
    public void clikeo(View view){

        switch(view.getId()) {

            case R.id.button7:

                Comparar(mano[pc.nextInt(max - min + 1) + min], "PIEDRA");

                break;
            case R.id.button8:
                Comparar(mano[pc.nextInt(max - min + 1) + min], "TIJERA");


                break;
            case R.id.button9:
               Comparar(mano[pc.nextInt(max - min + 1) + min], "PAPEL");

               break;



        }
        //temporizador
        new CountDownTimer(2500, 1000) {

            public void onTick(long millisUntilFinished) {
               // mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
               // mTextField.setText("done!");
                bt.setText("   ");

            }
        }.start();
        //termina temporizador
        ganados.setText(String.valueOf(contaganes));
        perdidos.setText(String.valueOf(contaperdido));
        empates.setText(String.valueOf(empa));
    }

    public  void Comparar(String ingreso1, String ingreso2){
        bt.setText(generaricono(ingreso1));

        if(ingreso1 == ingreso2){
            Toast.makeText(this, "EMPATE", Toast.LENGTH_SHORT).show();
            empa++;
        }else if((ingreso1=="TIJERA" && ingreso2=="PAPEL")|(ingreso1=="PIEDRA" && ingreso2=="TIJERA")|(ingreso1=="PAPEL" && ingreso2=="PIEDRA")){

            //GANADOR 1

            Toast.makeText(this, "GANA PC", Toast.LENGTH_SHORT).show();
                contaperdido++;
        }else {
            //GANADOR 2

            Toast.makeText(this, "GANA USTED", Toast.LENGTH_SHORT).show();
            contaganes++;
        }


    }
}
