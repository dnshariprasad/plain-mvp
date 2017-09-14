package com.planemvp;

import com.planemvp.main.Main;
import com.planemvp.main.MainPresenter;
import com.planemvp.main.MainRepository;
import com.planemvp.main.MainView;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hari on 14/09/17.
 */

public class MainPresenterTest {
    public static final boolean DATA_EMPTY = true;
    public static final boolean NOT_DATA_EMPTY = false;

    @Test
    public void shouldPassDataToView() {
        //3 parts to test
        //given (initial condition)
        MainView mainView = new MockMainView();
        MainRepository mainRepository = new MockMainRepository(NOT_DATA_EMPTY);

        //when (action to trigger)
        MainPresenter mainPresenter = new MainPresenter(mainView, mainRepository);
        mainPresenter.loadData();

        //when (action to trigger)
        Assert.assertEquals(true, ((MockMainView) mainView).displayDataCalled);
    }

    @Test
    public void shouldHandleNoData() {
        MainView mainView = new MockMainView();
        MainRepository mainRepository = new MockMainRepository(DATA_EMPTY);


        MainPresenter mainPresenter = new MainPresenter(mainView, mainRepository);
        mainPresenter.loadData();

        Assert.assertEquals(true, ((MockMainView) mainView).displayNoDataCalled);
    }

    private class MockMainView implements MainView {
        boolean displayDataCalled;
        boolean displayNoDataCalled;

        @Override
        public void displayData(List<Main> mains) {
            displayDataCalled = true;
        }

        @Override
        public void displayNoData() {
            displayNoDataCalled = true;
        }
    }

    private class MockMainRepository implements MainRepository {
        private boolean mDataFlag;

        MockMainRepository(boolean mDataFlag) {
            this.mDataFlag = mDataFlag;
        }

        @Override
        public List<Main> getData() {
            if (mDataFlag == NOT_DATA_EMPTY)
                return Arrays.asList(new Main("Hari"), new Main("Ravi"), new Main("Pa1"));
            else
                return Collections.emptyList();
        }
    }
}
