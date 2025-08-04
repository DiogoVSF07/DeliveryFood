package foodDelivery.service;

import foodDelivery.entity.Status;
import foodDelivery.entity.Store;
import foodDelivery.exception.ApiDeliveryException;
import foodDelivery.form.RegisterStoreForm;
import foodDelivery.repository.StoreRepository;
import foodDelivery.util.FormatString;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static foodDelivery.util.FormatString.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store storeById(Integer idStore){
        if (idStore == null || idStore <= 0) {
            throw new ApiDeliveryException("Informe um ID válido.", BAD_REQUEST);
        }
        return storeRepository.findById(idStore)
                .orElseThrow(() -> new ApiDeliveryException("Loja não encontrada com id:" + idStore, NOT_FOUND));
    }

    public List<Store> storeFindAll(){
        return storeRepository.findAll();
    }

    public Store registerStore(RegisterStoreForm form) {

        LocalDateTime now = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();

        if(!documentFormat(form.getTaxId())){
            throw new ApiDeliveryException("O documento CNPJ/CPF é obrigatório e deve ser um número válido!", BAD_REQUEST);
        }
        if(!zipCodeFormat(form.getZipCode())){
            throw new ApiDeliveryException("O CEP é obrigatório e deve ser um número válido!", BAD_REQUEST);
        }
        if (storeRepository.findByTaxId(form.getTaxId()).isPresent()) {
            throw new ApiDeliveryException("CPF ou CNPJ já cadastrado.", HttpStatus.CONFLICT);
        }

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