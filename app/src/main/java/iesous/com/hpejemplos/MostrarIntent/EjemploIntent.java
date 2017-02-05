package iesous.com.hpejemplos.MostrarIntent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import iesous.com.hpejemplos.R;

public class EjemploIntent extends AppCompatActivity {

    public final static String EXTRA_CADENA = "iesous.com.hpejemplos.MostrarIntent";

    //Codigo de envío
    public final static int OPINION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_intent);
    }

    public void startActivity2(View view){
        //Iniciando la actividad
        Intent intent = new Intent(this, Main2Activity.class);
        //adhesion de nuestra cadena
        intent.putExtra(EXTRA_CADENA, "Por favor contexta sinceramente");
        //startActivity(intent);
        //Iniciando una actividad esperando una respuesta
        startActivityForResult(intent, OPINION_REQUEST_CODE);
    }

    public void goTutorialWeb(View view){
        Uri webpage = Uri.parse("http://www.hermosaprogramacion.com/2014/09/desarrollo-android-intents/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        // Verificar si hay aplicaciones disponibles
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(webIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

// Si hay, entonces ejecutamos la actividad
        if (isIntentSafe) {
            startActivity(webIntent);
        }
    }

    //Con este metodo recibiremos la respuesta
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == OPINION_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra("opinion");
                final TextView tvResult = (TextView) findViewById(R.id.textView4);
                tvResult.setText(result);
            }
        }
    }
}
