package br.com.alura.linguagensapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinguagemController {

//    private List<Linguagem> linguagens =
//            List.of(
//                    new Linguagem("Java", "https://logospng.org/download/java/logo-java-256.png", 1),
//                    new Linguagem("PHP", "https://logospng.org/download/php/logo-php-256.png", 2)
//            );

    @Autowired
    private LinguagemRepository repository;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repository.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSave = repository.save(linguagem);
        return linguagemSave;
    }

    @DeleteMapping("linguagens/{id}")
    public void deleteLinguagem(@PathVariable String id) {
        repository.deleteById(id);
    }
}