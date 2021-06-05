package outedg.mtscarneiro.aviation.domain;

public enum Payment {
    ORDERED(1), PAID(2), EXPIRED(3);

    private int code;

    private Payment(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static Payment valueOf(int code) {
        for(Payment value : Payment.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid payment code.");
    }
}
