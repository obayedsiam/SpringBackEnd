package com.springrest.springrest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.springrest.springrest.entities.TvDetails;


public interface TvDetailsPaginationRepository extends PagingAndSortingRepository<TvDetails, Long>
{

}
