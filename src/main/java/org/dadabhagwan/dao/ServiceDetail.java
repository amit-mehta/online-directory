package org.dadabhagwan.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "SERVICE")
public class ServiceDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SERVICE_ID")
    private Long id;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    @ManyToOne
    @JoinColumn(name = "SERVICE_CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy = "serviceDetail", orphanRemoval = true)
    private List<Provider> providers;
}
