package activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;

public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();
    public boolean isOnMenu;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isOnMenu = true;
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        MenuItem search = (MenuItem) findViewById(R.id.action_search);

        // display the first navigation drawer view on app launch
        displayView(0);


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//
//        return true;
//    }

    @Override
    public void onBackPressed() {
        if (isOnMenu == false) {
            Fragment fragment = new HomeFragment();
            String title = getString(R.string.title_home);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            setActTitle(title);
            isOnMenu = true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, about.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_search) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        isOnMenu = false;
        switch (position) {
            case 0:
                isOnMenu = true;
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new TariFragment();
                break;
            case 2:
                fragment = new SenjataFragment();
                title = getString(R.string.title_senjata);
                break;

            case 3:
                fragment = new PakaianFragment();
                title = getString(R.string.title_pakaian);
                break;

            case 4:
                fragment = new RumahFragment();
                title = getString(R.string.title_rumah);
                break;
            case 5:
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
                title = getString(R.string.title_about);
                break;

            case 6:
                Intent intent1 = new Intent(MainActivity.this, introscreen.class);
                startActivity(intent1);
                title = getString(R.string.title_intro);
                break;

            case 7:
                title = getString(R.string.title_exit);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Apakah Anda Yakin Ingin Keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                break;
            default:
                break;
        }


        if (fragment != null) {


            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            setActTitle(title);
        }
    }

    public void setActTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}