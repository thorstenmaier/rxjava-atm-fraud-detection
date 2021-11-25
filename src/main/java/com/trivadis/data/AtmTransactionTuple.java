package com.trivadis.data;

import com.trivadis.domain.AtmTransaction;

public class AtmTransactionTuple {
    private AtmTransaction l;
    private AtmTransaction r;

    public AtmTransactionTuple(AtmTransaction l, AtmTransaction r) {
        this.l = l;
        this.r = r;
    }

    public boolean isSameTransaction() {
        return l.getId().equals(r.getId());
    }

    public boolean isSameAccount() {
        return l.getAccountId().equals(r.getAccountId());
    }

    public boolean isDuplicate() {
        return l.getId().compareTo(r.getId()) > 0;
    }

    public double distance() {
        return l.getAtm().getCity().distance(r.getAtm().getCity());
    }

    @Override
    public String toString() {
        return "AtmTransactionTuple{" +
                "l=" + l +
                ", r=" + r +
                '}';
    }
}
