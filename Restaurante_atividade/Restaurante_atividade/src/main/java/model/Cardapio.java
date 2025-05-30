package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_cardapio")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Pratos pratos;

    @NotNull(message = "O valor da entrada é obrigatório")
    private Double valorEntrada;

    @NotNull(message = "O valor do prato principal é obrigatório")
    private Double valorPratoPrincipal;

    @NotNull(message = "O valor da sobremesa é obrigatório")
    private Double valorSobremesa;

    @NotNull(message = "O valor da entrada é obrigatório")
    private Double quantidadeEntrada;

    @NotNull(message = "O valor do prato principal é obrigatório")
    private Double quantidadePrincipal;

    @NotNull(message = "O valor da sobremesa é obrigatório")
    private Double quantidadeSobremesa;

    public Cardapio(){
    }

    public Cardapio(Long id, Pratos pratos, Double valorEntrada,
                    Double valorPratoPrincipal, Double valorSobremesa,
                    Double quantidadeEntrada, Double quantidadePrincipal, Double quantidadeSobremesa) {
        this.id = id;
        this.pratos = pratos;
        this.valorEntrada = valorEntrada;
        this.valorPratoPrincipal = valorPratoPrincipal;
        this.valorSobremesa = valorSobremesa;
        this.quantidadeEntrada = quantidadeEntrada;
        this.quantidadePrincipal = quantidadePrincipal;
        this.quantidadeSobremesa = quantidadeSobremesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pratos getPratos() {
        return pratos;
    }

    public void setPratos(Pratos pratos) {
        this.pratos = pratos;
    }

    public @NotNull(message = "O valor da entrada é obrigatório") Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(@NotNull(message = "O valor da entrada é obrigatório") Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public @NotNull(message = "O valor do prato principal é obrigatório") Double getValorPratoPrincipal() {
        return valorPratoPrincipal;
    }

    public void setValorPratoPrincipal(@NotNull(message = "O valor do prato principal é obrigatório") Double valorPratoPrincipal) {
        this.valorPratoPrincipal = valorPratoPrincipal;
    }

    public @NotNull(message = "O valor da sobremesa é obrigatório") Double getValorSobremesa() {
        return valorSobremesa;
    }

    public void setValorSobremesa(@NotNull(message = "O valor da sobremesa é obrigatório") Double valorSobremesa) {
        this.valorSobremesa = valorSobremesa;
    }

    public @NotNull(message = "O valor da entrada é obrigatório") Double getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

    public void setQuantidadeEntrada(@NotNull(message = "O valor da entrada é obrigatório") Double quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }

    public @NotNull(message = "O valor do prato principal é obrigatório") Double getQuantidadePrincipal() {
        return quantidadePrincipal;
    }

    public void setQuantidadePrincipal(@NotNull(message = "O valor do prato principal é obrigatório") Double quantidadePrincipal) {
        this.quantidadePrincipal = quantidadePrincipal;
    }

    public @NotNull(message = "O valor da sobremesa é obrigatório") Double getQuantidadeSobremesa() {
        return quantidadeSobremesa;
    }

    public void setQuantidadeSobremesa(@NotNull(message = "O valor da sobremesa é obrigatório") Double quantidadeSobremesa) {
        this.quantidadeSobremesa = quantidadeSobremesa;
    }
}
