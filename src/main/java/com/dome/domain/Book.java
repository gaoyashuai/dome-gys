package com.dome.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "books",type = "library")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    @Id
    private String id;

    private String name;
}
