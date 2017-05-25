package com.thedeveloperworldisyours.letters.main;

import com.thedeveloperworldisyours.letters.BasePresenter;
import com.thedeveloperworldisyours.letters.BaseView;

import java.util.List;

/**
 * Created by javierg on 24/05/2017.
 */

public class MainContract {

    public interface Presenter extends BasePresenter {
        void putResponseInButtonAndTrail(String response);
        void putResponseInButtonAndTrailFromServer(String response);
        StringBuilder putLettersInButton(StringBuilder stringBuilder, int init, String
                response);
        StringBuilder putLettersInButtonFromServer(StringBuilder stringBuilder, int init, String
                response);
    }

    public interface View extends BaseView<Presenter> {

        void putResponseInButtons(List<String> putMessy);
        void setTraining(String training);
    }
}
