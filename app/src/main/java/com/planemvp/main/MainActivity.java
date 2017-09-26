package com.planemvp.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.planemvp.R;
import com.planemvp.app.App;
import com.planemvp.app.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hari on 14/09/17.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener, MainView {
    @Inject
    public MainRepository mDataRepository;
    public MainPresenter mMainPresenter;

    private Button mLoadPleaseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        mLoadPleaseBtn = (Button) findViewById(R.id.main_load_please_btn);
        mLoadPleaseBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter = new MainPresenter(this,mDataRepository , AndroidSchedulers.mainThread());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMainPresenter.unsubsidised();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_load_please_btn:
                mMainPresenter.loadData();
                break;
        }
    }

    @Override
    public void displayData(List<Main> mains) {
        mLoadPleaseBtn.setText("Great, I got " + mains.size());
    }

    @Override
    public void displayNoData() {
        mLoadPleaseBtn.setText("No Data!");
    }

    @Override
    public void displayError() {
        toast("Oops!");
    }
}
