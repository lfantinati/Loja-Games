package com.lojagames.Controller;

import com.lojagames.Model.Categoria;
import com.lojagames.Model.Produto;
import com.lojagames.Repository.CategoriaRepository;
import com.lojagames.Repository.ProdutoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins =  "*", allowedHeaders = "*")

public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getall(){
        return ResponseEntity.ok(produtoRepository.findAll());

    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Produto>Post(@Valid @RequestBody Produto produto){
        if (categoriaRepository.existsById(produto.getCategoria().getId()))
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    public ResponseEntity<Produto> Put(@Valid @RequestBody Produto produto){
        if (produtoRepository.existsById(produto.getId())){
            if (categoriaRepository.existsById(produto.getCategoria().getId()))
                return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return  produtoRepository.findById(produto.getId()).map(resposta->ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Optional<Produto> postagem = produtoRepository.findById(id);

        if(postagem.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        produtoRepository.deleteById(id);
    }



}
