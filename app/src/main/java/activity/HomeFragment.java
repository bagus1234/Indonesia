package activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;

/**
 * Created by User on 13/11/2016.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    Button btnHome;
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


        return rootView;
    }

    private void isidata() {

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
                Toast.makeText(activity, "Anda berada di tampilan rumah adat", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imageButton2:
                fragment = new TariFragment();
                title = getString(R.string.title_tari);
                Toast.makeText(activity, "Anda berada di tampilan tari daerah", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imageButton3:
                fragment = new PakaianFragment();
                title = getString(R.string.title_pakaian);
                Toast.makeText(activity, "Anda berada di tampilan pakaian adat", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imageButton4:
                fragment = new LaguFragment();
                title = getString(R.string.title_lagu);
                Toast.makeText(activity, "Anda berada di tampilan lagu daerah", Toast.LENGTH_SHORT).show();
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
