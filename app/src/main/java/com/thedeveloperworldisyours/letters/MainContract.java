package com.thedeveloperworldisyours.letters;

import java.util.List;

/**
 * Created by javierg on 24/05/2017.
 */

public class MainContract {

    interface Presenter extends BasePresenter {
        void putResponseInButtonAndTrail(String response);
        void putResponseInButtonAndTrailFromServer(String response);
        StringBuilder putLettersInButton(StringBuilder stringBuilder, int init, String
                response);
        StringBuilder putLettersInButtonFromServer(StringBuilder stringBuilder, int init, String
                response);
    }

    interface View extends BaseView<Presenter> {

        void putResponseInButtons(List<String> putMessy);
        void setTraining(String training);
    }
}
