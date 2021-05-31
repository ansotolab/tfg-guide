package es.ansotolab.customersservice.exception;

public class ImageExceededSize extends RuntimeException {
    public ImageExceededSize() {
        super("The image can't be greater than 3MB.");
    }
}