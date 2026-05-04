package hospital;

public final class HospitalInfo {

    public static final String NAME = "City Hospital";

    static {
        System.out.println("HospitalInfo class is loading");
    }

    public static final void printInfo() {
        System.out.println("Welcome to " + NAME);
    }
}
