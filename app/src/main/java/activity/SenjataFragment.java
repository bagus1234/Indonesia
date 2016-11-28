package activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.SenjataAdapter;
import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.DetailSenjataActivity;
import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;
import model.Senjata;

/**
 * Created by User on 13/11/2016.
 */

public class SenjataFragment extends Fragment implements SenjataAdapter.ISenjataAdapter {
    public static final String SENJATA = "senjata";
    ArrayList<Senjata> mList = new ArrayList<>();
    ArrayList<Senjata> mListAll = new ArrayList<>();
    boolean isFiltered;
    String mQuery;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();

    SenjataAdapter mAdapter;
    View view;
    Context context;

    public SenjataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_senjata_fragment, container, false);

        context = getContext();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.senjata);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new SenjataAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();

        // Inflate the layout for this fragment
        return rootView;
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.kota);
        String[] arDeskripsi = resources.getStringArray(R.array.trailer_des4);
        String[] arDetail = resources.getStringArray(R.array.deskripsi4);
        TypedArray a = resources.obtainTypedArray(R.array.gambar4);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Senjata(arJudul[i], arDeskripsi[i], arDetail[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(getActivity(), DetailSenjataActivity.class);
        intent.putExtra(SENJATA, mList.get(pos));
        startActivity(intent);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
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
                Senjata senjata = mListAll.get(i);
                if (senjata.judul.toLowerCase().contains(query) ||
                        senjata.deskripsi.toLowerCase().contains(query)) {
                    mList.add(senjata);
                    mListMapFilter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}

