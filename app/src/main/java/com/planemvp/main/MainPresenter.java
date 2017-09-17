package com.planemvp.main;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by Hari on 14/09/17.
 */

public class MainPresenter {
    private final MainView mMainView;
    private final MainRepository mMainRepository;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainView mMainView, MainRepository mainRepository) {
        this.mMainView = mMainView;
        this.mMainRepository = mainRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    public void loadData() {
        mCompositeDisposable.add(mMainRepository.getData()
                .subscribeWith(new DisposableSingleObserver<List<Main>>() {
                    @Override
                    public void onSuccess(List<Main> mains) {
                        if (mains.isEmpty())
                            mMainView.displayNoData();
                        else
                            mMainView.displayData(mains);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMainView.displayError();
                    }
                }));
    }

    public void unsubsidised() {
        mCompositeDisposable.clear();
    }

}
