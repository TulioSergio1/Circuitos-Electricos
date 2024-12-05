package com.example.circuitoseltricos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.circuitoseltricos.databinding.ActivityMainBinding;
import com.example.circuitoseltricos.fragmentos.SistemaEletrico;
import com.example.circuitoseltricos.fragmentos.ProfileFragment;
import com.example.circuitoseltricos.fragmentos.SettingsFragment;
import com.example.circuitoseltricos.fragmentos.InstalacoesSolaresFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        substituirFragment(new SistemaEletrico());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, 0, systemBars.right, 0);
            return insets;
        });

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Limpar todos os dados armazenados
        editor.clear();
        editor.apply();

        binding.bottomNavigationView.setOnItemSelectedListener(menuItem -> {

            final int homeId = R.id.home;
            final int profileId = R.id.profile;
            final int settingsId = R.id.settings;

            if (menuItem.getItemId() == homeId) {
                substituirFragment(new SistemaEletrico());
            }
            if(menuItem.getItemId() == profileId){
                substituirFragment(new ProfileFragment());
            }
            if (menuItem.getItemId() == settingsId){
                substituirFragment(new SettingsFragment());
            }

            return true; // Retorne true para indicar que o evento foi tratado
        });

    }

    private void substituirFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }
}