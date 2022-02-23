package com.example.MyBankApi.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="KONTO")
public class Konto {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name ="MONEY")
    private Double money;

    @Column(name = "CREATIONDATE")
    private Date birthday;

    @Column(name = "BLOCKED")
    private  Boolean blocked;

    @Column(name = "CUSTOMER_ID")
    private Long customer_id;

}
