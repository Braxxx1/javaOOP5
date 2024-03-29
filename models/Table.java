package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
public class Table {
    private static int counter;
    private int no;
    private Collection<Reservation> reservation = new ArrayList<>();
    public Collection<Reservation> getReservation() {
        return reservation;
    }

    public int getNo(){
        return no;
    }

    public Table(){
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
