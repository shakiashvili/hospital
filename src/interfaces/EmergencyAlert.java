package interfaces;

import enums.UrgencyLevel;

public interface EmergencyAlert {
    void alert(String message, UrgencyLevel level);
}