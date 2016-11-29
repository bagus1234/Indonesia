package activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;

/**
 * Created by User on 13/11/2016.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    MediaPlayer mediaplayer;
    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ((MainActivity) getActivity()).isOnMenu = true;
        ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imageButton);
        ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
        ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
        ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imageButton4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        mediaplayer = MediaPlayer.create(getActivity(), R.raw.selamat);


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mediaplayer.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaplayer.pause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaplayer != null)
            mediaplayer.release();

    }


    public void onClick(View v) {
        //do what you want to do when button is clicked
        Fragment fragment = null;
        String title = null;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Activity activity = getActivity();

        ((MainActivity) getActivity()).isOnMenu = false;
        switch (v.getId()) {

            case R.id.imageButton:
                fragment = new RumahFragment();
                title = getString(R.string.title_rumah);
                break;

            case R.id.imageButton2:
                fragment = new TariFragment();
                title = getString(R.string.title_tari);
                break;

            case R.id.imageButton3:
                fragment = new PakaianFragment();
                title = getString(R.string.title_pakaian);
                break;

            case R.id.imageButton4:
                fragment = new SenjataFragment();
                title = getString(R.string.title_senjata);
                break;
        }


        fragmentTransaction.replace(R.id.container_body, fragment);
        fragmentTransaction.commit();

        // set the toolbar title
        ((MainActivity) getActivity()).setActTitle(title);
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
