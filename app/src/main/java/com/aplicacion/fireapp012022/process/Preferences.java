package com.aplicacion.fireapp012022.process;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences
{
    private String PersistentFile = "InfoFile";
    private String nombre;
    private String password;


    public Preferences() {
        this.nombre = "";
        this.password = "";
    }

    public Preferences(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Load Info
    public void LoadPreferences(Context context)
    {
        SharedPreferences info = context.getSharedPreferences(PersistentFile, Context.MODE_PRIVATE);
        this.nombre = info.getString("Nombre", "No configurado");
        this.password = info.getString("Password", "No configurado");
    }

    public void SavePreferences(Context context, String nombre, String password)
    {
        SharedPreferences info = context.getSharedPreferences(PersistentFile, Context.MODE_PRIVATE);
        this.nombre = nombre;
        this.password = password;
        SharedPreferences.Editor editor = info.edit();
        editor.putString("Nombre", this.nombre);
        editor.putString("Password", this.password);
        editor.commit();
    }


}
