package com.example.aula.controller;

import com.example.aula.model.Cardapio;
import com.example.aula.service.CardapioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    private CardapioService cardapioService;

    public CardapioController(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    @GetMapping
    public List<Cardapio> listarTodos() {
        return cardapioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Cardapio cardapio) {
        cardapioService.salvar(cardapio);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cadastrado com sucesso."));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Cardapio cardapio) {
        cardapioService.atualizar(cardapio);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        cardapioService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Excluído com sucesso"));
    }
}
