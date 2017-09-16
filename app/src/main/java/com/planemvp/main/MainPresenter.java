package com.planemvp.main;

import java.util.List;

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
        try {
            List<Main> listOfMain = mMainRepository.getData();
            if (listOfMain.size() == 0)
                mMainView.displayNoData();
            else
                mMainView.displayData(listOfMain);
        } catch (Exception e) {
            mMainView.displayError();
        }
    }
}
