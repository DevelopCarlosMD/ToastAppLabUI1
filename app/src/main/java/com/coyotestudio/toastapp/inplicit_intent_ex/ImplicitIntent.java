package com.coyotestudio.toastapp.inplicit_intent_ex;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.coyotestudio.toastapp.R;

public class ImplicitIntent extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mOpenLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        mWebsiteEditText = (EditText) findViewById(R.id.edt_website_text);
        mOpenLocationEditText = (EditText) findViewById(R.id.edt_location);
        mShareTextEditText = (EditText) findViewById(R.id.edt_share_text);
    }

    public void opeWebSite(View view) {

        String url = mWebsiteEditText.getText().toString();
        if (!url.isEmpty()) {
            Uri webpage = Uri.parse(url);

            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Can't handle this intent!", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Please introduce a valid url", Toast.LENGTH_SHORT).show();
        }
    }

    public void openLocation(View view) {
        String loc = mOpenLocationEditText.getText().toString();

        if (!loc.isEmpty()) {
            Uri addressUri = Uri.parse("geo:0.0?q=" + loc);
            Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Please enter a valid address", Toast.LENGTH_SHORT).show();
        }
    }

    public void shareThis(View view) {
        String txt = mShareTextEditText.getText().toString();
        if (!txt.isEmpty()){
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Share this text with.")
                    .setText(txt)
                    .startChooser();
        } else {
            Toast.makeText(this, "Intro some text", Toast.LENGTH_SHORT).show();
        }

    }
}
