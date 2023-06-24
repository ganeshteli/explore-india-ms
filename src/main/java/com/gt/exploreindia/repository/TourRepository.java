package com.gt.exploreindia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.gt.exploreindia.domain.Tour;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer>{

    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    @Override
    @RestResource(exported = false)
    default void delete(Tour entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @RestResource(exported = false)
    default void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    @RestResource(exported = false)
    default void deleteAll(Iterable<? extends Tour> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    @RestResource(exported = false)
    default void deleteAllById(Iterable<? extends Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    @RestResource(exported = false)
    default void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    
    
}
