package reactivex.examples;


import rx.Subscriber;
import rx.Observable;
import rx.Observable.OnSubscribe;


/****************************************************
 *
 @Deprecated public static <T> Observable<T> create(Observable.OnSubscribe<T> f)


 public static <T> Observable<T> create(Action1<Emitter<T>> emitter,
 Emitter.BackpressureMode backpressure)

 public static <T> Observable<T> unsafeCreate(Observable.OnSubscribe<T> f)

 public static <S,T> Observable<T> create(SyncOnSubscribe<S,T> syncOnSubscribe)

 @Beta public static <S,T> Observable<T> create(AsyncOnSubscribe<S,T> asyncOnSubscribe)
 *
 *
 *
 *
 */


public class CreatingOperation {


    public static void main(String[] args) {
        //
//        Observable.create(subscriber -> {
//
//        }).subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onNext(Integer item) {
//                System.out.println("Next: " + item);
//            }
//
//            @Override
//            public void onError(Throwable error) {
//                System.err.println("Error: " + error.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("Sequence complete.");
//            }
//        });

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        for (int i = 1; i < 5; i++) {
                            observer.onNext(i);
                        }
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        }).subscribe(new Subscriber<Integer>() {

            @Override
            public void onNext(Integer item) {
                System.out.println("Next: " + item);
            }

            @Override
            public void onError(Throwable error) {
                System.err.println("Error: " + error.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }
        });
    }

}
