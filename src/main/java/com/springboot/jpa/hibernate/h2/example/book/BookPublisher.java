package com.springboot.jpa.hibernate.h2.example.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class BookPublisher implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    private Date publishedDate;

    public BookPublisher(Publisher publisher, Date publishedDate) {
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookPublisher)) return false;
        BookPublisher that = (BookPublisher) o;
        return Objects.equals(book.getName(), that.book.getName()) &&
                Objects.equals(publisher.getName(), that.publisher.getName()) &&
                Objects.equals(publishedDate, that.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book.getName(), publisher.getName(), publishedDate);
    }
}
