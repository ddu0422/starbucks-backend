package per.project.starbucks.services.exception;

public class NotFoundUserException extends RuntimeException {

    private static final String MESSAGE = "사용자를 찾을 수 없습니다.";

    public NotFoundUserException() {
        super(MESSAGE);
    }
}
