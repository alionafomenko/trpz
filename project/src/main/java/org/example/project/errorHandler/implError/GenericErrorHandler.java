package org.example.project.errorHandler.implError;

import org.example.project.errorHandler.ErrorHandler;

public class GenericErrorHandler implements ErrorHandler {


    @Override
    public void handleError(Exception e) {
        System.out.println("Generic error: " + e.getMessage());
    }
}
