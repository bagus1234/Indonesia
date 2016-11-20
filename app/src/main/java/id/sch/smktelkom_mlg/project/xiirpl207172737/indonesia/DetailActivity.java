package id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import activity.TariFragment;
import model.Tari;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Tari tari = (Tari) getIntent().getSerializableExtra(TariFragment.TARI);
        setTitle(tari.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(tari.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.desc);
        tvDeskripsi.setText(tari.deskripsi + "\n\n" + tari.detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
