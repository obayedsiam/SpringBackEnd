package com.springrest.springrest.services;

import com.springrest.springrest.entities.TvDetails;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface SonyTvService {

    void save(MultipartFile file);

    List<TvDetails> getTvDetails();

    List<TvDetails> getListByAny(String m, String c, String s, LocalDate d);

    TvDetails getTvDetails(long id);

    TvDetails addTvDetails(TvDetails tvDetails);

    TvDetails updateTvDetails(TvDetails tvDetails);

    List<TvDetails> getListByDate(LocalDate date);

    List<TvDetails> getListByMobileNumber(String mobileNumber);

    List<TvDetails> getListBySerialNumber(String serialNumber);

    List<TvDetails> getListByCallStatus(String callStatus);

   /* public List<TvDetails> getListByCallStatusAndMobileNumber(String callStatus);
    public List<TvDetails> getListByCallStatusAndMobileNumberAndSerialNumber(String callStatus);
    public List<TvDetails> getListByCallStatusAndMobileNumberAndSerialNumber(String callStatus);
        public List<TvDetails> getListBySerialNumberAndMobileNumber(String serialNumber);
 public List<TvDetails> getListByDateAndMobileNumber(LocalDate date);
    public List<TvDetails> getListByDateAndMobileNumberAndSerialNUmber(LocalDate date);
    public List<TvDetails> getListByDateAndMobileNumberAndSerialNUmberAndCallStatus(LocalDate date);


*/


    List<TvDetails> getListForLast(int days) throws FileNotFoundException, JRException;

    void deleteTvDetails(long id);
}
