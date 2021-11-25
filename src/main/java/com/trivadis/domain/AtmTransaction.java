package com.trivadis.domain;

import java.util.UUID;

public class AtmTransaction {
    private UUID id;
    private Long accountId;
    private Atm atm;

    public AtmTransaction(Long accountId, Atm atm) {
        id = UUID.randomUUID();
        this.accountId = accountId;
        this.atm = atm;
    }

    public UUID getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Atm getAtm() {
        return atm;
    }

    @Override
    public String toString() {
        return "AtmTransaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", atm=" + atm +
                '}';
    }
}
