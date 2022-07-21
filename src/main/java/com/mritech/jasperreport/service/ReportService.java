package com.mritech.jasperreport.service;

import com.mritech.jasperreport.entity.Users;
import com.mritech.jasperreport.repo.UserRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private final UserRepo userRepo;

    public ReportService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public  String exportReport(String reportFormat) {

        try {
            String path = "D:\\tmp\\Report";
            List<Users> users = userRepo.findAll();

            //Load file and compile it
            File file = ResourceUtils.getFile("classpath:mrinmoy.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "Mrinmoy");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            if (reportFormat.equalsIgnoreCase("html")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\users.html");
            }
            if (reportFormat.equalsIgnoreCase("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\users.pdf");
            }

        }
        catch (FileNotFoundException | JRException e) {
            //return "";
            e.printStackTrace();
        }


        return "";
    }
}
