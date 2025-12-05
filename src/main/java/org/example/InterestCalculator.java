package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class InterestCalculator {

    public InterestCalculator() {}

    public double calculateInterestPeriod(double poso, double epitokio, LocalDate startDate, LocalDate endDate) {

        double diastima = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        System.out.println(diastima);

        double formaTokouYperimerias = poso * (epitokio / 100) * diastima / 365;

        double result = new BigDecimal(formaTokouYperimerias).setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println(result);

        return result;
    }

    public double calculateInterestPeriodLeapYear(double poso, double epitokio, LocalDate startDate, LocalDate endDate) {

        double diastima = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        System.out.println(diastima);

        double formaTokouYperimerias = poso * (epitokio / 100) * diastima / 366;

        double result = new BigDecimal(formaTokouYperimerias).setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println(result);

        return result;
    }

    public double calculateEpidikiaSynDyoPeriod(double poso, double epitokio, LocalDate startDate, LocalDate endDate) {

        double diastima = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        System.out.println(diastima);

        double formaTokouYperimerias = poso * (epitokio + 2.00) / 100 * diastima / 365;

        double result = new BigDecimal(formaTokouYperimerias).setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println(result);

        return result;
    }

    public double calculateEpidikiaSynDyoPeriodLeapYear(double poso, double epitokio, LocalDate startDate, LocalDate endDate) {

        double diastima = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        System.out.println(diastima);

        double formaTokouYperimerias = poso * (epitokio + 2.00) / 100 * diastima / 366;

        double result = new BigDecimal(formaTokouYperimerias).setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println(result);

        return result;
    }

    public double calculateEpidikiaSynTriaPeriod(double poso, double epitokio, LocalDate startDate, LocalDate endDate) {

        double diastima = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        System.out.println(diastima);

        double formaTokouYperimerias = poso * (epitokio + 3.00) / 100 * diastima / 365;

        double result = new BigDecimal(formaTokouYperimerias).setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println(result);

        return result;
    }

    public double calculateEpidikiaSynTriaPeriodLeapYear(double poso, double epitokio, LocalDate startDate, LocalDate endDate) {

        double diastima = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        System.out.println(diastima);

        double formaTokouYperimerias = poso * (epitokio + 3.00) / 100 * diastima / 366;

        double result = new BigDecimal(formaTokouYperimerias).setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println(result);

        return result;
    }

    public int numberOfLeapYears(int startYear, int endYear) {

        int count = 0;

        for (int i = startYear; i <= endYear; i++) {

            if (Year.isLeap(i)) {

                count++;
            }
        }
        return count;
    }
}
