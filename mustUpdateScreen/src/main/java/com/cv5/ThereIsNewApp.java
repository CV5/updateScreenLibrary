package com.cv5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cv5.mustupdatescreen.R;

import java.util.Objects;

public class ThereIsNewApp extends AppCompatActivity {
    private String newAppLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_there_is_new_app);
        Objects.requireNonNull(getSupportActionBar()).hide();

        newAppLink = getIntent().getStringExtra("newAppLink");

        Glide.with(this).load(R.drawable.update_background)
                .into((ImageView) findViewById(R.id.imageBg));
    }

    public void onGoNewApp(View view) {
        try {
            String applink = Contantes.LINKNEWAPP + newAppLink;
            Log.v("miapplink", applink);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(applink)));
        } catch (Exception e) {
            Toast.makeText(this, R.string.sww_single, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        //        Intent intent;
//        intent = new Intent(ThereIsNewApp.this ,PrincipalActivity.class);
//        startActivity(intent);
    }
}
