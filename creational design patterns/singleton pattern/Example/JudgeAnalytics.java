class JudgeAnalytics {
    // The volatile keyword in Java is a field modifier used in multi-threaded programming to ensure that changes made by one thread to a shared variable are immediately visible to all other threads. It acts as a lightweight alternative to full synchronization when you only need to ensure visibility and ordering, but not necessarily atomicity for complex operations.
    private static volatile JudgeAnalytics judgeAnalytics;

    // private constructor to prevent instantiation
    private JudgeAnalytics() {
    }

    // method to get the singleton instance

    public static JudgeAnalytics getInstance() {
        if (judgeAnalytics == null) {
            //The synchronized keyword in Java is a tool used in multithreading to ensure that only one thread can access a shared resource or "critical section" of code at a time. It prevents race conditions and data inconsistency by managing how threads interact with objects through an internal mechanism called an intrinsic lock or monitor.
            synchronized (JudgeAnalytics.class) {
                if (judgeAnalytics == null) {
                    judgeAnalytics = new JudgeAnalytics();
                }
            }
        }
        return judgeAnalytics;
    }
}