public class Book {
    private String title;
    private int pageCount;
    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
        if(title == null || title == "") {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive");
        }
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    @Override
    public String toString() {
        return title + "(" + pageCount +" pages)";
    }
}
