package iesous.com.hpejemplos.libComponents;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by i5 on 05/02/2017.
 */

public class Components {

    public void notificacion(Context context, String mensaje){
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
    }
}
