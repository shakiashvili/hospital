package interfaces;

import enums.HospitalType;

@FunctionalInterface
public interface TaxCalculator {
    double apply(double amount, HospitalType type);
}