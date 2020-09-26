package com.example.itemindexer;

import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadItem extends AppCompatActivity {
    private Button imageButton;
    private Button createItem;
    private boolean[] tags;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tags = new boolean[Tag.NUMTAGS.ordinal()];
        setContentView(R.layout.activity_upload_item);
        imageButton = findViewById(R.id.button2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(UploadItem.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            1
                    );
                }
                else imageActivity();
            }
        });
        createItem = findViewById(R.id.button5);
        createItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControlPanel.addItem(new Item(path, tags));
                openDialog();
            }
        });

    }
    public void openDialog(){
        Dialog exampleDialog = new Dialog();
        exampleDialog.show(getSupportFragmentManager(),"dialog");
    }

    public void onCheckboxClicked(View view){
        CheckBox checkBox = (CheckBox)view;
        switch (checkBox.getId()){
            case R.id.activewear:
                tags[Tag.ACTIVEWEAR.ordinal()] = checkBox.isChecked();
                break;
            case R.id.dresses:
                tags[Tag.DRESSES.ordinal()] = checkBox.isChecked();
                break;
            case R.id.jackets_coats:
                tags[Tag.JACKETS_COATS.ordinal()] = checkBox.isChecked();
                break;
            case R.id.jeans:
                tags[Tag.JEANS.ordinal()] = checkBox.isChecked();
                break;
            case R.id.jumpsuits:
                tags[Tag.JUMPSUITS.ordinal()] = checkBox.isChecked();
                break;
            case R.id.lingerie:
                tags[Tag.LINGERIE.ordinal()] = checkBox.isChecked();
                break;
            case R.id.pants:
                tags[Tag.PANTS.ordinal()] = checkBox.isChecked();
                break;
            case R.id.shorts:
                tags[Tag.SHORTS.ordinal()] = checkBox.isChecked();
                break;
            case R.id.skirts:
                tags[Tag.SKIRTS.ordinal()] = checkBox.isChecked();
                break;
            case R.id.sweaters:
                tags[Tag.SWEATERS.ordinal()] = checkBox.isChecked();
                break;
            case R.id.swimwear:
                tags[Tag.SWIMWEAR.ordinal()] = checkBox.isChecked();
                break;
            case R.id.tops:
                tags[Tag.TOPS.ordinal()] = checkBox.isChecked();
                break;

        }

    }

    private void imageActivity() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), 9000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 9000 && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            path = cursor.getString(columnIndex);

            cursor.close();

            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(path));

        }


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 1 && grantResults.length > 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                imageActivity();
            }
            else Toast.makeText(this, "Permission Denied", 3);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}