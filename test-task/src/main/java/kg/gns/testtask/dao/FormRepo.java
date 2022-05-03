package kg.gns.testtask.dao;

import kg.gns.testtask.models.Form;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepo extends JpaRepository<Form, Long> , PagingAndSortingRepository<Form, Long> {

    Page<Form> findAll(Pageable pageable);

}
