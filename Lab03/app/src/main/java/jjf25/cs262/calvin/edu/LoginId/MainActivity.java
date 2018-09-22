package jjf25.cs262.calvin.edu.LoginId;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "jjf25.cs262.calvin.edu.LoginId.extra.MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView, mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = (EditText) findViewById(R.id.editText_main);
        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);
    }



    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}
