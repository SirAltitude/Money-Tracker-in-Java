import java.util.HashMap;
import java.util.Map;

public enum TicketTypeEnum {
    restaurant(1),
    sports(2),
    cinema(3),
    transport(4);

    private int value;

    TicketTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
