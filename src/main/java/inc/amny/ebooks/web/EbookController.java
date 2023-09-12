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
public class EbookController {

    private final EbookRepository eBookRepo;

    EbookController(EbookRepository eBookRepo) {
        this.eBookRepo = eBookRepo;
    }

    @ModelAttribute
    public void addEbookToModel(Model model) {
        Iterable<EBook> ebooks = eBookRepo.findAll();
        for (EBook eBook : ebooks) {
            model.addAttribute(eBook);
        }
    }

    @ModelAttribute(name = "ebook")
    public EBook eBook() {
        return new EBook();
    }

    @GetMapping
    public String eBookForm() {
        return "ebookForm";
    }

}
