package com.rubywai.lesson1_observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class LessonOne {
    public static void main(String[] args) {
       // observableWithJust();
       // observableWithInterable();
        observableWithCreate();
    }

    static void observableWithJust(){
        Observable<String> observable = Observable.just("12","13","hello");
        observable.subscribe(System.out::println);

    }
    static void observableWithInterable(){
        List<String> list = Arrays.asList("one","two","three","four");
        Observable<String> observable = Observable.fromIterable(list);

        observable.subscribe(System.out::println);
    }
    private static void observableWithCreate(){
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("one");
            Thread.sleep(1000);
            emitter.onNext("two");
            Thread.sleep(1000);
            emitter.onNext("three");
            Thread.sleep(1000);
            emitter.onNext("four");
            Thread.sleep(1000);
            emitter.onNext(null);
//            emitter.onError(new Throwable("This is custom Error"));
            emitter.onComplete();
        });
        observable.subscribe(
                System.out::println,
                error -> System.out.println("There is error" + error),
                () -> System.out.println("complete")
        );
    }
}
