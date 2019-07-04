package com.example.consumirwerservicecep.controle;

import android.os.AsyncTask;

import com.example.consumirwerservicecep.modelo.CEP;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void, Void, String> {

  //  private String cep;

    @Override
    protected String doInBackground(Void... voids) {
        // realizar requisição e consumir o serviço

        StringBuilder resposta = new StringBuilder();

       // if (this.cep != null && this.cep.length() == 8) {
            try {
                URL url = new URL("https://agendamotoristas-7c4a5.firebaseio.com/motorista/05e5322e-dc0c-452d-9e8b-2abb02f1c319/nome.json");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
       // }

        return new Gson().fromJson(resposta.toString(), String.class);
    }

    public HttpService() {
        
    }
}
