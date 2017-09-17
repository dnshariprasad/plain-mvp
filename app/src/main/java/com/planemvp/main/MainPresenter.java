package com.planemvp.main;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

/**
 * Created by Hari on 14/09/17.
 */

public class MainPresenter {
    private final MainView mMainView;
    private final MainRepository mMainRepository;

    public MainPresenter(MainView mMainView, MainRepository mainRepository) {
        this.mMainView = mMainView;
        this.mMainRepository = mainRepository;
    }

    public void loadData() {
        mMainRepository.getData()
                .subscribe(new Consumer<List<Main>>() {
                    @Override
                    public void accept(List<Main> bookList) throws Exception {
                        if (bookList.isEmpty())
                            mMainView.displayNoData();
                        else
                            mMainView.displayData(bookList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mMainView.displayError();
                    }
                });
    }
}
