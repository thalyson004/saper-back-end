package com.saper.backend.service;

import com.saper.backend.dto.BoxRequestDTO;
import com.saper.backend.dto.BoxResponseDTO;
import com.saper.backend.model.Box;
import com.saper.backend.model.Client;
import com.saper.backend.repository.BoxRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    BoxRespository boxRespository;

    public List<BoxResponseDTO> findAll(String name, int min, int max) {
        return boxRespository.findAllByNameContainingIgnoreCaseAndCapacityGreaterThanEqualAndCapacityLessThanEqual(name, min, max).stream().map(BoxResponseDTO::new).toList();
    }

    @Transactional
    public BoxRequestDTO save(BoxRequestDTO boxRequestDTO) {
        Box box = new Box();
        box.setCapacity(boxRequestDTO.getCapacity());
        box.setName(boxRequestDTO.getName());
        box.setCreated_by("Admin");
        boxRespository.save(box);

        return boxRequestDTO;
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Box box = boxRespository.findById(id).orElseThrow();
        boxRespository.delete(box);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, BoxRequestDTO boxRequestDTO) {
        Optional<Box> boxOptional = boxRespository.findById(id);
        if(boxOptional.isPresent()){
            Box box = boxOptional.get();

            if(boxRequestDTO.getCapacity()!=0){
                box.setCapacity(boxRequestDTO.getCapacity());
            }
            if(boxRequestDTO.getName()!=null){
                box.setName(boxRequestDTO.getName());
            }

            BoxResponseDTO boxResponseDTO = new BoxResponseDTO(boxRespository.save(box));

            return ResponseEntity.status(HttpStatus.OK).body(boxResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado");
        }
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Box> box = boxRespository.findById(id);

        if(box.isPresent()){
            return ResponseEntity.ok().body(new BoxResponseDTO(box.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado");
        }
    }
}
