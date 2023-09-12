package inc.amny.ebooks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class EBook {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotBlank(message = "Authors name is required!")
    private String authorsName;

    @NotBlank(message = "Book title is required")
    private String title;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    private String docSource;

    @NotBlank(message = "Please summarize what the book entails")
    private String description;
}
