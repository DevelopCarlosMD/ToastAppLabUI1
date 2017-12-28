package com.coyotestudio.toastapp.chat_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.coyotestudio.toastapp.R;

public class ChatPerson2 extends AppCompatActivity {

    private static final String EXTRA_REPLY =
            "com.coyotestudio.toastapp.chat_example.extra_REPLY";
    private TextView tvMessage;
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_person2);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        mReply = (EditText) findViewById(R.id.et_reply);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ChatPerson1.EXTRA_MESSAGE);
        tvMessage.setText(message);
    }


    public void returnReply(View view) {

        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();//EXTRA_REPLY, reply);
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();

    }
}
