package com.example.doris.piedra_papel_tijera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
String Jugador ="n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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


    public void callJuego(View view) {
        Intent i = new Intent(this, NuevoJugador.class);

        //invocando una actividad que va a devolver como resultado el nombre del jugador
        startActivityForResult(i,1);

    }


    //metodo para controlar el resultado que devuelve una actividad
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 & resultCode==this.RESULT_OK)
            Jugador= data.getExtras().getString("respuesta");
        if(Jugador.equals("n"))
            finish();
    }

    public void iniciarJuego(View view) {
        Intent i = new Intent(this, IniciarJuego.class);

        //pasando el nombre del jugador a la actividad
        i.putExtra("jugador",Jugador);

        startActivity(i);
    }

    public void puntaje(View view) {
        Intent i = new Intent(this, Puntajes.class);
        startActivity(i);

    }


}

