package activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.PakaianAdapter;
import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;
import model.Pakaian;

public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener, PakaianAdapter.IPakaianAdapter {

    private static String TAG = MainActivity.class.getSimpleName();
    public boolean isOnMenu;
    ArrayList<Pakaian> mList = new ArrayList<>();
    ArrayList<Pakaian> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;
    PakaianAdapter mAdapter;
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


        // display the first navigation drawer view on app launch
        displayView(0);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQuery = newText.toLowerCase();
                doFilter(mQuery);
                return true;
            }
        });

        return true;
    }

    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;
        }
        mList.clear();
        if (query == null || query.isEmpty()) {
            mList.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Pakaian pakaian = mListAll.get(i);
                if (pakaian.judul.toLowerCase().contains(query) ||
                        pakaian.deskripsi.toLowerCase().contains(query) ||
                        pakaian.detail.toLowerCase().contains(query)) {
                    mList.add(pakaian);
                    mListMapFilter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }

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
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
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
                title = getString(R.string.title_home);
                Toast.makeText(getApplicationContext(), "Anda berada di tampilan Beranda", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                fragment = new TariFragment();
                title = getString(R.string.title_tari);
                Toast.makeText(getApplicationContext(), "Anda berada di tampilan tari daerah", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                fragment = new SenjataFragment();
                title = getString(R.string.title_senjata);
                Toast.makeText(getApplicationContext(), "Anda berada di tampilan senjata daerah", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                fragment = new PakaianFragment();
                title = getString(R.string.title_pakaian);
                Toast.makeText(getApplicationContext(), "Anda berada di tampilan pakaian adat", Toast.LENGTH_SHORT).show();
                break;

            case 4:
                fragment = new RumahFragment();
                title = getString(R.string.title_rumah);
                Toast.makeText(getApplicationContext(), "Anda berada di tampilan rumah adat", Toast.LENGTH_SHORT).show();
                break;
            case 5:
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

    @Override
    public void doClick(int pos) {

    }
}