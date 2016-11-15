package activity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;

/**
 * Created by Shafira Pramatana on 11/15/2016.
 */
public class introscreen extends AppCompatActivity {
    RelativeLayout introMessage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introscreen);
        Button btn5 = (Button) findViewById(R.id.button5);

        getWindow().setFormat(PixelFormat.UNKNOWN);
        VideoView videoView = (VideoView) findViewById(R.id.videoView1);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hahaha));
        videoView.start();

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent pindah = new Intent(introscreen.this, MainActivity.class);
                startActivity(pindah);
            }
        });

        introMessage = (RelativeLayout) findViewById(R.id.welcome_pesan);

    }

    public void dismisWelcomeMessageBox(View view) {
        introMessage.setVisibility(View.INVISIBLE);

    }
}
