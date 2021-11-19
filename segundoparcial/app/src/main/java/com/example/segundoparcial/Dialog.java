package com.example.segundoparcial;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialog extends DialogFragment {

    String rol;
    String username;

    public Dialog(String rol , String username) {

        this.rol = rol;
        this.username = username;
    }

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstance){


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        ListenerClick click = new ListenerClick();

        if (rol != null){
            builder.setTitle("Usuario encontrado");
            builder.setMessage("El rol del usuario es " + rol);
            builder.setPositiveButton("CERRAR",click);
        }else {
            builder.setTitle("Usuario no encontrado");
            builder.setMessage("El usuario " + username + " no esta dentro de la lista");
            builder.setPositiveButton("CERRAR",click);
        }


        return builder.create();

    }
}
