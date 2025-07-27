package foodDelivery.controller;

import foodDelivery.entity.Store;
import foodDelivery.form.RegisterStoreForm;
import foodDelivery.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    public Store searchById(@PathVariable Integer id){
        return storeService.storeById(id);
    }

//    @PostMapping
//    public Store registerStore(@RequestBody @Valid RegisterStoreForm form){
//
//    }

}
