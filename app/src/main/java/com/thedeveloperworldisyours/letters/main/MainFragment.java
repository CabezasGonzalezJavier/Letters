package com.thedeveloperworldisyours.letters.main;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thedeveloperworldisyours.letters.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainFragment extends Fragment implements MainContract.View {

    @BindView(R.id.main_fragment_edit_text)
    EditText mEditText;

    @BindView(R.id.main_fragment_first_text)
    TextView mFirst;

    @BindView(R.id.main_fragment_second_text)
    TextView mSecond;

    @BindView(R.id.main_fragment_third_text)
    TextView mThird;

    @BindView(R.id.main_fragment_fourth_text)
    TextView mFourth;

    @BindView(R.id.main_fragment_fifth_text)
    TextView mFifth;

    @BindView(R.id.main_fragment_sixth_text)
    TextView mSixth;

    @BindView(R.id.main_fragment_main_text)
    TextView mMail;

    @BindView(R.id.main_fragment)
    RelativeLayout mRelativeLayout;

    MainContract.Presenter mPresenter;

    String[] mLetterInButton;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        ButterKnife.bind(this, view);
        mLetterInButton = new String[6];

        return view;
    }

    @OnClick(R.id.main_fragment_server_button)
    public void checkFromServerButton() {
        String response = "caramelo";

        if (response.isEmpty()) {
            customSnackBar(R.string.main_activity_empty, ContextCompat.getColor(getActivity(), R.color.colorAccent));
        } else {
            mPresenter.putResponseInButtonAndTrailFromServer(response);
        }
    }

    @OnClick(R.id.main_fragment_button)
    public void checkButton() {
        String response = mEditText.getText().toString();

        if (response.isEmpty()) {
            customSnackBar(R.string.main_activity_empty, ContextCompat.getColor(getActivity(), R.color.colorAccent));
        } else {
            mPresenter.putResponseInButtonAndTrail(response);
        }
    }

    @Override
    public void putResponseInButtons(List<String> putMessy) {
        mFirst.setText(putMessy.get(0));
        mSecond.setText(putMessy.get(1));
        mThird.setText(putMessy.get(2));
        mFourth.setText(putMessy.get(3));
        mFifth.setText(putMessy.get(4));
        mSixth.setText(putMessy.get(5));
    }

    public void setTraining(String training) {

        mMail.setText(training);
    }


    void customSnackBar(int text, int color) {
        Snackbar snackbar = Snackbar.make(mRelativeLayout, getString(text), Snackbar.LENGTH_LONG);

        // get snackbar view
        View mView = snackbar.getView();
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
        snackbar.show();
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
