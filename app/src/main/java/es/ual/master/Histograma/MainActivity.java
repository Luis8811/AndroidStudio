package es.ual.master.Histograma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
   static {
       System.loadLibrary("native-lib");
   }
    int h[]=new int[256]; //array con el histograma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonCalculate = (Button) findViewById(R.id.button);
        Button buttonClose = (Button) findViewById(R.id.button2);
        //Mostrar cálculo del histograma al hacer click en el botón correspondiente
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.sample_text);
                int tam = 10000000;
                short imagen[] = new short[tam];
                double tiempo;
                for (int i=0; i<256; i++) h[i]=0;
                for (int i=0; i<tam; i++) imagen[i]=(short)(i%256);
                tiempo=histograma(tam,imagen);
                String stringtiempo = String.valueOf(tiempo);
                tv.setText("Valor de histograma: "+ stringtiempo +" seg.");
            }
        });

        //"Cerrar" la aplicación al hacer click en el botón correspondiente
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    public double histograma(int tam, short [] imagen){
        double tiempoInicio = System.nanoTime();

        for (int i=0; i<tam; i++) h[imagen[i]]++;
        return (System.nanoTime()-tiempoInicio)/ 1000000000.0;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    /* Paso 1: Declara la nueva función histogramaC*/
}
