package iesous.com.hpejemplos.MostrarIntent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import iesous.com.hpejemplos.R;

public class Main2Activity extends AppCompatActivity {

    TextView tvTitle;
    String cadena = "No seleccionaste una opción";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Obteniendo la instancia del TextView
        tvTitle = (TextView) findViewById(R.id.tv_title);
        //Obteniendo la instancia del Intent
        Intent intent = getIntent();
        //Extrayendo el extra de tipo cadena
        String title = intent.getStringExtra(EjemploIntent.EXTRA_CADENA);
        //Seteando el valor del extra en el TextView
        tvTitle.setText(title);

        //Obtenemos la instancia del radioGroup
        final RadioGroup opinionResult = (RadioGroup) findViewById(R.id.opiniones);

        //Agreamos en evento a nuestro boton
        //para regresar una cadena
        Button btnReturnString = (Button) findViewById(R.id.button3);
        btnReturnString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Obtener del radiobutton seleccionado actualmente
                    //RadioButton btnRadioResponse = (RadioButton) findViewById(opinionResult.getCheckedRadioButtonId());
                    //Obtener la cadena del radiobutton
                    //String opinion = btnRadioResponse.getText().toString();
                    //Crear un nuevo intent de respuesta
                    Intent dataBack = new Intent();
                    //Añadir como Extra el texto del radiobutton
                    dataBack.putExtra("opinion", cadena);
                    //Devolver por el canal de forma exitosa el mensaje del intent
                    setResult(RESULT_OK, dataBack);
                    //Terminar la actividad
                    finish();

                /*La primera instrucción obtiene una instancia del RadioButton actualmente seleccionado.
                Para ello usamos como parámetro la instancia obtenida a través el
                RadioGroup(obtenida en onCreate() previamente) por el método getCheckedRadioButtonId().
                Este método nos proporciona el id del radio seleccionado.

                Luego obtenemos el valor del atributo text del radio con getText().

                Es necesario enviar un mensaje de vuelta, por lo que creamos una instancia de un Intent vacío.

                Añadiremos como Extra el texto del radio.
                En esta instrucción usamos el método setResult() para enviar el resultado de forma exitosa.
                El primer parámetro es la constante RESULT_OK de la clase Activity que indica que
                todo ha salido bien y el segundo parámetro es nuestro Intent portador del mensaje.

                Finalizamos la actividad Visor con el método finish() de la clase Actitivy.*/
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    // Pirates are the best
                    cadena = "Hoy te sientes: " + ((RadioButton) view).getText().toString();
                    break;
            case R.id.radioButton2:
                if (checked)
                    // Ninjas rule
                    cadena = "Hoy te sientes: " + ((RadioButton) view).getText().toString();
                    break;
            case R.id.radioButton3:
                if (checked)
                    // Ninjas rule
                    cadena = "Hoy te sientes: " + ((RadioButton) view).getText().toString();
                    break;
        }
    }



    public void goWeb(View view){
        Uri webpage = Uri.parse("https://twitter.com/iesous_flor?lang=ca");
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
}
