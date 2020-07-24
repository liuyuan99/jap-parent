package com.liuyuan.jpasc.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.servlet.annotation.MultipartConfig;
import java.io.Serializable;

@Data
@Entity
@ToString
@Table(name = "jpa_room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;
}
