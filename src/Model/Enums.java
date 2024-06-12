package Model;

public class Enums {
    public static enum role{
        ADMIN,
        CUSTOMER,
        EMPLOYEE
    }

    public static enum status{
        AVAILABLE,
        NOT_AVAILABLE
    }

    public static enum pemesanan{
        PROCESSED, // menunggu pembayaran
        CANCELLED,
        COMPLETED
    }
}
