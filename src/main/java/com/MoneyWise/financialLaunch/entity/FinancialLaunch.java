package com.MoneyWise.financialLaunch.entity;

import com.MoneyWise.category.entity.Category;
import com.MoneyWise.generic.enums.Operation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FinancialLaunch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 40)
    private String description;

    private LocalDate registrationDate;

    private LocalDate operationDate;

    private Boolean parcel;

    private Integer numberOfParcels;

    private Double value;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Operation operation;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
