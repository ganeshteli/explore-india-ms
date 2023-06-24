package com.gt.exploreindia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.exploreindia.domain.TourPackage;
import com.gt.exploreindia.repository.TourPackageRepository;

@Service
public class TourPackageService {

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository){
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name){
        return tourPackageRepository.findByCode(code).orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }

    public Long total(){
        return tourPackageRepository.count();
    }
    
}
