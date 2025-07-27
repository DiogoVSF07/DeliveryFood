package foodDelivery.service;

import foodDelivery.entity.Store;
import foodDelivery.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;



    public Store storeById(Integer idStore){
        return storeRepository.findById(idStore)
                .orElseThrow(() -> new EntityNotFoundException("Loja não encontrada com id:" + idStore));
    }

}