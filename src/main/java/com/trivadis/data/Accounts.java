package com.trivadis.data;

import java.util.ArrayList;
import java.util.List;

public class Accounts {

    public static List<Long> getRandomAccountIds(int count) {
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ids.add((long) (Math.random() * 10_000_000));
        }
        return ids;
    }
}
