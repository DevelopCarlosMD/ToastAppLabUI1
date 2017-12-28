package com.coyotestudio.toastapp.chat_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.coyotestudio.toastapp.R;

public class ChatPerson1 extends AppCompatActivity {

    public static final String TAG = ChatPerson1.class.getSimpleName();
    public static final String EXTRA_MESSAGE =
            "com.coyotestudio.toastapp.chat_example.extra.MESSAGE";
    private EditText edtMesasage;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_person1);

        edtMesasage = (EditText) findViewById(R.id.et_main);
        mReplyHeadTextView = (TextView) findViewById(R.id.tv_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.tv_message_reply);

    }

    public void launchSecondActivity(View view) {
        //Log.i(TAG, "Button was clicked");
        String message = edtMesasage.getText().toString();
        Intent intent = new Intent(this, ChatPerson2.class);
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);
    }
}
