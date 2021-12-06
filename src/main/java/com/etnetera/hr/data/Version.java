package com.etnetera.hr.data;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Version {
    @Id
    private Long id;
    @Column(nullable = false, length = 30)
    private String name;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "javaScriptFramework_id")
    @JsonBackReference
    private JavaScriptFramework javaScriptFramework;
}
