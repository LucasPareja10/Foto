package com.example.exemplo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
ImageView img;
Button bttirafoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (true){
             retiraFoto();
        }
    }

    private void retiraFoto()
    {
        img = (ImageView)findViewById(R.id.image);
        Button bttirafoto = (Button)findViewById(R.id.btntirafoto);
        bttirafoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();

        if (data != null){
            Bitmap bitmap = (Bitmap)bundle.get("data");
            img.setImageBitmap(bitmap);
        }
    }
}
