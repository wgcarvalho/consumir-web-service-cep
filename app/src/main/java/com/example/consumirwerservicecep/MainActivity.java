package com.example.consumirwerservicecep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.consumirwerservicecep.controle.HttpService;
import com.example.consumirwerservicecep.modelo.CEP;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private Button btnBuscaCEP;
    private EditText edtCEP;
    private TextView tviewResposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        eventoBtn();
    }

    private void eventoBtn() {
        //configuração do(s) evento(s) possivel(is) no botão da tela
        btnBuscaCEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buscar CEP

                try {
                    CEP retorno = new HttpService(edtCEP.getText().toString()).execute().get();
                    tviewResposta.setText(retorno.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void inicializarComponentes() {
        //carrega os componentes da tela
        btnBuscaCEP = (Button)findViewById(R.id.btnMain_buscarCep);
        edtCEP = (EditText)findViewById(R.id.etMain_cep);
        tviewResposta = (TextView)findViewById(R.id.etMain_resposta);
    }

}
