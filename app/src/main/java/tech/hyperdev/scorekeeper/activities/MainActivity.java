package tech.hyperdev.scorekeeper.activities;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {
    int styleId = R.style.AppTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            styleId = savedInstanceState.getInt("Theme");
        }
        setTheme(styleId);
        setContentView(R.layout.activity_main);



        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ScoreFragment firstTeam = new ScoreFragment("Team 1", 0);
            ScoreFragment secondTeam = new ScoreFragment("Team 2", 0);
            fragmentTransaction.add(R.id.fragment_container, firstTeam, "First Team");
            fragmentTransaction.add(R.id.fragment2_container, secondTeam, "Second Team");
            fragmentTransaction.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Theme", styleId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.dayMode:
                styleId = R.style.AppTheme;
                recreate();
                break;
            case R.id.nightMode:
                styleId = R.style.AppTheme_Night;
                recreate();
                break;
        }
        return true;

    }
}
