package bottom.navigation.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BottomNavigationViewActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.action_home:
                        HomeFragment homeFragment= new HomeFragment();
                        setFragment(homeFragment);
                        toolbar.setTitle("Home");
                        break;
                    case R.id.action_email:
                        EmailFragment emailFragment= new EmailFragment();
                        setFragment(emailFragment);
                        toolbar.setTitle("Email");
                        break;
                    case R.id.action_note:
                        NoteFragment noteFragment= new NoteFragment();
                        setFragment(noteFragment);
                        toolbar.setTitle("Note");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        if (savedInstanceState == null)
        {
            /**If implementing screen rotation only this check have to be implemented*/
            /**Starting fragment
             * if its not given its just shows a blank page because none of the fragments selected*/
            setFragment(new HomeFragment());
            toolbar.setTitle("Home");
        }
    }

    //*************** set fragment method ****************
    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //****** end ****************

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_english:
                Toast.makeText(getApplicationContext(), "English", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_hindi:
                Toast.makeText(getApplicationContext(), "Hindi", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_spanish:
                Toast.makeText(getApplicationContext(), "Spanish", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if (bottomNavigationView.getSelectedItemId() != R.id.action_home)
        {
            bottomNavigationView.setSelectedItemId(R.id.action_home);
        }
        else
        {
            super.onBackPressed();
        }
    }
}
