package edu.tcu.cs.hogwartsartifactsonline.system.exception;

public class CustomBlobStorageException extends RuntimeException {

    public CustomBlobStorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
