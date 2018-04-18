package com.grasset.rodrigo.menugallerie;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView  = (VideoView) findViewById(R.id.videoView);
        String uriPath ="android.resource://com.grasset.rodrigo.menugallerie/"+R.raw.compositionblack;

       Uri uri = Uri.parse(uriPath);
       videoView.setVideoURI(uri);
       videoView.requestFocus();
       videoView.start();



    }

}
