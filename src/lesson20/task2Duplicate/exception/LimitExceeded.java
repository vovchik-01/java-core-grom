package lesson20.task2Duplicate.exception;

public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
