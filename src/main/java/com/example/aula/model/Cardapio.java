package com.example.aula.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "tab_cardapio")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Disponivel disponivel;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @NotBlank(message = "Nome da bebida é obrigatorio")
    private String nomePrato;

    @NotNull(message = "O preço é obrigatorio")
    @PositiveOrZero(message = "O valor não pode ser menor que Zero")
    private double descricao;

    @NotNull(message = "O preço é obrigatorio")
    @PositiveOrZero(message = "O valor não pode ser menor que Zero")
    private double preco;

    @NotBlank(message = "URL é obrigatorio")
    private String urlImage;


    public Cardapio() {
    }

    public Cardapio(Long id, Disponivel disponivel, Categoria categoria, String nomePrato, double descricao, double preco, String urlImage) {
        this.id = id;
        this.disponivel = disponivel;
        this.categoria = categoria;
        this.nomePrato = nomePrato;
        this.descricao = descricao;
        this.preco = preco;
        this.urlImage = urlImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Disponivel getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Disponivel disponivel) {
        this.disponivel = disponivel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public @NotBlank(message = "Nome da bebida é obrigatorio") String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(@NotBlank(message = "Nome da bebida é obrigatorio") String nomePrato) {
        this.nomePrato = nomePrato;
    }

    @NotNull(message = "O preço é obrigatorio")
    @PositiveOrZero(message = "O valor não pode ser menor que Zero")
    public double getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O preço é obrigatorio") @PositiveOrZero(message = "O valor não pode ser menor que Zero") double descricao) {
        this.descricao = descricao;
    }

    @NotNull(message = "O preço é obrigatorio")
    @PositiveOrZero(message = "O valor não pode ser menor que Zero")
    public double getPreco() {
        return preco;
    }

    public void setPreco(@NotNull(message = "O preço é obrigatorio") @PositiveOrZero(message = "O valor não pode ser menor que Zero") double preco) {
        this.preco = preco;
    }

    public @NotBlank(message = "URL é obrigatorio") String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(@NotBlank(message = "URL é obrigatorio") String urlImage) {
        this.urlImage = urlImage;
    }
}

