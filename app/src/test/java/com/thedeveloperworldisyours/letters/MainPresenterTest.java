package com.thedeveloperworldisyours.letters;


import com.thedeveloperworldisyours.letters.main.MainContract;
import com.thedeveloperworldisyours.letters.main.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * Created by javierg on 24/05/2017.
 */

public class MainPresenterTest {


    @Mock
    MainContract.View mView;

    MainContract.Presenter mPresenter;

    String mResponse;
    StringBuilder mStringBuilder;
    List<String> mList;
    int mInit;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mStringBuilder = new StringBuilder("");
        mPresenter = new MainPresenter(mView);
        mList = new ArrayList<>();
        mInit = 0;
    }

    @Test
    public void putLettersInButtonTest() {

        mResponse = "Engine";
        mList.add("E");
        mList.add("n");
        mList.add("g");
        mList.add("i");
        mList.add("n");
        mList.add("e");


        mPresenter.putResponseInButtonAndTrail(mResponse);

        verify(mView).setTraining("______");
        verify(mView).putResponseInButtons(mList);
    }

    @Test
    public void putLettersInButtonWithAccent() {
        mResponse = "tambié";
        mList.add("t");
        mList.add("a");
        mList.add("m");
        mList.add("b");
        mList.add("i");
        mList.add("é");


        mPresenter.putResponseInButtonAndTrail(mResponse);

        verify(mView).setTraining("______");
        verify(mView).putResponseInButtons(mList);
    }

    @Test
    public void putLettersInButton() {
        mResponse = "también";
        mInit = 1;
        StringBuilder stringBuilder = new StringBuilder(mResponse);
        mPresenter.putLettersInButton(stringBuilder, mInit, mResponse);

        mList.add("a");
        mList.add("m");
        mList.add("b");
        mList.add("i");
        mList.add("é");
        mList.add("n");
        verify(mView).putResponseInButtons(mList);
    }
}
