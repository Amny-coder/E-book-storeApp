package inc.amny.ebooks.web;


import inc.amny.ebooks.EBook;
import inc.amny.ebooks.Repository.EbookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ebook")
public class EBookStoreController {

    private final EbookRepository eBookRepo;

    EBookStoreController(EbookRepository eBookRepo) {
        this.eBookRepo = eBookRepo;
    }

    @ModelAttribute
    public void authUserModelView(Model model) {
        Iterable<EBook> ebooks = eBookRepo.findAll();
        for (EBook eBook : ebooks) {
            model.addAttribute(eBook);
        }
    }

    @GetMapping("/store")
    public String view() {
        return "ebookStore";
    }
}
