package id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import activity.RumahFragment;
import model.Rumah;

public class DetailRumahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rumah);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Rumah rumah = (Rumah) getIntent().getSerializableExtra(RumahFragment.RUMAH);
        setTitle(rumah.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(rumah.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.desc);
        tvDeskripsi.setText(rumah.deskripsi + "\n\n" + rumah.detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
