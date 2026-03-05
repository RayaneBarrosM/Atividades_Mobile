package br.gov.sp.cps.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo de vida", "T1-onCreate");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.i("Ciclo de vida", "T1-onResume");

    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i("Ciclo de vida", "T1-onStart");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "T1-onStop");

    }

    @Override
    public  void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida", "T1-onRestart");

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida", "T1-onDestroy");

    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i("Ciclo de vida", "T1-onPause");

    }
}