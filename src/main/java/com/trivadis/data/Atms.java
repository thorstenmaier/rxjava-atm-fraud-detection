package com.trivadis.data;

import com.trivadis.domain.Atm;

import java.util.ArrayList;
import java.util.List;

public class Atms {

    public static List<Atm> getRandomAtms(int count) {
        List<Atm> atms = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            atms.add(new Atm(Cities.randomCity()));
        }
        return atms;
    }
}
