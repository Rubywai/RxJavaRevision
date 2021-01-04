package com.rubywai.lesson4_disposable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class LessonFour {
    public static void main(String[] args) {

        Observable<String> observable = Observable.just("one","two","three","four","five");
        observable.subscribe(new Observer<String>() {
            Disposable disposable;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NonNull String s) {
                if(s.equals("three")){
                    disposable.dispose();
                }
                if(!disposable.isDisposed())
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println(e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });
    }
}
