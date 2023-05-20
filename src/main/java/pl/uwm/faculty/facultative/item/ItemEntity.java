package pl.uwm.faculty.facultative.item;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import pl.uwm.faculty.facultative.global.GlobalEntity;
import pl.uwm.faculty.facultative.user.UserEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *  Entity of user's items
 */
@Table(name = "items")
@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemEntity extends GlobalEntity implements Serializable {

    String itemName;
    String description;
    Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "user_id", nullable = true)
    @JsonBackReference
    UserEntity userId;

    @Builder
    public ItemEntity(
            String itemName,
            String description,
            Double price,
            UserEntity userId

    ) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.userId = userId;
    }

    public ItemResponseDTO toItemResponseDTO() {
        return ItemResponseDTO
                .builder()
                .itemName(this.itemName)
                .description(this.description)
                .price(this.price)
                .build();
    }
}
