package views.visitaMedica;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import com.pamela.zeballos.version1.R;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.TypeFaceFont;

public class CameraPhotoCapture extends Activity {
    private int PICK_IMAGE_REQUEST = 1;
    private int TAKE_PHOTO_REQUEST = 0;
    String imgDecodableString;
    @Bind(R.id.img_captured)
    ImageView imgCaptured;

    @Bind(R.id.btn_galery)
    Button btnGalery;

    @Bind(R.id.btn_cancel)
    Button btnCancel;

    private void setViewElements() {
        TypeFaceFont.setFontawesome(this, btnGalery);
        TypeFaceFont.setFontawesome(this, btnCancel);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_photo_capture);
        ButterKnife.bind(this);
        setViewElements();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //take photo
        if (requestCode == TAKE_PHOTO_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            imgCaptured.setImageBitmap(bp);
        } else {
            System.out.println("------- photo cancelar");
        }
        // pick image from gallery

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            // Get the Image from data

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            // Get the cursor
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            // Move to first row
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            ImageView imgView = (ImageView) findViewById(R.id.img_captured);
            // Set the Image in ImageView after decoding the String
            imgView.setImageBitmap(BitmapFactory
                    .decodeFile(imgDecodableString));
        } else {
            System.out.println("------- gallery cancelar");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.btn_capture)
    public void onCapture() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    @OnClick(R.id.btn_galery)
    public void onGalery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

    }

    @OnClick(R.id.btn_cancel)
    public void onCancel() {
        this.finish();

    }
}