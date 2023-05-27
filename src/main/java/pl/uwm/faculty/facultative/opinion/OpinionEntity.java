package pl.uwm.faculty.facultative.opinion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import pl.uwm.faculty.facultative.global.GlobalEntity;
import pl.uwm.faculty.facultative.item.ItemEntity;
import pl.uwm.faculty.facultative.user.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "opinions")
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OpinionEntity extends GlobalEntity {

    String opinion;
    Integer rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "item_id", nullable = true)
    @JsonBackReference
    ItemEntity itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "reviewer_id", nullable = true)
    @JsonBackReference
    UserEntity userId;

    @Builder
    public OpinionEntity(
            String opinion,
            Integer rate,
            ItemEntity itemId,
            UserEntity userId

    ) {
        this.opinion = opinion;
        this.rate = rate;
        this.itemId = itemId;
        this.userId = userId;
    }

    public OpinionResponseDTO toOpinionResponseDTO() {
        return OpinionResponseDTO
                .builder()
                .opinion(this.opinion)
                .rate(this.rate)
                .itemName(this.itemId.getItemName())
                .build();
    }

}
