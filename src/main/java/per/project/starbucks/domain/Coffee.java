package per.project.starbucks.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString
@Table(name = "coffees")
@Entity
public class Coffee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "price")
    private Integer price;

    public Coffee change(Coffee coffee) {
        this.name = getModificationValue(this.name, coffee.name);
        this.englishName = getModificationValue(this.englishName, coffee.englishName);
        this.description = getModificationValue(this.description, coffee.description);
        this.imageUrl = getModificationValue(this.imageUrl, coffee.imageUrl);
        this.price = getModificationValue(this.price, coffee.price);

        return this;
    }

    private <T> T getModificationValue(T oldValue, T newValue) {
        return newValue != null ? newValue : oldValue;
    }
}
