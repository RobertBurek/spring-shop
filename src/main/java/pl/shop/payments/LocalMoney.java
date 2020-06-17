package pl.shop.payments;

import lombok.extern.java.Log;
import org.javamoney.moneta.FastMoney;

import javax.money.Monetary;
import java.util.Locale;


@Log
public class LocalMoney {

    public static FastMoney of(Number number) {
        var locale = Locale.getDefault();
        var currencyUnit = Monetary.getCurrency(locale);
        return FastMoney.of(number, currencyUnit);
    }
}
