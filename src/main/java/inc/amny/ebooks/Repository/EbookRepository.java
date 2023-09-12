package inc.amny.ebooks.Repository;

import inc.amny.ebooks.EBook;
import org.springframework.data.repository.CrudRepository;

public interface EbookRepository extends CrudRepository<EBook, Long> {
}
