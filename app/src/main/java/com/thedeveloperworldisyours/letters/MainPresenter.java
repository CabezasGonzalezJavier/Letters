package com.thedeveloperworldisyours.letters;

import java.util.ArrayList;
import java.util.List;

import static com.thedeveloperworldisyours.letters.Utils.getRandom;
import static com.thedeveloperworldisyours.letters.Utils.getStringWith6Character;
import static com.thedeveloperworldisyours.letters.Utils.hasAccent;
import static com.thedeveloperworldisyours.letters.Utils.hasAccentFirstPosition;

/**
 * Created by javierg on 24/05/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void putResponseInButtonAndTrail(String response) {

        //put space in when is less than 6
        getStringWith6Character(response);

        StringBuilder stringBuilder = new StringBuilder(response);

        int init = getRandom(response.length());

        stringBuilder = putLettersInButton(stringBuilder, init, response);

//        Collections.shuffle(mPutMessy);
        mView.setTraining(stringBuilder.toString());
    }

    @Override
    public void putResponseInButtonAndTrailFromServer(String response) {
        //put space in when is less than 6
        getStringWith6Character(response);

        StringBuilder stringBuilder = new StringBuilder(response);

        int init = getRandom(response.length());

        stringBuilder = putLettersInButton(stringBuilder, init, response);

//        Collections.shuffle(mPutMessy);
        mView.setTraining(stringBuilder.toString());
    }

    @Override
    public StringBuilder putLettersInButton(StringBuilder stringBuilder, int init, String
            response) {
        List<String> putMessy = new ArrayList<>();
        String[] letterInButton = new String[6];
        for (int i = 0; 6 > i; i++) {
            letterInButton[i] = response.substring(init, init + 1);
            putMessy.add(letterInButton[i]);

            if (init < response.length()) {
                stringBuilder.setCharAt(init, '_');
            }
            init++;
        }
        mView.putResponseInButtons(putMessy);
        return stringBuilder;
    }

    @Override
    public StringBuilder putLettersInButtonFromServer(StringBuilder stringBuilder, int init, String response) {
        List<String> putMessy = new ArrayList<>();
        String[] letterInButton = new String[6];
        for (int i = 0; 6 > i; i++) {
            if ((i == 0) && (hasAccentFirstPosition(response.substring(init, init + 1)))) {
                // when the first position is a accent
                letterInButton[i] = response.substring(init - 1, init + 1);
                stringBuilder.setCharAt(init - 1, '_');
                stringBuilder.setCharAt(init, '_');
            } else {

                if (init + 2 <= response.length()) {
                    if (hasAccent(response.substring(init, init + 2))) {
                        // when the next position is a accent
                        letterInButton[i] = response.substring(init, init + 2);
                        stringBuilder.setCharAt(init, '_');
                        init++;
                    } else {
                        // normal
                        letterInButton[i] = response.substring(init, init + 1);
                    }
                } else {

                    if (init + 1 > response.length()) {
                        // when there is not more element
                        letterInButton[i] = " ";
                    } else {
                        // normal
                        letterInButton[i] = response.substring(init, init + 1);
                    }
                }
            }

            putMessy.add(letterInButton[i]);

            if (init < response.length()) {
                stringBuilder.setCharAt(init, '_');
            }
            init++;
        }
        mView.putResponseInButtons(putMessy);
        return stringBuilder;
    }

    @Override
    public void start() {

    }
}
