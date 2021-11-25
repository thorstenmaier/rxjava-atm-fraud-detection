package com.trivadis;

import com.trivadis.data.AtmTransactionTuple;
import com.trivadis.data.Transactions;
import com.trivadis.domain.AtmTransaction;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Observable<AtmTransaction> atmTransactions = Transactions.getAtmTransactions(1_000, 2_000, 100)
                .publish()
                .refCount(2);

        Disposable d = atmTransactions.join(
                        atmTransactions,
                        i -> Observable.timer(3000, TimeUnit.MILLISECONDS),
                        i -> Observable.timer(3000, TimeUnit.MILLISECONDS),
                        AtmTransactionTuple::new)
                .filter(tuple -> !tuple.isSameTransaction())
                .filter(AtmTransactionTuple::isSameAccount)
                .filter(AtmTransactionTuple::isDuplicate)
                .filter(t -> t.distance() > 50000) // distance more than 50 km
                .subscribe(System.out::println);
    }
}
