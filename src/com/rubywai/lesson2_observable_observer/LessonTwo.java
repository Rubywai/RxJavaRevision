package com.rubywai.lesson2_observable_observer;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class LessonTwo {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(
                emitter -> {
                    emitter.onNext("one");
                    Thread.sleep(1000);
                    emitter.onNext("two");
                    Thread.sleep(1000);
                    emitter.onNext("three");
                    Thread.sleep(1000);
                    emitter.onNext("four");
                    Thread.sleep(1000);
                    emitter.onError(new Throwable("error"));
                    Thread.sleep(1000);
                    emitter.onNext("five");
                    emitter.onComplete();


                }
        );

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("subscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println(o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error is" + e);
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        };
        observable.subscribe(observer);
    }
}
