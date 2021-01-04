package com.rubywai.lesson3_hot_observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;


public class LessonThree {
    public static void main(String[] args) {
        Observable<Long> myObservable = Observable.interval(1, TimeUnit.SECONDS);
        ConnectableObservable<Long> connectableObservable = myObservable.publish();
        connectableObservable.subscribe(item -> System.out.println("Observer 1: " + item));
        connectableObservable.connect();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        connectableObservable.subscribe(item -> System.out.println("Observer 2: " + item));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
}
