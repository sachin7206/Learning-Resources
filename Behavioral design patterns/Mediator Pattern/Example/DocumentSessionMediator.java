public interface DocumentSessionMediator {
    void join(User user);
    void broadcastChange(String change, User sender);
}
