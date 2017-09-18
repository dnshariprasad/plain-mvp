package com.planemvp.main;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hari on 14/09/17.
 */

public class MainPresenter {
    private final MainView mMainView;
    private final MainRepository mMainRepository;
    private Scheduler mScheduler;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainView mMainView, MainRepository mainRepository, Scheduler scheduler) {
        this.mMainView = mMainView;
        this.mMainRepository = mainRepository;
        mCompositeDisposable = new CompositeDisposable();
        mScheduler = scheduler;
    }

    public void loadData() {
        mCompositeDisposable.add(mMainRepository.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(mScheduler)
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
