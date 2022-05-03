package kg.gns.testtask.services;

import kg.gns.testtask.models.Form;
import kg.gns.testtask.models.dto.FormDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FormService {

    ResponseEntity<?> save(FormDto formDto);

    ResponseEntity<?> findAll(Integer pageNo, Integer size);

    boolean isApproved(String login, String password);
}
