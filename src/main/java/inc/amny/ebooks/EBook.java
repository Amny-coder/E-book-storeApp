package inc.amny.ebooks;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "ebook_store")
public class EBook {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    Date createdAt = new Date();

    @NotBlank(message = "Authors name is required!")
    private String authorsName;

    @NotBlank(message = "Book title is required")
    private String title;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    private String docSource;

    @NotBlank(message = "Please summarize what the book entails")
    private String description;

    @Lob
    private byte[] eBookContent;

    @Lob
    private byte[] docCover;

    private long docSize;
}
