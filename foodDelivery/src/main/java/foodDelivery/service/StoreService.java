package foodDelivery.service;

import foodDelivery.entity.Status;
import foodDelivery.entity.Store;
import foodDelivery.form.RegisterStoreForm;
import foodDelivery.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store storeById(Integer idStore){
        return storeRepository.findById(idStore)
                .orElseThrow(() -> new EntityNotFoundException("Loja não encontrada com id:" + idStore));
    }

//    public Store storeFindAll(Integer idStore, String taxId, String status){
//        return storeRepository.findAllById(idStore, taxId, status)
//                .orElseThrow(() -> new EntityNotFoundException("Loja não encontrada com id:" + idStore));
//    }

    public Store registerStore(RegisterStoreForm form) {

        LocalDateTime now = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();

        Store store = new Store();
        store.setTaxId(form.getTaxId());
        store.setTradeName(form.getTradeName());
        store.setCorporateName(form.getCorporateName());
        store.setStreet(form.getStreet());
        store.setNumber(form.getNumber());
        store.setDistrict(form.getDistrict());
        store.setCity(form.getCity());
        store.setState(form.getState());
        store.setZipCode(form.getZipCode());
        store.setStatus(Status.ativo);
        store.setCreatedAt(now);
        store.setUpdatedAt(now);

        return storeRepository.save(store);
    }
}