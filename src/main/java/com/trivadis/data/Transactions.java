package com.trivadis.data;

import com.trivadis.domain.Atm;
import com.trivadis.domain.AtmTransaction;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class Transactions {

    public static Observable<AtmTransaction> getAtmTransactions(int accountCount, int atmCount, long rateInMillis) {
        List<Long> accountIds = Accounts.getRandomAccountIds(accountCount);
        List<Atm> atms = Atms.getRandomAtms(atmCount);

        return Observable.generate(emitter -> {
            AtmTransaction atmTransaction = new AtmTransaction(
                    accountIds.get((int) (accountIds.size() * Math.random())),
                    atms.get((int) (atms.size() * Math.random()))
            );
            emitter.onNext(atmTransaction);
            Thread.sleep(rateInMillis);
        });
    }
}
