package AudioBook;

import LibraNetItem.LibraryItem;

import Interfaces.PlayAble;
import java.util.*;

public class AudioBook extends LibraryItem implements PlayAble{
    private int duration;

    public AudioBook(int id, String title, String author, int duration) {
        super(id, title, author);
        this.duration = duration;
    }

    public int getDuration(){
        return duration;
    }

    @Override
    public void play(){
        System.out.println("Playing audiobook: " + title + " (" + duration + " mins)");
    }
    @Override
    public void showDetails(){
        System.out.println("Audiobook: " + title + " by " + author + " (" + duration + " mins)");
    }
    }

