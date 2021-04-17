package com.allo.hrpayroll.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Worker {

    private Long id;

    private String name;

    private Double dailyIncome;
}
