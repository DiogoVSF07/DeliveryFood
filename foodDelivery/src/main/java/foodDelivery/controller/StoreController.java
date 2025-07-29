package foodDelivery.controller;

import foodDelivery.dto.response.RegisterResponse;
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

    @GetMapping("/id")
    public Store searchById(@RequestParam Integer id) {
        return storeService.storeById(id);
    }

    @PostMapping("/registerStore")
    public RegisterResponse registerStore(@RequestBody @Valid RegisterStoreForm form) {
        Store store = storeService.registerStore(form);
        return new RegisterResponse("Cadastro realizado com sucesso", store.getId());
    }
}
