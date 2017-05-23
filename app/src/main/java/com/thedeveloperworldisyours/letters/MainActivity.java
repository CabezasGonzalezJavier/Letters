package com.thedeveloperworldisyours.letters;

import android.graphics.Typeface;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.thedeveloperworldisyours.letters.Utils.getRandom;
import static com.thedeveloperworldisyours.letters.Utils.getStringWith6Character;
import static com.thedeveloperworldisyours.letters.Utils.hasAccent;
import static com.thedeveloperworldisyours.letters.Utils.hasAccentFirstPosition;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_activity_edit_text)
    EditText mEditText;

    @BindView(R.id.main_activity_first_text)
    TextView mFirst;

    @BindView(R.id.main_activity_second_text)
    TextView mSecond;

    @BindView(R.id.main_activity_third_text)
    TextView mThird;

    @BindView(R.id.main_activity_fourth_text)
    TextView mFourth;

    @BindView(R.id.main_activity_fifth_text)
    TextView mFifth;

    @BindView(R.id.main_activity_sixth_text)
    TextView mSixth;

    @BindView(R.id.main_activity_main_text)
    TextView mMail;

    @BindView(R.id.main_activity)
    RelativeLayout mRelativeLayout;

    List<String> mPutMessy;
    String[] mLetterInButton;
    Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
    }

    public void checkbutton() {
        if (mEditText.getText().toString().isEmpty()) {
            customSnackBar(R.string.empty, ContextCompat.getColor(this, R.color.colorAccent));
        } else {
            putResponseInButtonAndTrail();
        }
    }

    void putResponseInButtonAndTrail() {

        mPutMessy = new ArrayList<>();
        String response = mEditText.getText().toString();


        //put space in when is less than 6
        getStringWith6Character(response);

        StringBuilder stringBuilder = new StringBuilder(response);

        int init = getRandom(response.length());
//        Log.d(" init --> ", String.valueOf(init));

        stringBuilder = putLettersInButton(stringBuilder, init, response);

        Collections.shuffle(mPutMessy);
        putResponseInButtons();
        mMail.setText(stringBuilder);
    }

    public StringBuilder putLettersInButton(StringBuilder stringBuilder, int init, String
            response) {
        for (int i = 0; 6 > i; i++) {

            if ((i == 0) && (hasAccentFirstPosition(response.substring(init, init + 1)))) {
                // when the first position is a accent
                mLetterInButton[i] = response.substring(init - 1, init + 1);
                stringBuilder.setCharAt(init - 1, '_');
                stringBuilder.setCharAt(init, '_');
            } else {

                if (init + 2 <= response.length()) {
                    if (hasAccent(response.substring(init, init + 2))) {
                        // when the next position is a accent
                        mLetterInButton[i] = response.substring(init, init + 2);
                        stringBuilder.setCharAt(init, '_');
                        init++;
                    } else {
                        // normal
                        mLetterInButton[i] = response.substring(init, init + 1);
                    }
                } else {

                    if (init + 1 > response.length()) {
                        // when there is not more element
                        mLetterInButton[i] = " ";
                    } else {
                        // normal
                        mLetterInButton[i] = response.substring(init, init + 1);
                    }
                }
            }

//            Log.d(" put --> ", mLetterInButton[i]);
            mPutMessy.add(mLetterInButton[i]);

            if (init < response.length()) {
                stringBuilder.setCharAt(init, '_');
            }
            init++;
        }
        return stringBuilder;
    }

    void putResponseInButtons() {
        mFirst.setText(mPutMessy.get(0));
        mSecond.setText(mPutMessy.get(1));
        mThird.setText(mPutMessy.get(2));
        mFourth.setText(mPutMessy.get(3));
        mFifth.setText(mPutMessy.get(4));
        mSixth.setText(mPutMessy.get(5));
    }

    void customSnackBar(int text, int color) {
        Snackbar mSnackbar = Snackbar.make(mRelativeLayout, getString(text), Snackbar.LENGTH_LONG);

        // get snackbar view
        View mView = mSnackbar.getView();
        mView.setBackgroundResource(color);

        // get textview inside snackbar view
        TextView textview = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);

        textview.setTypeface(Typeface.DEFAULT_BOLD);

        // set text to center
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

            textview.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        } else {

            textview.setGravity(Gravity.CENTER_HORIZONTAL);

        }

        // show the snackbar
        mSnackbar.show();
    }
}
