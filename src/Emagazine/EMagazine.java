package Emagazine;

import LibraNetItem.LibraryItem;


public class EMagazine extends LibraryItem {

    private int issueNumber;

    public EMagazine(int id, String title, String author, int issueNumber) {
        super(id, title, author);
        this.issueNumber = issueNumber;
    }

    public void archiveIssue(){
        System.out.println("Archiving E Magazine of title "+title+" with issue number "+issueNumber);
    }

    public void showDetails(){
        System.out.println("E-Magazine: " + title + " by " + author + " (Issue " + issueNumber + ")");
    }
}
