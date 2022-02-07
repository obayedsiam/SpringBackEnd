package com.springrest.springrest.repository;

import com.springrest.springrest.entities.TvDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    public List<TvDetails> findBySerialNumberAndMobileNumberAndCallStatusAndDate(String serialNumber, String mobileNumber, String callStatus, LocalDate date);

    public String var = "select e from TvDetails as e where " +
            "(:serialNumber != '' and e.serialNumber = :serialNumber) and " +
            "(:mobileNumber != '' and e.mobileNumber = :mobileNumber) and " +
            "(:callStatus != '' and e.callStatus = :callStatus) and " +
            "(:date != '' and e.date = :date)";

    @Query (var)
    public List<TvDetails> find(@Param("serialNumber") String serialNumber, @Param("mobileNumber") String mobileNumber, @Param("callStatus") String callStatus, @Param("date") LocalDate date);




}
