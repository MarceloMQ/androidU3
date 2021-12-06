package com.mmadariaga.pruebau3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    private TextView txt1, txt2, txt3, txt4, txt5, txt6;
    private Button btn1,btn2;
    private EditText etedit1;
    private DatabaseReference database;
    private DatabaseReference dbReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt5 = (TextView) findViewById(R.id.txt5);
        txt6 = (TextView) findViewById(R.id.txt6);
        btn1 = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btnEdit);
        etedit1 = (EditText) findViewById(R.id.edit1);
        database = FirebaseDatabase.getInstance().getReference();


        database.child("Sensores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String nombre = dataSnapshot.child("nombre").getValue().toString();
                    txt1.setText("Nombre del sensor: " + nombre);

                    String Fecha = dataSnapshot.child("Fecha").getValue().toString();
                    txt2.setText("Fecha y Hora: " + Fecha);

                    String Tipo = dataSnapshot.child("Tipo").getValue().toString();
                    txt3.setText("Tipo de sensor: " + Tipo);

                    String Valor = dataSnapshot.child("Valor").getValue().toString();
                    txt4.setText("Valor : " + Valor);

                    String Ubicacion= dataSnapshot.child("Ubicacion").getValue().toString();
                    txt5.setText("Tipo de sensor: " + Ubicacion);

                    String Observacion = dataSnapshot.child("Observacion").getValue().toString();
                    txt6.setText("Observación del sensor: " + Observacion);

                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                            startActivity(intent);
                        }


                    });
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Observacion = txt6.getText().toString();
                            txt6.setText(etedit1.getText().toString());


                            }






                    });


                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

