package com.example.basketballscore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.basketballscore.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {
    private ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score);

        // Obtener Datos
        Intent intent = getIntent();

        String NombreEquipoA = intent.getStringExtra("NombreEquipoA");
        String NombreEquipoB = intent.getStringExtra("NombreEquipoB");

        int PuntosA = intent.getIntExtra("PuntosA", 0);
        int PuntosB = intent.getIntExtra("PuntosB", 0);

        // Mostrar resultados
        binding.equipoNombreA.setText(NombreEquipoA);
        binding.equipoNombreB.setText(NombreEquipoB);
        binding.tvLocalScore.setText(String.valueOf(PuntosA));
        binding.tvVisitorScore.setText(String.valueOf(PuntosB));


        // Ver resultado y declarar ganador
        String Ganador;

            if (PuntosA > PuntosB) {
            Ganador = NombreEquipoA;
        } else if (PuntosB > PuntosA) {
            Ganador = NombreEquipoB;
        } else {
            Ganador = "Empate";
        }

        // Imprimir Ganador
        binding.GANADOR.setText(Ganador);

        // Funcion boton retroceder

        binding.Retroceder.setOnClickListener(v -> {
            // finish retrocede a la activity anterior
            finish();
        });

    }
}