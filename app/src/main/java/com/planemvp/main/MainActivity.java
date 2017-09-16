package com.planemvp.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.planemvp.R;
import com.planemvp.app.BaseActivity;

import java.util.List;

/**
 * Created by Hari on 14/09/17.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener, MainView {
    private MainPresenter mMainPresenter;
    private Button mLoadPleaseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadPleaseBtn = (Button) findViewById(R.id.main_load_please_btn);
        mLoadPleaseBtn.setOnClickListener(this);

        mMainPresenter = new MainPresenter(this, new DataRepository());
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
        mLoadPleaseBtn.setText("Done.");
    }

    @Override
    public void displayNoData() {
        mLoadPleaseBtn.setText("No Data!");
    }

    @Override
    public void displayError() {
        toast("Ooops!");
    }
}
