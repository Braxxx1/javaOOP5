package models;
import java.util.Date;

public class Reservation {
    private int counter = 1000;
    private int id;
    private Table table;
    private Date date;
    private String name;

    public Reservation(Table table, Date date, String name){
        id = ++counter;
        this.table = table;
        this.date = date;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Table getTable() {
        return table;
    }
}
