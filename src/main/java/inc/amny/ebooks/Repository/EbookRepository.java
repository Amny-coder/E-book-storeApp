package inc.amny.ebooks.Repository;

import inc.amny.ebooks.EBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EbookRepository extends CrudRepository<EBook, String> {
}
