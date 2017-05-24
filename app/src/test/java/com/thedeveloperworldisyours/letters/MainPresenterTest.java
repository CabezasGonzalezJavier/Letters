package com.thedeveloperworldisyours.letters;

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

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void putLettersInButtonTest() {

        mResponse = "Engine";
        mStringBuilder = new StringBuilder("");
        mPresenter = new MainPresenter(mView);
        mList = new ArrayList<>();
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
}
