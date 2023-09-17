package Articles;

public class Articles {
    private String title;
    private String content;
    private String Author;

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.Author = author;
    }

    public String getTitle() {
        return title;
    }

    public void rename(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void Edit(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return Author;
    }

    public void changeAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return ""+title+" - "+content+": "+getAuthor()+"";
    }
}
