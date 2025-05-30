package service;

import exception.IdJaCadastradoException;
import jakarta.validation.Valid;
import model.Cardapio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import repository.CardapioRepository;

import java.util.List;

@Service
@Validated
public class CardapioService {
    private CardapioRepository cardapioRepository;

    public CardapioService(CardapioRepository cardapioRepository) {
        this.cardapioRepository = cardapioRepository;
    }

    public List<Cardapio> listarTodos(){
        return cardapioRepository.findAll();
    }

    public Cardapio salvar(@Valid Cardapio cardapio) {
        if (cardapioRepository.findById(cardapio.getId()).isPresent()) {
            throw new IdJaCadastradoException("Usuário já cadastrado.");
        }

        return cardapioRepository.save(cardapio);
    }

    public Cardapio atualizar(@Valid Cardapio cardapio) {
        Cardapio cardapioAtualizar = cardapioRepository.findById(cardapio.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado."));

        cardapioAtualizar.setPratos(cardapio.getPratos());
        cardapioAtualizar.setValorEntrada(cardapio.getValorEntrada());
        cardapioAtualizar.setValorPratoPrincipal(cardapio.getValorPratoPrincipal());
        cardapioAtualizar.setValorSobremesa(cardapio.getValorSobremesa());
        cardapioAtualizar.setQuantidadeEntrada(cardapio.getQuantidadeEntrada());
        cardapioAtualizar.setQuantidadePrincipal(cardapio.getQuantidadePrincipal());
        cardapioAtualizar.setQuantidadeSobremesa(cardapio.getQuantidadeSobremesa());


        return cardapioRepository.save(cardapioAtualizar);
    }

    public void excluir(Long id) {
        Cardapio cardapioExcluir =cardapioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        cardapioRepository.deleteById(cardapioExcluir.getId());
    }

}
