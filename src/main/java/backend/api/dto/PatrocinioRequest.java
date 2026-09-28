package backend.api.dto;

import java.math.BigDecimal;

public class PatrocinioRequest {

    private String nome;
    private String email;
    private String telefone;
    private String tipo;
    private BigDecimal valor;
    private String mensagem;
    private Boolean termos;

    public PatrocinioRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Boolean getTermos() {
        return termos;
    }

    public void setTermos(Boolean termos) {
        this.termos = termos;
    }
}