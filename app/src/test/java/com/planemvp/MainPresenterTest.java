package com.planemvp;

import com.planemvp.main.Main;
import com.planemvp.main.MainPresenter;
import com.planemvp.main.MainRepository;
import com.planemvp.main.MainView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hari on 14/09/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
    public static final boolean DATA_EMPTY = true;
    public static final boolean NOT_DATA_EMPTY = false;
    List<Main> MOCK_DATA = Arrays.asList(new Main("Hari"), new Main("Ravi"), new Main("Pa1"));
    @Mock
    MainView mainView;
    @Mock
    MainRepository mainRepository;
    MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter(mainView, mainRepository);
    }

    @Test
    public void shouldPassDataToView() {
        Mockito.when(mainRepository.getData()).thenReturn(MOCK_DATA);
        mainPresenter.loadData();
        Mockito.verify(mainView).displayData(MOCK_DATA);
    }

    @Test
    public void shouldHandleNoData() {
        Mockito.when(mainRepository.getData()).thenReturn(Collections.EMPTY_LIST);
        mainPresenter.loadData();
        Mockito.verify(mainView).displayNoData();
    }
}
