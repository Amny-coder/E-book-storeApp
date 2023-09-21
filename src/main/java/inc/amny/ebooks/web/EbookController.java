package inc.amny.ebooks.web;


import inc.amny.ebooks.EBook;
import inc.amny.ebooks.Repository.EbookRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private final EbookRepository eBookRepo;

    public EbookController(EbookRepository eBookRepo) {
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
    public String processDoc(@Valid EBook ebook, @RequestParam("document")MultipartFile multipartDocFile,
                             @RequestParam("bookCover")MultipartFile multipartDocCover,
                             Errors errors) throws IOException {

        if (errors.hasErrors()) {
            return "ebookForm";
        }

        if (!multipartDocFile.isEmpty() && !multipartDocCover.isEmpty()) {
            ebook.setEBookContent(multipartDocFile.getBytes());
            ebook.setDocSize(multipartDocFile.getSize());

            ebook.setDocCover(multipartDocCover.getBytes());
        }
        log.info("Ebook Details: {}", ebook.getCreatedAt());
        eBookRepo.save(ebook);
        return "redirect:/ebook/store";
    }

}
