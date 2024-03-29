package presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver{
    private Model model;
    private View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.registerObserver(this);
    }

    public void updateTableView(){
        view.showTables(model.loadTables());
    }

    private void updateDelReservationTableView(int oldReservation){
        view.delReservationTableView(oldReservation);
    }

    private void updateReservationTableView(int reservationNo){
        view.showReservationTableView(reservationNo);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try{
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }
    }

    @Override
    public void offReservationTable(int oldReservation, Date orderDate, int tableNo, String name) {
        model.delReservationTable(oldReservation);
        updateDelReservationTableView(oldReservation);

    }
}
