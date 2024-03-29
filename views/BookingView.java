package views;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import models.Table;
import presenters.View;
import presenters.ViewObserver;

public class BookingView implements View{
    private Collection<ViewObserver> observers;

    public void showTables(Collection<Table> tables){
        for (Table table: tables){
            System.out.println(table);
        }
    }

    public void reservationTable(Date date, int table, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){
                observer.onReservationTable(date, table, name);
            }
        }
    }

    @Override
    public void registerObserver(ViewObserver observer) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(observer);
    }

    @Override
    public void showReservationTableView(int reservationNo) {
       if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер брони №%d\n", reservationNo);
       }
       else{
        System.out.println("Ошибка при попытке забронировать столик.\nПовторите попытку.");
       }
    }

    @Override
    public void delReservationTableView(int reservationNO) {
        System.out.printf("Бронь №%d успешно отменена\n", reservationNO);
    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){
                observer.offReservationTable(oldReservation, reservationDate, tableNo, name);
            }
        }
        reservationTable(reservationDate, tableNo, name);
    }

   
}
