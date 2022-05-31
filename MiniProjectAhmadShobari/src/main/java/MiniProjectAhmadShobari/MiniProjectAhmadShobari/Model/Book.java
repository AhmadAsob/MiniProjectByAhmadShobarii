package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Table(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @Column(name = "Code", nullable = false)
    private String code;

    @Column(name="Title")
    private String title;
    @Column(name="IsBorrowed")
    private boolean isBorrowed;
    @Column(name="Summary")
    private String summary;
    @Column(name="ReleaseDate")
    private LocalDate releaseDate;
    @Column(name="TotalPage")
    private int totalPage;

    @ManyToOne
    @JoinColumn(name = "AuthorId")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "CategoryName")
    private Category category;

//    @OneToMany(mappedBy = "bookCode",cascade = CascadeType.ALL)
//    private List<Loan> loans;

//    public Book(String code, String title, String summary, Category category, LocalDate releaseDate, int totalPage, Author author ) {
//
//    }

    public Book(String code, String title, Category categoryName, Author authorId, String summary, LocalDate releaseDate, int totalPage) {
        this.code = code;
        this.title = title;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.totalPage = totalPage;
        this.author = authorId;
        this.category = categoryName;
        this.isBorrowed = false;
    }
}

