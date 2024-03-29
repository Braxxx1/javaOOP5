package presenters;

import java.util.Date;

public interface ViewObserver {
    void onReservationTable(Date orderDate, int tableNo, String name);
    void offReservationTable(int oldReservation, Date orderDate, int tableNo, String name);
}
