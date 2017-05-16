package org.dadabhagwan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


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
    @NotNull(message = "Service cannot be null")
    @Valid
    private ServiceDetailModel serviceDetail;
}
