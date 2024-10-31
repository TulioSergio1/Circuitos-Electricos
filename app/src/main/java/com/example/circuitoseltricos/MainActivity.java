package com.example.circuitoseltricos;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontStyle;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.circuitoseltricos.databinding.ActivityMainBinding;
import com.example.circuitoseltricos.fragmentos.HomeFragment;
import com.example.circuitoseltricos.fragmentos.ProfileFragment;
import com.example.circuitoseltricos.fragmentos.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        substituirFragment(new HomeFragment());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.bottomNavigationView.setOnItemSelectedListener(menuItem -> {

            final int homeId = R.id.home;
            final int profileId = R.id.profile;
            final int settingsId = R.id.settings;

            if (menuItem.getItemId() == homeId) {
                substituirFragment(new HomeFragment());
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