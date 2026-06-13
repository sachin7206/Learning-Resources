// Abstract class defining the template method and common steps
public abstract class NotificationSender {
    // Template method
    public final void send(String to, String msg) {
        // Common Logic
        rateLimitCheck(to);
        checkEmail(to);
        String formatted = formatMessage(msg);

        // Specific Logic: defined by subclassese
        String composedMessage = composeMessage(formatted);
        sendMessage(to, composedMessage);

        // Optional Hook
        postSendAnalytics(to);

    }

    // Common step 1: Check rate limits
    private void rateLimitCheck(String to) {
        System.out.println("checking ratelimit for : " +  to);
    }

    // Common step 2: Check email
    private void checkEmail(String to) {
        System.out.println("checking email : " +  to);
    }

    // Common step 3: Format the message (can be customized)
    private String formatMessage(String message) {
        return message.trim(); // could include HTML escaping, emoji processing, etc.
    }

    // Hook for subclasses to implement custom message composition
    protected abstract String composeMessage(String formattedMessage);

    // Hook for subclasses to implement custom message sending
    protected abstract void sendMessage(String to, String message);

    // Optional hook for analytics (can be overridden)
    protected void postSendAnalytics(String to) {
        System.out.println("Analytics updated for: " + to);
    }


}
