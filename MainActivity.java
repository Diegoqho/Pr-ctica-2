package com.example.practica;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Declaramos las variables que vamos a usar
    private EditText datoA, datoB, datoC, datoX1, datoX2, datoY1, datoY2;
    private TextView datoX, datoM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignamos a nuestras variables lo que los EditText contengan
        datoA = findViewById(R.id.txtA);
        datoB = findViewById(R.id.txtB);
        datoC = findViewById(R.id.txtC);
        datoX1 = findViewById(R.id.txtX1);
        datoX2 = findViewById(R.id.txtX2);
        datoY1 = findViewById(R.id.txtY1);
        datoY2 = findViewById(R.id.txtY2);
        datoX = findViewById(R.id.txtX);
        datoM = findViewById(R.id.txtM);
    }

    //Creamos la función para calcular la Fórmula General
    public void fGeneral(View v) {
        //Creamos variables de tipo double y asignamos valores para poder trabajar con ellos
        double a = Double.parseDouble(datoA.getText().toString());
        double b = Double.parseDouble(datoB.getText().toString());
        double c = Double.parseDouble(datoC.getText().toString());
        double x1, x2, disc;
        //Calculamos el discriminante para especificar casos
        disc = (b*b)-4*a*c;
        //Con una sentencia IF especificamos los casos
        if (disc>0){ //CASO 1: dos resultados en los números reales
            x1 = (-1 * b + Math.sqrt(disc))/(2*a); //Primer resultado
            x2 = (-1 * b - Math.sqrt(disc))/(2*a); //Segundo resultado
            //Asignamos al TextView nuestros resultados
            datoX.setText("X1 = " + Math.round(x1) + System.lineSeparator() + "X2 = " + Math.round(x2));
            Toast.makeText(this, "Caso 1", Toast.LENGTH_LONG).show(); //Mensaje en pantalla
        } else if (disc == 0){ //CASO 2: un solo resultado en los números reales
            x1 = (-1 * b)/(2*a); //Cálculo del resultado
            //Asignamos al TextView el resultado
            datoX.setText("X = " + Math.round(x1));
            Toast.makeText(this, "Caso 2", Toast.LENGTH_LONG).show(); //Mensaje en pantalla
        } else if (disc<0){ //CASO 3: resultado en los números imaginarios
            //Asignamos al TextView la respuesta a este caso
            datoX.setText("Resultado imaginario");
            Toast.makeText(this, "Caso 3", Toast.LENGTH_LONG).show(); //Mensaje en pantalla
        } else Toast.makeText(this, "Error inesperado", Toast.LENGTH_LONG).show(); //Mensaje en pantalla
    }

    public void pendiente(View v) {
        //Creamos variables de tipo double y asignamos valores para poder trabajar con ellos
        double x1 = Double.parseDouble(datoX1.getText().toString());
        double x2 = Double.parseDouble(datoX2.getText().toString());
        double y1 = Double.parseDouble(datoY1.getText().toString());
        double y2 = Double.parseDouble(datoY2.getText().toString());
        double m;
        //Cálculo de la pendiente
        m = (y2 - y1)/(x2 - x1);
        //Con una sentencia IF especificamos los casos
        if (m > 0){ //CASO 1: es una función creciente
            //Asignamos al TextView el resultado
            datoM.setText("m = " + Math.round(m) + System.lineSeparator() + "Agudo");
            Toast.makeText(this, "Función creciente", Toast.LENGTH_LONG).show(); //Mensaje en pantalla
        } else if (m < 0){ //CASO 2: es una función decreciente
            //Asignamos al TextView el resultado
            datoM.setText("m = " + Math.round(m) + System.lineSeparator() + "Obtuso");
            Toast.makeText(this, "Función decreciente", Toast.LENGTH_LONG).show(); //Mensaje en pantalla
        } else if (m == 0){ //CASO 3: no hay pentiente
            //Asignamos al TextView el resultado
            datoM.setText((int) Math.round(m));
            Toast.makeText(this, "Sin pendiente", Toast.LENGTH_LONG).show(); //Mensaje en pantalla
        } else Toast.makeText(this, "Error inesperado", Toast.LENGTH_LONG).show(); //Mensaje en pantalla
    }
}