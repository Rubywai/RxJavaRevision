package com.rubywai.lesson5_flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAll;
import io.reactivex.rxjava3.observers.ResourceObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class UnlimitedNetworkRequest {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(emitter -> {
            for(int i=0;i<1000;i++){
                emitter.onNext(i);
            }
            emitter.onComplete();
        });
        observable.toFlowable(BackpressureStrategy.MISSING).observeOn(Schedulers.computation()).subscribe(
                new ResourceSubscriber<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("error is" + throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                }
        );
    }

}
