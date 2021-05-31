package es.ansotolab.customersservice.exception;

public class CustomerAlreadyExists extends RuntimeException {
    public CustomerAlreadyExists(String cif) {
        super("The customer with CIF: " + cif + " already exists.");
    }
}
