package com.example.segundoparcial;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionHTTP {

    public byte[] obtenerRespuesta(String urlString){
        try {

            URL url = new URL(urlString);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            int respuesta = urlConnection.getResponseCode();

            Log.d("Conexion" , "Respuesta del servidor " + respuesta);

            if (respuesta == 200){

                InputStream is = urlConnection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int cant = 0;

                while ((cant = is.read(buffer)) != -1){

                    baos.write(buffer , 0 , cant);

                }

                is.close();
                return baos.toByteArray();

            }else {
                throw new RuntimeException("Error " + respuesta);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        } catch (IOException e) {

            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }
}
