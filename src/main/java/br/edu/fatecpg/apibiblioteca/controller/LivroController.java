package br.edu.fatecpg.apibiblioteca.controller;

import br.edu.fatecpg.apibiblioteca.model.Livro;
import br.edu.fatecpg.apibiblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired //a dependencia de livro repository vem direto
    private LivroRepository repository;

    //CRIAR
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro novoLivro) {
        Livro livroSalvo = repository.save(novoLivro);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
    }

    //LER TODOS (GET)
        @GetMapping
        public List<Livro> listarTodosOsLivros() {
            return repository.findAll();
        }

    //LER por Id (GET)
        @GetMapping("/{id}")
        public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
            Optional<Livro> livro = repository.findById(id);
            if (livro.isPresent()) {
                return ResponseEntity.ok(livro.get());
            }
            return ResponseEntity.notFound().build();
        }

        //ATUALIZAR (PUT)
        @PutMapping("/{id}")
        public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody
                Livro livroAtualizado) {
            return repository.findById(id)
                    .map(livroExistente -> {
                        livroExistente.setTitulo(livroAtualizado.getTitulo());
                        livroExistente.setAutor(livroAtualizado.getAutor());
                        livroExistente.setIsbn(livroAtualizado.getIsbn());
                        livroExistente.setAno(livroAtualizado.getAno());
                        Livro livroSalvo = repository.save(livroExistente);
                        return ResponseEntity.ok(livroSalvo);
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        //DELETAR (DELET)
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        }
    }



