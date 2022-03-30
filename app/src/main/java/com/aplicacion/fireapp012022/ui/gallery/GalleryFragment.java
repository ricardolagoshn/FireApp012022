package com.aplicacion.fireapp012022.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aplicacion.fireapp012022.R;

public class GalleryFragment extends Fragment {

    TextView texto;
    Button btnconsulta;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        texto = root.findViewById(R.id.text_gallery);
        btnconsulta = root.findViewById(R.id.button);


        btnconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("Hola como estas");
            }
        });


        return root;
    }
}