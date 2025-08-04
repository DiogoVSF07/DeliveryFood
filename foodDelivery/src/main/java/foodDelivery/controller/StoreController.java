package foodDelivery.controller;

import foodDelivery.dto.response.RegisterResponse;
import foodDelivery.entity.Store;
import foodDelivery.exception.ApiDeliveryException;
import foodDelivery.form.RegisterStoreForm;
import foodDelivery.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping(value = "/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/id")
    public Store searchById(@RequestParam Integer id) {
        return storeService.storeById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Store>> findAllStores() {
        List<Store> stores = storeService.storeFindAll();
        return ResponseEntity.ok(stores);
    }

    @PostMapping("/registerStore")
    public RegisterResponse registerStore(@RequestBody @Valid RegisterStoreForm form, BindingResult result) {
        if (result.hasErrors()) {
            String mensagens = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(" | "));

            throw new ApiDeliveryException("Erro de validação: " + mensagens, BAD_REQUEST);
        }

        Store store = storeService.registerStore(form);
        return new RegisterResponse("Cadastro realizado com sucesso", store.getId());
    }

}
