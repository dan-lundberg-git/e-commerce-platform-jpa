//package git.lundberg.dan.ecommerce.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.Digits;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "products")
//@Getter
//@Setter
//@NoArgsConstructor
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, updatable = false)
//    private Long id;
//
//    @Size(max = 100)
//    @NotNull
//    @Column(name = "name", nullable = false, length = 100)
//    private String name;
//
//    // TODO: Check if this is correct
//    @NotNull
//    @DecimalMin(value = "0.0", inclusive = false)
//    @Digits(integer = 8, fraction = 2)
//    @Column(name = "price", nullable = false, precision = 10, scale = 2)
//    private BigDecimal price;
//
//    // TODO: Check if this is correct
//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(
//            name = "product_images",
//            joinColumns = @JoinColumn(name = "product_id")
//    )
//    @Column(name = "image_url", nullable = false, length = 500)
//    @OrderColumn(name = "display_order")
//    private List<String> imageUrls = new ArrayList<>();
//
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    // TODO: Connect Promotions, check documentation on how to
//
//}
