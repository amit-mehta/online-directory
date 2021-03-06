package org.onlinedirectory.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
    @NotNull(message = "Category Id cannot be null")
    private Long id;
    private String name;
    private List<ServiceDetailModel> serviceDetails;
}
