package pl.shop.payments;

import lombok.extern.java.Log;
import org.javamoney.moneta.FastMoney;

import javax.money.Monetary;
import java.util.Locale;

import static pl.shop.Application.ANSI_RESET;
import static pl.shop.Application.ANSI_YELLOW;


@Log
public class LocalMoney {

    public static FastMoney of(Number number) {
        var locale = Locale.getDefault();
        var currencyUnit = Monetary.getCurrency(locale);
        log.info(ANSI_YELLOW + FastMoney.of(number, currencyUnit).toString() + ANSI_RESET);
        return FastMoney.of(number, currencyUnit);
    }
}
