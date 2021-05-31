package es.ansotolab.customersservice.exception;

public class ImageIOError extends RuntimeException {
    public ImageIOError() {
        super("There was an unexpected error reading the file.");
    }
}