package pl.uwm.faculty.facultative.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 *  JPA repository of user's items
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findItemEntityById(Long id);

    @Query(value = "SELECT * FROM items WHERE item_name LIKE :name", nativeQuery = true)
    Page<ItemEntity> findAllByItemNameBeginningWith(@Param("name") String name, Pageable pageable);


}
