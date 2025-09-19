package Book;
import LibraNetItem.LibraryItem;

import java.util.*;

 public class Book extends LibraryItem {

     private int pagecount;


     public Book(int id, String title, String author, int pagecount) {
         super(id, title, author);
         this.pagecount = pagecount;
     }
     public int getPageCount(){
         return pagecount;
     }

     @Override
     public void showDetails(){
         System.out.println("Book: " + title + " by " + author + " (" + pagecount + " pages)");
     }
 }
