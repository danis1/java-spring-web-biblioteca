package br.edu.fatecpg.apibiblioteca.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Livro {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o id automaticamente
    private Long id;

    @Column(nullable = false) // o campo não é nulo
    private String titulo;

    @Column(nullable = false) //não pode ser vazio
    private String autor;

    @Column(unique = true, nullable = false)
    private String isbn;

    private int ano;

    public Livro() {
    }

    public Livro(String titulo, String autor, String isbn, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

}


