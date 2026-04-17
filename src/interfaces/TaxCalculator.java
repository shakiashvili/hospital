package interfaces;

import enums.HospitalType;

public interface TaxCalculator {
    double apply(double amount, HospitalType type);
}