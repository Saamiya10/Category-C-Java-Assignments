class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode) && newCode != null) {
            this.code = newCode;
            return true;
        }
        return false;
    }
}

public class LockerManager {
    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println("Changed: " + locker.changeCode("1234", "5678"));
    }
}