package com.springrest.springrest.helper;

import com.springrest.springrest.entities.TvDetails;
import net.sf.jasperreports.data.cache.NumberToDateTransformer;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    public static boolean checkContent(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }
        else return false;
    }

    public static List<TvDetails> convertExcelToListOfProduct(InputStream is) {
        List<TvDetails> list = new ArrayList<>();

        try {
            DataFormatter formatter = new DataFormatter();

            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("Data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                TvDetails tvDetails = new TvDetails();

                while (cells.hasNext()) {
                    Cell cell = cells.next();



                    switch (cid) {
                        case 0:
                          //  tvDetails.setId((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            if(cell.getCellType()== CellType.STRING)
                                tvDetails.setCallStatus(cell.getStringCellValue());
                            else if(cell.getCellType()==CellType.NUMERIC)
                                tvDetails.setCallStatus(String.valueOf(cell.getNumericCellValue()));

                            break;
                        case 2:
                            if(cell.getCellType()== CellType.STRING)
                                tvDetails.setDate(cell.getLocalDateTimeCellValue().toLocalDate());
                            else if(cell.getCellType()==CellType.NUMERIC)
                                tvDetails.setDate(cell.getLocalDateTimeCellValue().toLocalDate());

                            break;
                        case 3:

                            if(cell.getCellType()== CellType.STRING)
                                tvDetails.setMobileNumber(cell.getStringCellValue());
                            else if(cell.getCellType()==CellType.NUMERIC)
                                tvDetails.setMobileNumber(NumberToTextConverter.toText(cell.getNumericCellValue()));

                            break;
                        case 4:
                            if(cell.getCellType()== CellType.STRING)
                                tvDetails.setSerialNumber(cell.getStringCellValue());
                            else if(cell.getCellType()==CellType.NUMERIC)
                                tvDetails.setSerialNumber(NumberToTextConverter.toText(cell.getNumericCellValue()));

                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(tvDetails);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

}
