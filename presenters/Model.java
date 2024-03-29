package presenters;

import java.util.Date;
import java.util.Collection;

import models.Table;

public interface Model {
    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);
    void delReservationTable(int oldReservation);
}
