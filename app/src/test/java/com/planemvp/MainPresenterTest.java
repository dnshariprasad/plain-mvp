package com.planemvp;

import com.planemvp.main.Main;
import com.planemvp.main.MainPresenter;
import com.planemvp.main.MainRepository;
import com.planemvp.main.MainView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hari on 14/09/17.
 */
public class MainPresenterTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private List<Main> MOCK_DATA = Arrays.asList(new Main("Hari"), new Main("Ravi"), new Main("Pa1"));

    @Mock
    MainView mainView;

    @Mock
    MainRepository mainRepository;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter(mainView, mainRepository, Schedulers.trampoline());
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @After
    public void cleanUp() {
        RxJavaPlugins.reset();
    }

    @Test
    public void shouldPassDataToView() {
        Mockito.when(mainRepository.getData()).thenReturn(Single.just(MOCK_DATA));
        mainPresenter.loadData();
        Mockito.verify(mainView).displayData(MOCK_DATA);
    }

    @Test
    public void shouldHandleNoData() throws InterruptedException {
        Mockito.when(mainRepository.getData()).thenReturn(Single.just(Collections.EMPTY_LIST));
        mainPresenter.loadData();
//        Thread.sleep(1000); // get rid of it
        Mockito.verify(mainView).displayNoData();
    }

    @Test
    public void handleError() throws InterruptedException {
        Mockito.when(mainRepository.getData()).thenReturn(Single.error(new Throwable("boom!")));
        mainPresenter.loadData();
        Mockito.verify(mainView).displayError();
    }
}
