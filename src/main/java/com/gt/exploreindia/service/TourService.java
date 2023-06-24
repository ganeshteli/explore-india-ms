package com.gt.exploreindia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.exploreindia.domain.Difficulty;
import com.gt.exploreindia.domain.Region;
import com.gt.exploreindia.domain.Tour;
import com.gt.exploreindia.domain.TourPackage;
import com.gt.exploreindia.repository.TourPackageRepository;
import com.gt.exploreindia.repository.TourRepository;

@Service
public class TourService {

    private TourPackageRepository tourPackageRepository;

    private TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository){
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration,
            String bulltes, String keywords, String tourPackagename, Difficulty difficulty, Region region){
        
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackagename)
        .orElseThrow( () -> new RuntimeException("Tour Package does not exists" + tourPackagename));
        
        return tourRepository.save(new Tour(title, description, blurb, price, duration, 
        bulltes, keywords, tourPackage, difficulty, null));

    }

    public Long total(){
        return tourRepository.count();
    }
    
}
