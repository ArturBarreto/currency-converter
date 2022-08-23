package br.com.currencyCalculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalUtil {
    public static String format(BigDecimal bigDecimal) {
        BigDecimal scale = bigDecimal.setScale(2, RoundingMode.DOWN);
        DecimalFormat df = new DecimalFormat();

        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setGroupingUsed(false);

        return df.format(scale);
    }
}
