package models;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import presenters.Model;

public class TableService implements Model{
    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
       for (Table table: tables){
            if(table.getNo() == tableNo){
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservation().add(reservation);
                return reservation.getId();
            }
       }
       throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public void delReservationTable(int oldReservation) {
        boolean flag = false;
        Reservation toDel = null;
        for (Table table: tables){
            for (Reservation reservation: table.getReservation()){
                if(reservation.getId() == oldReservation){
                    toDel = reservation;
                    flag = true;
                }       
            }
            if (flag & toDel != null){
                table.getReservation().remove(toDel);
                break;
            }
        }
    }

    
}
