import java.util.Date;

import models.TableService;
import presenters.BookingPresenter;
import presenters.Model;
import views.BookingView;

public class Program {
    public static void main(String[] args) {
        Model model = new TableService();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTableView();
        view.reservationTable(new Date(), 2, "Станислав");
        view.changeReservationTable(1001, new Date(), 4, "Станислав");
    }
}
