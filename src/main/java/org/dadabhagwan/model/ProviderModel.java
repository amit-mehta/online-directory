package org.dadabhagwan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderModel {
    private Long id;
    private String providerName;
    private String contact;
    private String reference;
    private ServiceDetailModel serviceDetail;
}
