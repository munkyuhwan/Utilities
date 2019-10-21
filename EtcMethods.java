package com.MyUtilities;

import java.text.DecimalFormat;

public class EtcMethods {
    private static final EtcMethods ourInstance = new EtcMethods();

    public static EtcMethods getInstance() {
        return ourInstance;
    }

    private EtcMethods() {
    }

    public String NumberComma(String num) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String str = formatter.format(Integer.parseInt(num));
        return str;
    }
}
