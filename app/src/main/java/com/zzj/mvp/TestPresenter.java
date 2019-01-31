package com.zzj.mvp;

/**
 * @author : zzj
 * @date : 2019/1/31
 * @desp : 测试
 */
public class TestPresenter implements TestContract.Presenter {

    public static final int SORT_SELECT = 0x01;
    public static final int SORT_INSERT = 0x02;
    private TestContract.MvpView mMvpView;

    @Override
    public void init(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int item : array) {
            stringBuilder.append(" " + item);
        }
        if (mMvpView != null) {
            mMvpView.sortBefore("排序前:" + stringBuilder.toString());
        }
    }

    @Override
    public void sort(int[] array, int sort) {
        switch (sort) {
            case SORT_SELECT:
                array = selectSort(array);
                break;
            case SORT_INSERT:
                array = insertSort(array);
                break;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int item : array) {
            stringBuilder.append(" " + item);
        }
        if (mMvpView != null) {
            mMvpView.showToast(sort == SORT_SELECT ? "选择排序" : "插入排序");
            mMvpView.sortAfter("排序后:" + stringBuilder.toString());
        }
    }

    /**
     * 选择排序
     */
    public int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }

            if (array[i] > array[minPos]) {
                int temp = array[i];
                array[i] = array[minPos];
                array[minPos] = temp;
            }

        }
        return array;
    }

    /**
     * 插入排序
     */
    public int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }

    @Override
    public void attachView(TestContract.MvpView mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }
}
