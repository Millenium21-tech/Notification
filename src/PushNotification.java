enum NotificationPriority {
    HIGH, MEDIUM, LOW;
}

interface NotificationService {
    void sendNotification(String message, NotificationPriority priority);

    default void setDefaultPriority(String priority) {

    }
}


class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message, NotificationPriority priority) {
        System.out.println("Sending Email Notification (Priority: " + priority + "): " + message);
    }
}


class SMSNotification implements NotificationService {
    @Override
    public void sendNotification(String message, NotificationPriority priority) {
        System.out.println("Sending SMS Notification (Priority: " + priority + "): " + message);
    }
}

class PushNotification implements NotificationService {
    private String deviceId;
    private String defaultPriority = "MEDIUM";

    public PushNotification(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public void sendNotification(String message, NotificationPriority priority) {
        System.out.println("Sending Push Notification to device [" + deviceId +
                "] (Priority: " + priority + "): " + message);
    }

    @Override
    public void setDefaultPriority(String priority) {
        this.defaultPriority = priority.toUpperCase();
        System.out.println("Default priority set to: " + this.defaultPriority);
    }

    public String getDefaultPriority() {
        return defaultPriority;
    }

    public String getDeviceId() {
        return deviceId;
    }
}