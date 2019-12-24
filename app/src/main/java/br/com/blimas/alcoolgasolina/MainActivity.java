package br.com.blimas.alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcoolDigitado;
    private EditText precoGasolinaDigitado;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcoolDigitado = findViewById(R.id.valor_alcool);
        precoGasolinaDigitado = findViewById(R.id.valor_gasolina);
        resultado = findViewById(R.id.text_resultado);
    }



    public void calcularPreco(View view){

        //recupera valores digitados
        String precoAlcool = precoAlcoolDigitado.getText().toString();
        String precoGasolina = precoGasolinaDigitado.getText().toString();


        Boolean camposValidados = this.validaCampos(precoAlcool, precoGasolina);

            if (camposValidados){
                this.calcularPreco(precoAlcool, precoGasolina);
            }else{
                resultado.setText("Preencha os campos para calcular!");
            }

    }

    public Boolean validaCampos(String precoAlcool, String precoGasolina){
        Boolean camposValidados = true;
            //validar campos
            if(precoAlcool == null || precoAlcool.equals("")){
                camposValidados = false;
            }else if (precoGasolina == null || precoGasolina.equals("")){
                camposValidados = false;
            }
        return camposValidados;
    }


    public void calcularPreco(String precoAlcool, String precoGasolina){
        //converter valores string para numeros
        Double alcool = Double.parseDouble(precoAlcool);
        Double gasolina = Double.parseDouble(precoGasolina);

        //Calcula o melhor preco do combustivel para abastecimento
        Double calculo = alcool/gasolina;

        if(calculo >= 0.7){
            resultado.setText("Melhor utilizar Gasolina!");
        }else{
            resultado.setText("Melhor utilizar Alcool!");
        }

    }
}
