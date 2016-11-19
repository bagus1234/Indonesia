package activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.RumahAdapter;
import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;
import model.Rumah;

/**
 * Created by User on 13/11/2016.
 */

public class RumahFragment extends Fragment {
    ArrayList<Rumah> mList = new ArrayList<>();
    RumahAdapter mAdapter;
    Context context;

    public RumahFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_rumah_fragment, container, false);
        context = getContext();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rumah);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RumahAdapter(mList);
        recyclerView.setAdapter(mAdapter);


        filldata();

        // Inflate the layout for this fragment
        return rootView;
    }

    private void filldata() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.kota3);
        String[] arDeskripsi = resources.getStringArray(R.array.trailer_des3);
        TypedArray a = resources.obtainTypedArray(R.array.gambar3);
        Drawable[] arFoto = new Drawable[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            arFoto[i] = a.getDrawable(i);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Rumah(arJudul[i], arDeskripsi[i], arFoto[i]));
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
}
