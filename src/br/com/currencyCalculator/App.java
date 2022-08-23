package br.com.currencyCalculator;

import br.com.currencyCalculator.convertion.Currency;
import br.com.currencyCalculator.convertion.implementation.CalculationFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String option;
        BigDecimal amount;
        BigDecimal result = new BigDecimal("0");
        String abbreviation = "";

        do {
            amount = readNumber("Digite o valor em reais (R$) [0 para finalizar]: ");

            if (amount.compareTo(BigDecimal.ZERO) != 0) {
                option = readString("Digite a moeda de destino:\n\t1.Euro\n\t2.Dólar\n\t3.Peso Argentino\n\t4.Peso Chileno\n-> ");

                result = calculate(amount, option);
                abbreviation = returnAbbreviation(option);

                System.out.println("Valor em reais -> R$ " + formatBigDecimal(amount));
                System.out.println("IOF -> R$ " + formatBigDecimal(returnIOF(amount, option)));
                System.out.println("Taxa de Operação -> R$ "+ formatBigDecimal(returnOperatingFee(amount, option)));
                System.out.println("----------------------------");
                System.out.println("Total convertido -> " + abbreviation + " " + formatBigDecimal(result));
            }

        } while (amount.compareTo(BigDecimal.ZERO) != 0);
    }

    private static BigDecimal calculate(BigDecimal amount, String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().calculateConversion(amount);
        }
    }

    private static String returnAbbreviation(String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().getAbbreviation();
        }
    }

    private static BigDecimal returnIOF(BigDecimal amount, String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().calculateIOF(amount);
        }
    }

    private static BigDecimal returnOperatingFee(BigDecimal amount, String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().calculateOperatingFee(amount);
        }
    }

    private static BigDecimal readNumber(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextBigDecimal();
    }

    private static String readString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }

    public static String formatBigDecimal(BigDecimal n) {
        n = n.setScale(2, RoundingMode.DOWN);
        DecimalFormat df = new DecimalFormat();

        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setGroupingUsed(false);

        String result = df.format(n);

        return result;
    }
}