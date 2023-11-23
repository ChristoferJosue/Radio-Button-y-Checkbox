package com.example.laboratorio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtBanana, txtManzana, txtNaranja, txtPera;
    private Button btnSiguiente, btnCalcular;// declaro mis objetos a trabajar en el programa
    private ImageButton btnSalir;
    private TextView tvRespuesta;
    private CheckBox checkM,checkP,checkB,checkN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBanana=(EditText) findViewById(R.id.EtBanana); // capturo mis objetos con el id colocado en el diseño
        txtManzana=(EditText) findViewById(R.id.EtManzana);
        txtNaranja=(EditText) findViewById(R.id.EtNaranja);
        txtPera=(EditText) findViewById(R.id.EtPera);
        checkM=(CheckBox) findViewById(R.id.CbManzana);
        checkP=(CheckBox) findViewById(R.id.CbPera);
        checkN=(CheckBox) findViewById(R.id.CbNaranja);
        checkB=(CheckBox) findViewById(R.id.CbBanana);
        tvRespuesta=(TextView) findViewById(R.id.TvTotal);
        btnSiguiente=(Button) findViewById(R.id.BtnSiguiente);
        btnCalcular=(Button) findViewById(R.id.BtnCalcular);

        btnSalir=(ImageButton)findViewById(R.id.btnSalir) ;

        btnSalir.setOnClickListener(new View.OnClickListener() {//finaliza todas las actividades
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {//al presionar el boton siguiente abre la otra actividad
            @Override
            public void onClick(View v) {
                Intent packageContext;
                Intent Siguiente1=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(Siguiente1);
            }
        });

        btnCalcular.setOnClickListener( new View.OnClickListener() { // evento click del botón
            @Override
            public void onClick(View v) {



                double total=0;
                String Resultado = "";
                if (checkB.isChecked()== true){ // validar si los checkbox estan seleccionados
                    String cantidadBStr=txtBanana.getText().toString();//creamos una variable de cadena para luego compararla
                    if(!cantidadBStr.isEmpty()){//si no esta vacio puedes correrlo ya que EditText vacios pueden hacer que se muera la app
                        int cantidadB= new Integer(txtBanana.getText().toString());//ahora como no está vacio si puedes asignarle un numero entero a la variable
                        double banana= 0.30;//0.30 es el precio de la banana
                        double totalbanana= banana * cantidadB;
                        total=total+totalbanana;//usando una variable acumulador para todos y luego poder ejecutarla al finalizar las instancias if

                    }
                    else{
                        Toast.makeText(MainActivity.this, "Ingrese un número válido para Banana", Toast.LENGTH_SHORT).show();


                    }


                }
                if (checkM.isChecked()== true){//si esta seleccionado el radio button ejecuta

                    double manzana= 0.40;

                    String cantidadMStr=txtManzana.getText().toString();//creamos una variable de cadena para luego compararla
                    if(!cantidadMStr.isEmpty())//sino esta vacio entonces puede tomnar el valor numerico
                    {
                        int cantidadM= new Integer(txtManzana.getText().toString());//ahora como no está vacio si puedes asignarle un numero entero a la variable
                        double totalmanzana= manzana * cantidadM;
                        total=total+totalmanzana;//usando una variable acumulador para todos y luego poder ejecutarla al finalizar las instancias if
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Ingrese un número válido para Manzana", Toast.LENGTH_SHORT).show();

                    }


                }
                if (checkN.isChecked()== true){//si esta seleccionado el radio button ejecuta
                    double naranja= 0.50;
                    String cantidadNStr=txtNaranja.getText().toString();//creamos una variable de cadena para luego compararla
                    if(!cantidadNStr.isEmpty()){//ahora como no está vacio si puedes asignarle un numero entero a la variable
                        int cantidadN= new Integer(txtNaranja.getText().toString());//ahora como no está vacio si puedes asignarle un numero entero a la variable
                        double totalnaranja= naranja * cantidadN;
                        total=total+totalnaranja;//usando una variable acumulador para todos y luego poder ejecutarla al finalizar las instancias if

                    }
                    else{
                        Toast.makeText(MainActivity.this, "Ingrese un número válido para Naranja", Toast.LENGTH_SHORT).show();


                    }


                }
                if (checkP.isChecked()== true){ //si esta seleccionado el radio button ejecuta
                    double pera= 0.30;
                    String cantidadPStr=txtPera.getText().toString();//creamos una variable de cadena para luego compararla
                    if(!cantidadPStr.isEmpty()){//ahora como no está vacio si puedes asignarle un numero entero a la variable
                        int cantidadP= new Integer(txtPera.getText().toString());//ahora como no está vacio si puedes asignarle un numero entero a la variable
                        double totalpera= pera * cantidadP;
                        total=total+totalpera;//usando una variable acumulador para todos y luego poder ejecutarla al finalizar las instancias if

                    }
                    else{
                        Toast.makeText(MainActivity.this, "Ingrese un número válido para Pera", Toast.LENGTH_SHORT).show();


                    }



                }
                Resultado= "El total a pagar son:   " + total +"$";
                tvRespuesta.setText(Resultado);
            }
        } );
    }
}
