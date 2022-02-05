package com.springrest.springrest.services;

import com.springrest.springrest.helper.Helper;
import com.springrest.springrest.repository.TvDetailsRepository;
import com.springrest.springrest.entities.TvDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.ZoneId;
import java.util.*;


import java.time.LocalDate;


@Service
public class SonyTvServiceImpl implements SonyTvService {

    @Autowired
    private TvDetailsRepository repository;


    public void save(MultipartFile file) {

        try {
            List<TvDetails> products = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.repository.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    @Override
    public List<TvDetails> getTvDetails() {
        return repository.findAll();
    }

    @Override
    public List<TvDetails> getListByDate(Date date) {
        return repository.findByDate(date);
    }

    @Override
    public List<TvDetails> getListByCallStatus(String callStatus) {
        return repository.findByCallStatus(callStatus);
    }

    @Override
    public List<TvDetails> getListByMobileNumber(String mobileNumber) {
        return repository.findByMobileNumber(mobileNumber);
    }

    @Override
    public List<TvDetails> getListBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }



    @Override
    public List<TvDetails> getListForLast(int days) throws FileNotFoundException, JRException {

        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate  = LocalDate.now();
        Date today = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        TvDetails tv = new TvDetails();
        ArrayList <TvDetails> list = new ArrayList<TvDetails>(10);


        for(int i=days; i>0;i--)
        {
            list.addAll(repository.findByDate(today));
            localDate = localDate.minusDays(1);
            today = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        }
        return list;
    }

  @Override
    public TvDetails getTvDetails(long id) {
        return repository.findById(id).get();
    }

    @Override
    public TvDetails addTvDetails(TvDetails tvDetails) {
        repository.save(tvDetails);
        return tvDetails;
    }

    @Override
    public TvDetails updateTvDetails(TvDetails tvDetails) {
        repository.save(tvDetails);
        return tvDetails;
    }

    @Override
    public void deleteTvDetails(long id) {
        repository.delete(repository.getById(id));
    }
}
