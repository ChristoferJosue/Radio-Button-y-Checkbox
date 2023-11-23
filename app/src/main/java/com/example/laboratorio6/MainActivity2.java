package com.example.laboratorio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView TvRespuesta;

    private EditText Etnumero1,Etnumero2;
    private RadioButton RbSuma,RbRestar,RbMultiplicar,RbDividir;
    private Button BtnCalcular,BtnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //obteniendo el valor de los controles
        Etnumero1=(EditText) findViewById(R.id.EtNumero1);
        Etnumero2=(EditText) findViewById(R.id.EtNumero2);
        TvRespuesta=(TextView) findViewById(R.id.TvRespuesta);
        RbSuma=(RadioButton) findViewById(R.id.RbSumar);
        RbDividir=(RadioButton) findViewById(R.id.RbDividir);
        RbRestar=(RadioButton) findViewById(R.id.RbRestar);
        RbMultiplicar=(RadioButton) findViewById(R.id.RbMultiplicar);
        BtnCalcular=(Button) findViewById(R.id.BtnCalcular2);
        BtnRegresar=(Button) findViewById(R.id.BtnRegresar);
        RbMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RbMultiplicar.isChecked())//si este se activa o hace click desactivar los otros
                {
                    RbSuma.setChecked(false);
                    RbRestar.setChecked(false);
                    RbDividir.setChecked(false);
                }
            }
        });
        RbSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RbSuma.isChecked())//si este se activa o hace click desactivar los otros
                {
                    RbMultiplicar.setChecked(false);
                    RbRestar.setChecked(false);
                    RbDividir.setChecked(false);
                }
            }
        });
        RbRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RbRestar.isChecked())//si este se activa o hace click desactivar los otros
                {
                    RbSuma.setChecked(false);
                    RbMultiplicar.setChecked(false);
                    RbDividir.setChecked(false);
                }
            }
        });
        RbDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RbDividir.isChecked())//si este se activa o hace click desactivar los otros
                {
                    RbSuma.setChecked(false);
                    RbRestar.setChecked(false);
                    RbMultiplicar.setChecked(false);
                }
            }
        });


        BtnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valor1,valor2;
                String valor1Str,valor2Str;
                valor1Str=Etnumero1.getText().toString();
                valor2Str=Etnumero2.getText().toString();
                if(!valor1Str.isEmpty() && !valor2Str.isEmpty())//sino esta vacio
                {
                   valor1= new Double(Etnumero1.getText().toString());
                   valor2= new Double(Etnumero2.getText().toString());
                    if (RbSuma.isChecked() == true) { // utiliza tus id y variables creadas. Recuerda crear el evento onclick del botón

                        double suma = valor1 + valor2;

                        String resultado = "La respuesta es: "+suma;

                        TvRespuesta.setText(resultado);

                    } else if (RbRestar.isChecked() == true) {

                        double resta = valor1 - valor2;

                        String resultado = "La respuesta es: "+resta;

                        TvRespuesta.setText(resultado);

                    } else if (RbMultiplicar.isChecked() == true) {
                        double multiplicacion= valor1*valor2;

                        String resultado = "La respuesta es: "+multiplicacion;
                        TvRespuesta.setText(resultado);

                    } else if (RbDividir.isChecked()==true) {
                        double division= valor1/valor2;
                        String resultado = "La respuesta es: "+division;
                        TvRespuesta.setText(resultado);
                    }
                    else {
                        Toast.makeText(MainActivity2.this, "Seleccione una opcion", Toast.LENGTH_SHORT).show();//si no esta elegido ninguno aparece este mensaje

                    }

                }
                else{
                    Toast.makeText(MainActivity2.this, "llene bien los campos", Toast.LENGTH_SHORT).show();//sino estan llenado bien los Edit texts

                }


            }
        });


        BtnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent packageContext;
                Intent Regreso1=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(Regreso1);
            }
        });


    }
}