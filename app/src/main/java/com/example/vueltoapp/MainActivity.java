package com.example.vueltoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.Format;

public class MainActivity extends AppCompatActivity {
    EditText txtMonto,txtPrecio;
    Button btnCalcular;
    TextView txtresultado;
    Format format = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMonto = findViewById(R.id.txtMonto);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtresultado = findViewById(R.id.resultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cacularTotal(Double.parseDouble(txtMonto.getText().toString()) ,Double.parseDouble(txtPrecio.getText().toString()));
            }
        });


    }

    private void cacularTotal(double monto, double precio) {
        if (monto>precio){
            double resultado = monto-precio;
            txtresultado.setText("El vuelto es $"+String.valueOf(format.format(resultado)));

        }else {
            Toast.makeText(getApplicationContext(),"El efectivo no debe de ser mayor que el monto",Toast.LENGTH_LONG).show();
        }

    }
}
