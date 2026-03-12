package br.gov.sp.cps.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selectPedra(View views){
        this.opcaoSelecionada("pedra");
    }

    public void slectPapel(View views){
        this.opcaoSelecionada("papel");
    }

    public void selectTesoura(View views){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){
        ImageView imgresultado = findViewById(R.id.padrao);
        TextView textResultado = findViewById(R.id.textResultado);

        //Logica
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoPC = opcoes[numero];


        //Muda a figura
        switch (opcaoPC){
            case "pedra":
                imgresultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgresultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgresultado.setImageResource(R.drawable.tesoura);
                break;
        }

        //Logica do Jogo - analise de quem ganhou ou perdeu
        if (
                (opcaoPC == "Tesoura" && opcaoSelecionada == "papel") ||
                (opcaoPC == "papel" && opcaoSelecionada == "pedra") ||
                (opcaoPC == "pedra" && opcaoSelecionada == "tesoura")
        ){
            textResultado.setText("Você é ruim! 💀");
        }else if (
                (opcaoSelecionada == "Tesoura" && opcaoPC == "papel") ||
                (opcaoSelecionada == "papel" && opcaoPC == "pedra") ||
                (opcaoSelecionada == "pedra" && opcaoPC == "tesoura")
        ){
            textResultado.setText("Parabéns, você ganhou!☺️");
        } else {
            textResultado.setText("Houve um empate!👯‍♂️️");

        }

    }
}

