package iesous.com.hpejemplos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import iesous.com.hpejemplos.libComponents.Components;

import iesous.com.hpejemplos.MostrarIntent.EjemploIntent;

public class MainActivity extends AppCompatActivity {

    Components libComponents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libComponents = new Components();
    }

    public void setIntent(View view){
        libComponents.notificacion(getApplicationContext(), "Esto es toast en libComponents");
        //Intent intent = new Intent(this, EjemploIntent.class);
        //startActivity(intent);
    }
}
