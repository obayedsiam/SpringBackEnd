package com.springrest.springrest.repository;

import com.springrest.springrest.entities.TvDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TvDetailsRepository extends JpaRepository<TvDetails,Long> {

    public List<TvDetails> findByDate(LocalDate date);
    public List<TvDetails> findByCallStatus(String callStatus);
    public List<TvDetails> findByMobileNumber(String mobileNumber);
    public List<TvDetails> findBySerialNumber(String serialNumber);

}
