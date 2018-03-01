package ru.senla.bialevich.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "fk_books_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_authors_id")})
    private List<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_binding",
            joinColumns = {@JoinColumn(name = "fk_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_binding_id")})
    private List<Binding> bindings;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookLocation> bookLocations;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Dilivery> diliveries;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_genres_id")
    private Genre genre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_orderings",
            joinColumns = {@JoinColumn(name = "fk_books_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_orderings_id")})
    private List<Order> orders;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Binding> getBindings() {
        return bindings;
    }

    public void setBindings(List<Binding> bindings) {
        this.bindings = bindings;
    }

    public List<BookLocation> getBookLocations() {
        return bookLocations;
    }

    public void setBookLocations(List<BookLocation> bookLocations) {
        this.bookLocations = bookLocations;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Dilivery> getDiliveries() {
        return diliveries;
    }

    public void setDiliveries(List<Dilivery> diliveries) {
        this.diliveries = diliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
