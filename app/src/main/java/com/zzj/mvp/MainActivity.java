package com.zzj.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TestContract.MvpView {

    private TestContract.Presenter testPresenter;
    private int[] array = new int[]{6, 5, 9, 1};
    private TextView tvBefore,tvAfter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testPresenter = new TestPresenter();
        testPresenter.attachView(this);
        tvBefore = findViewById(R.id.tv_array);
        tvAfter = findViewById(R.id.tv_sort_array);
        testPresenter.init(array);
        findViewById(R.id.btn_one).setOnClickListener(onClickListener);
        findViewById(R.id.btn_two).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_one:
                    testPresenter.sort(array.clone(), TestPresenter.SORT_SELECT);
                    break;
                case R.id.btn_two:
                    testPresenter.sort(array.clone(), TestPresenter.SORT_INSERT);
                    break;
            }
        }
    };


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void sortBefore(String s) {
        tvBefore.setText(s);
    }

    @Override
    public void sortAfter(String s) {
        tvAfter.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在销毁的时候分离
        testPresenter.detachView();
    }
}
