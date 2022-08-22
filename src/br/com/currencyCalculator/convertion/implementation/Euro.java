package br.com.currencyCalculator.convertion.implementation;

import br.com.currencyCalculator.convertion.Currency;
import br.com.currencyCalculator.convertion.FixedOperatingFeeCalculable;
import br.com.currencyCalculator.convertion.IOFCalculable;

public class Euro extends Currency implements FixedOperatingFeeCalculable, IOFCalculable {
    private double quotation = 0.2;

    private String abbreviation = "EUR";

    public String getAbbreviation() {
        return this.abbreviation;
    }

    @Override
    public double calculateFixedOperatingFee() {
        return 6.0;
    }

    @Override
    public double calculateIOF(double amount) {
        return 0.011 * amount;
    }

    @Override
    public double calculateOperatingFee(double amount) {
        return calculateFixedOperatingFee();
    }

    @Override
    public double calculateConversion(double amount) {
        return quotation * (amount - calculateIOF(amount) - calculateFixedOperatingFee());
    }
}
