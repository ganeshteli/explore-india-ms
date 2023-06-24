package com.gt.exploreindia.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.gt.exploreindia.domain.TourPackage;

@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends PagingAndSortingRepository<TourPackage, String>{
    
    Optional<TourPackage> findByName(String name);

    Optional<TourPackage>  findByCode(String code);

    @Override
    @RestResource(exported = false)
    default void delete(TourPackage entity) {
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
    default void deleteAllById(Iterable<? extends String> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    @RestResource(exported = false)
    default void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
