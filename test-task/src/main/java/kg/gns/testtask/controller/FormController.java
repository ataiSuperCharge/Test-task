package kg.gns.testtask.controller;

import kg.gns.testtask.models.Form;
import kg.gns.testtask.models.dto.FormDto;
import kg.gns.testtask.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/form")
public class FormController {
    @Autowired
    private FormService formService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FormDto form){
    return formService.save(form);
    }

    @GetMapping("/get/pageable")
    public ResponseEntity<?> getAll(@RequestParam Integer pageNo, @RequestParam Integer size){
        return formService.findAll(pageNo, size);
    }
}
