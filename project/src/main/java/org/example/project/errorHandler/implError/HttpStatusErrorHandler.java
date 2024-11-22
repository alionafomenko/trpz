package org.example.project.errorHandler.implError;

import org.example.project.errorHandler.ErrorHandler;
import org.jsoup.HttpStatusException;

public class HttpStatusErrorHandler implements ErrorHandler {
    private ErrorHandler nextHandler;

    public void setNextHandler(ErrorHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleError(Exception e) {
        if (e instanceof HttpStatusException) {
            System.out.println("Handling HTTP status error: " + e.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleError(e);
        }
    }
}
