package com.myproject.pastebox.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "Pastebox")
@Getter
@Setter
public class PasteboxEntity {

    @Id
    @GeneratedValue
    private Long id;

    @GeneratedValue
    private String hash;
    private String data;

    private LocalDateTime lifetime;

    private boolean isPublic;
}
