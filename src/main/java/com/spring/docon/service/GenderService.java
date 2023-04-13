package com.spring.docon.service;

import com.spring.docon.entity.GenderEntity;
import com.spring.docon.mapper.GenderMapper;
import com.spring.docon.repository.GenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    private final GenderMapper genderMapper;
    private final GenderRepository genderRepository;

    public GenderService(GenderMapper genderMapper, GenderRepository genderRepository) {
        this.genderMapper = genderMapper;
        this.genderRepository = genderRepository;
    }

    public List<GenderEntity> getGender() {
        List<GenderEntity> gender = genderRepository.findAll();
        return gender;

    }
}
