package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Builder.Default
    private String title = "default title";
    @Builder.Default
    private Double price = 9.99;
    @Builder.Default
    private String description = "default description";
    @Builder.Default
    private String image = null;

}
