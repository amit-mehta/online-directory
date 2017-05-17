package org.onlinedirectory.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDetailModel {
    private Long id;
    private String serviceName;
    @NotNull(message = "Category cannot be null")
    @Valid
    private CategoryModel category;
    private List<ProviderModel> providers;
}
