package ru.senla.bialevich.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dilivery")
public class Dilivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_books_id")
    private Book book;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dilivery dilivery = (Dilivery) o;
        return Objects.equals(id, dilivery.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
