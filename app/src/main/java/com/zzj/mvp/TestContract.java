package com.zzj.mvp;

import com.zzj.mvp.mvp.IBasePresenter;
import com.zzj.mvp.mvp.IBaseView;

/**
 * @author : zzj
 * @date : 2019/1/31
 * @desp : 按谷歌官方推荐指定一个契约类
 */
public interface TestContract {

    interface Presenter extends IBasePresenter<MvpView>{

        void init(int[] array);

        void sort(int[] array, int sort);

    }

    interface MvpView extends IBaseView<Presenter>{

        void sortBefore(String s);

        void sortAfter(String s);

        void showToast(String msg);

    }

}
