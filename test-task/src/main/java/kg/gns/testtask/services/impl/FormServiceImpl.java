package kg.gns.testtask.services.impl;

import kg.gns.testtask.dao.FormRepo;
import kg.gns.testtask.mapper.FormMapper;
import kg.gns.testtask.mapper.FormMapperClassFixed;
import kg.gns.testtask.models.Form;
import kg.gns.testtask.models.dto.FormDto;
import kg.gns.testtask.services.EmailService;
import kg.gns.testtask.services.FormService;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Random;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepo formRepo;
    @Autowired
    EmailService emailService;
    @Autowired
    FormMapperClassFixed formMapperClassFixed;

//    FormMapperNew formMapper = FormMapperNew.INSTANCE;

    @Override
    public ResponseEntity<?> save(FormDto formDto) {
        System.out.println(formDto.getEmail());
        Form form = formMapperClassFixed.toForm(formDto);
        System.out.println(form.getEmail());
        Form savedForm = formRepo.save(form);
        if(Objects.isNull(savedForm)){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }

        boolean isApproved = getRandomBoolean();
        String message;
        if (isApproved){
            message = "Успешно одобрено";
        }else {
            message = "Ваша заявка не одобрена";
        }
        String subject = "Оформление заявки";
        try {
            emailService.sendMessage(form.getEmail(), subject, message);
        }catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(savedForm, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findAll(Integer pageNo, Integer size) {
        Pageable pageRequest = PageRequest.of(pageNo, size);
        Page<Form> forms = formRepo.findAll(pageRequest);
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @Override
    public boolean isApproved(String login, String password) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<?> response
                = restTemplate.getForEntity(fooResourceUrl + "?login=" + login + "&password=" + password, Boolean.class);
        if (response.getStatusCode() == HttpStatus.OK){
            return (Boolean) response.getBody();
        }
        return false;
    }

    public boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }


}
