package jzm.jeno.com.jzm.http;

/**
 * author : 宋佳
 * time   : 2018/11/02
 * desc   :
 * version: 1.0.0
 */

public abstract class ObserverOnNextListener<T> {


    protected abstract void onNext(T t);


    protected abstract void error(Throwable e);


}
