package org.dadabhagwan.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PROVIDER")
public class Provider {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PROVIDER_NAME")
    private String providerName;

    @Column(name = "CONTACT")
    private String contact;

    @Column
    private String reference;

    @ManyToOne
    @JoinColumn(name = "PROVIDER_SERVICE_ID")
    private ServiceDetail serviceDetail;

}
