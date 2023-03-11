package com.revature.allergysvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "allergy_master")
public class Allergy {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "allergy_name")
    private String name;

}
