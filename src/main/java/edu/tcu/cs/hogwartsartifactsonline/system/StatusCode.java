package edu.tcu.cs.hogwartsartifactsonline.system;

public class StatusCode {

    public static final int SUCCESS = 200; // Success

    public static final int INVALID_ARGUMENT = 400; // Bad request, e.g., invalid parameters

    public static final int UNAUTHORIZED = 401; // Username or password incorrect

    public static final int FORBIDDEN = 403; // No permission

    public static final int NOT_FOUND = 404; // Not found

    public static final int INTERNAL_SERVER_ERROR = 500; // Server internal error

}
