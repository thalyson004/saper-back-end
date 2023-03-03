package com.saper.backend.service;

import com.saper.backend.dto.BoxRequestDTO;
import com.saper.backend.dto.BoxResponseDTO;
import com.saper.backend.model.Box;
import com.saper.backend.repository.BoxRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService {

    @Autowired
    BoxRespository boxRespository;


    public List<BoxResponseDTO> findAll(String name) {
        if(name.equals("")) {
            return boxRespository.findAll().stream().map(BoxResponseDTO::new).toList();
        }else{
            return boxRespository.findAllByNameContainsIgnoreCase(name).stream().map(BoxResponseDTO::new).toList();
        }
    }

    public BoxRequestDTO save(BoxRequestDTO boxRequestDTO) {
        Box box = new Box();
        box.setCapacity(boxRequestDTO.getCapacity());
        box.setName(boxRequestDTO.getName());
        box.setCreated_by("Admin");
        boxRespository.save(box);

        return boxRequestDTO;
    }
}
