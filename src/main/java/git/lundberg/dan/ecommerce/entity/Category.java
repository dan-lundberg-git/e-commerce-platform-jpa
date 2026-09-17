//package git.lundberg.dan.ecommerce.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "categories")
//@Getter
//@Setter
//@NoArgsConstructor
//public class Category {
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
//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    private List<Product> products = new ArrayList<>();
//}
