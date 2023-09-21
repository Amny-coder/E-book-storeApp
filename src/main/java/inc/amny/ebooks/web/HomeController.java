package inc.amny.ebooks.web;


import inc.amny.ebooks.EBook;
import inc.amny.ebooks.Repository.EbookRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component
public class HomeController {

    private final EbookRepository ebookRepository;

    public HomeController(EbookRepository ebookRepository) {
        this.ebookRepository = ebookRepository;
    }

    @ModelAttribute(name = "ebook")
    public void addViewToModel(Model model) {
        Iterable<EBook> listOfEbooks = ebookRepository.findAll();

        for (EBook ebook : listOfEbooks) {
            model.addAttribute(ebook);
        }
    }

    @GetMapping("/")
    public String homeView() {
        return "home";
    }
}
