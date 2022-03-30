package com.aplicacion.fireapp012022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre, txtemail, txtpassword;
    Button btnregistrar;

    FirebaseAuth autenticacion;
    DatabaseReference BaseDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autenticacion = FirebaseAuth.getInstance();
        BaseDatos = FirebaseDatabase.getInstance().getReference();

        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        btnregistrar = (Button) findViewById(R.id.btnregistrar);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(!txtnombre.getText().toString().isEmpty() &&
                        !txtemail.getText().toString().isEmpty() &&
                        !txtpassword.getText().toString().isEmpty())
                {
                    AutenticacionFireBase();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Faltan campos", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void AutenticacionFireBase()
    {
        autenticacion.createUserWithEmailAndPassword(txtnombre.getText().toString(), txtpassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Map<String, String> map = new HashMap<>();
                    map.put("nombre", txtnombre.getText().toString());
                    map.put("email", txtemail.getText().toString());
                    map.put("password", txtpassword.getText().toString());

                    String id = autenticacion.getCurrentUser().getUid();

                    BaseDatos.child("USUARIOS").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> taskb) {

                            if(taskb.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(), "Adicionado con exito", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }
}