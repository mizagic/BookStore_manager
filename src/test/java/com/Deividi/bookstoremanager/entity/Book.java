package com.Deividi.bookstoremanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private Integer chapters;

    @Column(nullable = false)
    private String  isbn;

    @Column(name = "publisher_Name", nullable = false,unique = true)
    private String publisherName;

   @ManyToOne(fetch = FetchType.LAZY, cascade =  {CascadeType.PERSIST, CascadeType.MERGE,  CascadeType.REMOVE}) // Ele faz um join para retornar um livro pelo nome do autor
   @JoinColumn(name = "author_id")
    private Author author;
}
