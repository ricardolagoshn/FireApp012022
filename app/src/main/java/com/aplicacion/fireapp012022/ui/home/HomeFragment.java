package com.aplicacion.fireapp012022.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aplicacion.fireapp012022.R;
import com.aplicacion.fireapp012022.process.Preferences;

public class HomeFragment extends Fragment {

    EditText usuario, password;
    Button btncargar, btnsalvar;
    Preferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        usuario = root.findViewById(R.id.txtuser);
        password = root.findViewById(R.id.txtclave);

        btncargar = root.findViewById(R.id.btnload);
        btnsalvar = root.findViewById(R.id.btnsave);

        btncargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CargarInfo();
            }
        });


        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SalvarInfo();
            }
        });

        preferences = new Preferences();
        preferences.LoadPreferences(getContext());

        CargarInfo();

        return root;
    }

    private void SalvarInfo()
    {
        preferences.SavePreferences(getContext(), usuario.getText().toString(), password.getText().toString());
        Toast.makeText(getContext(),"Datos Salvados",Toast.LENGTH_LONG).show();
    }

    private void CargarInfo()
    {
        try {
            usuario.setText(preferences.getNombre());
            password.setText(preferences.getPassword());
        }
        catch (Exception e)
        {
            e.toString();
        }
    }
}