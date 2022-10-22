import java.io.FileNotFoundException;
import java.io.IOException;

public class Week8Task2 {
    public void nullPointerEx() throws NullPointerException {
        throw new NullPointerException("Lỗi Null Pointer");
    }

    public void arrayIndexOutOfBoundsEx() {
        throw new ArrayIndexOutOfBoundsException("Lỗi Array Index Out of Bounds");
    }

    public void arithmeticEx() {
        throw new ArithmeticException("Lỗi Arithmetic");
    }

    public void fileNotFoundEx() throws FileNotFoundException {
        throw new FileNotFoundException("Lỗi File Not Found");
    }

    public void ioEx() throws IOException {
        throw new IOException("Lỗi IO");
    }

    private String notError() {
        return "Không có lỗi";
    }

    /**
     * Null pointer exception.
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return e.getMessage();
        }
        return notError();
    }

    /**
     * Array index out of bounds exception.
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            return e.getMessage();
        }
        return notError();
    }

    /**
     * Arithmetic exception.
     */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
        return notError();
    }

    /**
     * File null.
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
        return notError();
    }

    /**
     * Input-output.
     */
    public String ioExTest() {
        try {
            ioEx();
        } catch (IOException e) {
            return e.getMessage();
        }
        return notError();
    }
}
