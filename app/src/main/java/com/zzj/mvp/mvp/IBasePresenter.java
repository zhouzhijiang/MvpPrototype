package com.zzj.mvp.mvp;

/**
 * @author : zzj
 * @date : 2019/1/31
 * @desp : mvp设计模式中的P层
 */
public interface IBasePresenter<T> {

    /**
     * 关联activity或fragment
     * @param mvpView
     */
    void attachView(T mvpView);

    /**
     * activity或fragment在destroyed时与View分离
     * 避免耗时操作更新View
     */
    void detachView();
}
