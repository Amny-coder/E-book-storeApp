package inc.amny.ebooks.web;


import inc.amny.ebooks.EBook;
import inc.amny.ebooks.Repository.EbookRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ebook")
public class EbookController {

    private final EbookRepository eBookRepo;

    EbookController(EbookRepository eBookRepo) {
        this.eBookRepo = eBookRepo;
    }

    @ModelAttribute(name = "ebook")
    public EBook eBook() {
        return new EBook();
    }

    @GetMapping("/registration")
    public String eBookForm() {
        return "ebookForm";
    }

    @PostMapping
    public String processDoc(@Valid EBook ebook, Errors errors) {

        if (errors.hasErrors()) {
            return "ebookForm";
        }
        eBookRepo.save(ebook);
        return "redirect:/ebook/store";
    }

}
