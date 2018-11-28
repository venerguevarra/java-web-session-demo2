package jee.web.shoppee.model;

public class Book extends Product {
    private String authorId;

    public Book() {
        super();
    }

    public Book(String id, String name, String description, int price, String authorId) {
        super(id, name, description, price);
        this.authorId = authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorId() {
        return authorId;
    }
}
