package org.dadabhagwan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDetailModel {
    private Long id;
    private String serviceName;
    @Valid
    private CategoryModel category;
    private List<ProviderModel> providers;
}
