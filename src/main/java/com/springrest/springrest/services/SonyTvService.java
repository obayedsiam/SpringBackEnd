package com.springrest.springrest.services;

import com.springrest.springrest.entities.TvDetails;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public interface SonyTvService {

    public void save(MultipartFile file);
    public List<TvDetails> getTvDetails();
    public TvDetails getTvDetails(long id);
    public TvDetails addTvDetails(TvDetails tvDetails);
    public TvDetails updateTvDetails(TvDetails tvDetails);
    public List<TvDetails> getListByDate(Date date);
    public List<TvDetails> getListByCallStatus(String callStatus);
    public List<TvDetails> getListByMobileNumber(String mobileNumber);
    public List<TvDetails> getListBySerialNumber(String serialNumber);
    public List<TvDetails> getListForLast(int days) throws FileNotFoundException, JRException;
    public void deleteTvDetails(long id);
}
