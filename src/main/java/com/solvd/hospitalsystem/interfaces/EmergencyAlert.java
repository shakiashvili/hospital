package interfaces;

import enums.UrgencyLevel;

@FunctionalInterface
public interface EmergencyAlert {
    void alert(String message, UrgencyLevel level);
}