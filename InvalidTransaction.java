package banking;

import java.io.Serializable;

public class InvalidTransaction extends Exception implements Serializable {
    // Add this line to resolve the warning
    private static final long serialVersionUID = 1L;

    // Constructor
    public InvalidTransaction(String message) {
        super(message);
    }

    // Other methods (if any) go here
}
