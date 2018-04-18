// codes TP3 Multimedia


// imageAdapter - gallerie d'images


import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by eleves on 18-04-04.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;
    public Integer[] images = {
        R.drawable.pic_01,R.drawable.pic_02,
        R.drawable.pic_03,R.drawable.pic_04,
        R.drawable.pic_05, R.drawable.pic_08,
        R.drawable.pic_10, R.drawable.pic_12, R.drawable.pic_13,
        R.drawable.pic_14, R.drawable.pic_16,
        R.drawable.pic_18,R.drawable.pic_19,
        R.drawable.pic_20,R.drawable.pic_21,
        R.drawable.pic_22,R.drawable.pic_23,
        R.drawable.pic_24, R.drawable.pic_17,
        R.drawable.pic_26,R.drawable.pic_27,
    };


    public  ImageAdapter(Context c) {

        context = c;

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setLayoutParams(new ViewGroup.LayoutParams(240 , 240));

        return imageView;
    }
}

//=====

//mainActivity pour l'introdution avec le gallerie de photos


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by eleves on 18-04-04.
 */

public class mainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent= new Intent(mainActivity.this,HomeActivity.class);
                startActivity(homeIntent);
                finish();

            }

        },SPLASH_TIME_OUT);
    }

}

//--------------------

//HomeActivity feito para a Gallerie de photos


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GridView gridView = (GridView) findViewById(R.id.MyGridview);
        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(),FullimageActivity.class);
                i.putExtra("id", position);
                startActivity(i);

            }
        });


    }



}

//---------------------


//Activity_home  code xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"

    android:padding="5dp"
    android:paddingBottom="0dp"
    android:paddingLeft="0dp"
    android:paddingRight="0dp"
    android:paddingTop="0dp"

    tools:context="com.grasset.rodrigo.rodrigoapplication.HomeActivity">

    <GridView
        android:id="@+id/MyGridview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:columnWidth="100dp"
        android:numColumns="auto_fit"
        android:stretchMode="columnWidth"
        android:verticalSpacing="5dp"/>


</android.support.constraint.ConstraintLayout>

// FullImageActiviy pour afficher les photos grand


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullimageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(adapter.images[position]);
    }
}
//----------------

//activity_fullimage  xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.grasset.rodrigo.rodrigoapplication.FullimageActivity">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerHorizontal= "true"
        android:layout_centerVertical = "true"
        android:scaleType="centerInside"
       />/ app:srcCompat="@drawable/pic_03"
        tools:layout_editor_absoluteX="115dp"
        tools:layout_editor_absoluteY="180dp" />

</android.support.constraint.ConstraintLayout>




//---------


// video logo inicial
//videoLogoActivity


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class videoLogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_logo);

        VideoView mvideoView = (VideoView)findViewById(R.id.myvideoView);
        String uriPath = "android.resource://com.grasset.rodrigo.rodrigoapplication/" +

        Uri uri = Uri.parse(uriPath);
        myvideoView.setVideoUri(uri);
        myvideoView.requestFocus();
        myvideoView.start();


    }
}

// activity video logo   xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.grasset.rodrigo.rodrigoapplication.mainActivity">

    <VideoView
        android:id="@+id/myvideoView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        tools:layout_editor_absoluteX="164dp"
        tools:layout_editor_absoluteY="219dp" />
</android.support.constraint.ConstraintLayout>



































































































































































