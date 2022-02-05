package com.springrest.springrest.controller;

import com.springrest.springrest.entities.TvDetails;
import com.springrest.springrest.exporter.UserExcelExporter;
import com.springrest.springrest.helper.Helper;
import com.springrest.springrest.services.SonyTvServiceImpl;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class SonyTvController {

    @Autowired
    private SonyTvServiceImpl service;

    //Upload a file containing data
    @PostMapping("/TvDetails/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkContent(file)) {
            //true

            this.service.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }



    // Get All Lists
    @CrossOrigin
    @GetMapping("/TvDetails")
    public List<TvDetails> getTvDetails() {
        return this.service.getTvDetails();
    }

    // Get TvDetails with id
    @CrossOrigin
    @GetMapping("/getList/id/{id}")
    public TvDetails getTvDetails(@PathVariable long id)
    {
        return this.service.getTvDetails(id);
    }

    // Get TvDetails with date
    @CrossOrigin
    @GetMapping("/getList/date/{date}")
    public List<TvDetails> getListByDate(@PathVariable String date) throws ParseException {
        Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return this.service.getListByDate(newDate);
    }

    @CrossOrigin
    @GetMapping("/getList/mobile/{mobileNumber}")
    public List<TvDetails> getListByMobile(@PathVariable String mobileNumber)
    {
        return this.service.getListByMobileNumber(mobileNumber);
    }

    @CrossOrigin
    @GetMapping("/getList/callStatus/{callStatus}")
    public List<TvDetails> getListByCallStatus(@PathVariable String callStatus)
    {
        return this.service.getListByCallStatus(callStatus);
    }

    @CrossOrigin
    @GetMapping("/getList/serial/{serialNumber}")
    public List<TvDetails> getListBySerialNumber(@PathVariable String serialNumber)
    {
        return this.service.getListBySerialNumber(serialNumber);
    }

    // Get the list of TvDetails with previous number of days
    @CrossOrigin
    @GetMapping("/getListForLast/{days}")
    public List<TvDetails> getListForLast(@PathVariable int days) throws JRException, FileNotFoundException {
        return this.service.getListForLast(days);
    }

    // Add new Tv Details
    @CrossOrigin
    @PostMapping("/TvDetails")
    public TvDetails addTvDetails(@RequestBody TvDetails tvDetails) {
        return this.service.addTvDetails(tvDetails);
    }

    //Update Tv Details with Id
    @CrossOrigin
    @PutMapping("/TvDetails/edit/{id}")
    public TvDetails updateTvDetails(@RequestBody TvDetails tvDetails) {
        return this.service.updateTvDetails(tvDetails);
    }

    @GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<TvDetails> tvDetails = service.getTvDetails();

        UserExcelExporter excelExporter = new UserExcelExporter(tvDetails);

        excelExporter.export(response);
    }


    //Delete Tv Details with Id
    @CrossOrigin
    @DeleteMapping("/TvDetails/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long id) {
        try {
            this.service.deleteTvDetails(Long.parseLong(String.valueOf(id)));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
