package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux()
//                .subscribe(
//                        num -> System.out.println(num),
//                        throwable -> System.out.println(throwable.getMessage()),
//                        () -> System.out.println("Yay!!!")
//                );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux()
                .subscribe(new Anuj<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class Anuj<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe working!!!");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value + " received!");
        request(1);
    }
}