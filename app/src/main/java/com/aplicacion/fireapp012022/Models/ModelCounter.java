package com.aplicacion.fireapp012022.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ModelCounter  extends Observable
{
    private List<Integer> lista;

    // Constructor de clase


    public ModelCounter()
    {
        lista = new ArrayList<Integer>(4);
        lista.add(0);
        lista.add(0);
        lista.add(0);
        lista.add(0);

    }

    public int ObtenerValforIndex(final int indice)
    {
        try {
            return lista.get(indice);
        }
        catch (IndexOutOfBoundsException e)
        {
            return -1;
        }
    }

    public void SetValforIndex(final int indice) throws IndexOutOfBoundsException
    {

            lista.set(indice, lista.get(indice)+1);
            setChanged();
            notifyObservers();
    }

}
