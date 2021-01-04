package com.rubywai.lesson4_disposable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class CompositeDisposableEg {
    public static void main(String[] args) throws InterruptedException {
        CompositeDisposable composiveDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable d1 = observable.subscribe(item -> System.out.println("Item 1 "+ item));
        Disposable d2 = observable.subscribe(item -> System.out.println("Item 2 " + item));
        composiveDisposable.addAll(d1,d2);
        Thread.sleep(3000);
        composiveDisposable.remove(d1);
        //composiveDisposable.dispose();
        Thread.sleep(10000);
    }
}
