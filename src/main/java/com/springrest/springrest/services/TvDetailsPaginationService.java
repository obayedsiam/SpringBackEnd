package com.springrest.springrest.services;

import com.springrest.springrest.entities.TvDetails;
import com.springrest.springrest.repository.TvDetailsPaginationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TvDetailsPaginationService

{
    @Autowired
    TvDetailsPaginationRepository repository;

    public List<TvDetails> getAllTvDetails(Integer pageNo, Integer pageSize)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<TvDetails> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<TvDetails>();
        }
    }

    public List<TvDetails> getAllBySerialNumber(Integer pageNo, Integer pageSize)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<TvDetails> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<TvDetails>();
        }
    }
}