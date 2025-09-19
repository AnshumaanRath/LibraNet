package LibraNetItem;

import java.util.*;
import com.CustomException.CustomException;

public abstract class LibraryItem {

    protected int id;
    protected String title;
    protected String author;
    protected boolean available;

    protected Date borrowDate;

    private static final double fine = 10.0;
    private static Map<Integer,Double> fines = new HashMap<>(); //ItemId -> fine

    public LibraryItem(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available=true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }



    public void borrow(String duration) throws CustomException{
        if(!available){
            throw new CustomException("Item already borrowed: "+title);
        }
        try{
            int days = parse(duration);
            available = false;

            fines.put(id,0.0);
            System.out.println(title+" borrowed for "+days+" days.");



        }
        catch(NumberFormatException e){
            throw new CustomException("Invalid duration format "+duration);
        }
    }

    public void returnItem(int overdue){
        available=true;
        if(overdue>0){
            double fine_total = fine*overdue;

            fines.put(id,fine);
            System.out.println("Fine for "+title+" is Rs "+fine_total);

        }
        else{
            fines.put(id,0.0);
            System.out.println("Returned without fines");
        }
    }


    public static double getFine(int itemid){
        return fines.getOrDefault(itemid,0.0);
    }

    public int parse(String duration){
        int days = Integer.parseInt(duration.split(" ")[0]);
        return days;
    }

    public abstract void showDetails();




}
