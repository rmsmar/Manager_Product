package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;

    public Book(int id, int price, String name, String author) {
        super(id, price, name);
        this.author = author;
    }
}

