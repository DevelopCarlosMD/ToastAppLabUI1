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

        if(savedInstanceState != null){
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");

            if (isVisible){
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

    }


    public void launchSecondActivity(View view) {
        //Log.i(TAG, "Button was clicked");
        String message = edtMesasage.getText().toString();
        Intent intent = new Intent(this, ChatPerson2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(ChatPerson2.EXTRA_REPLY);

                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
                //edtMesasage.setText("");
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mReplyTextView.getText().toString());
        }
    }
}
