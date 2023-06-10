package com.example.pfa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;

    private String type;

    @Column(length = 50000000)
    private byte[] imgByte;

    @ManyToOne
    private Annonce annonce;


    public Image(String contentType, byte[] bytes) {
        this.type=contentType;
        this.imgByte=bytes;
    }
}
