package com.example.basketballscore;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private int PuntosA = 0;
    private int PuntosB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //Botones equipo A
        //Funcion boton +1 Equipo Local

        binding.MASUNO.setOnClickListener(v -> {
            PuntosA += 1;
            binding.tvLocalScore.setText(String.valueOf(PuntosA));
        });

        //Funcion boton +2 Equipo Local

        binding.MASDOS.setOnClickListener(v -> {
            PuntosA += 2;
            binding.tvLocalScore.setText(String.valueOf(PuntosA));
        });

        //Funcion boton +3 Equipo Local

        binding.MASTRES.setOnClickListener(v -> {
            PuntosA += 3;
            binding.tvLocalScore.setText(String.valueOf(PuntosA));
        });

        //Funcion boton -1 Equipo Local

        binding.MENOSUNO.setOnClickListener(v -> {
            PuntosA -= 1;
            if (PuntosA < 0) PuntosA = 0; // evita números negativos
            binding.tvLocalScore.setText(String.valueOf(PuntosA));
        });

        //Botones equipo B
        //Funcion boton +1 Equipo Visitante

        binding.MASUNO2.setOnClickListener(v -> {
            PuntosB += 1;
            binding.tvVisitorScore.setText(String.valueOf(PuntosB));
        });

        //Funcion boton +2 Equipo Visitante

        binding.MASDOS2.setOnClickListener(v -> {
            PuntosB += 2;
            binding.tvVisitorScore.setText(String.valueOf(PuntosB));
        });

        //Funcion boton +3 Equipo Visitante

        binding.MASTRES2.setOnClickListener(v -> {
            PuntosB += 3;
            binding.tvVisitorScore.setText(String.valueOf(PuntosB));
        });

        //Funcion boton -1 Equipo Visitante

        binding.MENOSUNO2.setOnClickListener(v -> {
            PuntosB -= 1;
            if (PuntosB < 0) PuntosB = 0; // evita números negativos
            binding.tvVisitorScore.setText(String.valueOf(PuntosB));
        });

        // Funcion Boton Resultado a nuevo activity

        binding.VerResultado.setOnClickListener(v -> {
           Intent intent = new Intent(MainActivity.this, ScoreActivity.class);

            // Pasamos los nombres de los equipos

            String NombreA = binding.EquipoNombreA.getText().toString();
            String NombreB = binding.EquipoNombreB.getText().toString();

            intent.putExtra("NombreEquipoA", NombreA);
            intent.putExtra("NombreEquipoB", NombreB);

            // Pasamos los puntos

            intent.putExtra("PuntosA", PuntosA);
            intent.putExtra("PuntosB", PuntosB);

            startActivity(intent);
        });
    }
}