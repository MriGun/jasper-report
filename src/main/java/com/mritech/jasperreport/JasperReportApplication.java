package com.mritech.jasperreport;

import com.mritech.jasperreport.entity.Users;
import com.mritech.jasperreport.repo.UserRepo;
import com.mritech.jasperreport.service.ReportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class JasperReportApplication {

    private final UserRepo userRepo;
    private final ReportService reportService;

    public JasperReportApplication(UserRepo userRepo, ReportService reportService) {
        this.userRepo = userRepo;
        this.reportService = reportService;
    }

    @GetMapping("/users-list")
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) {
        return reportService.exportReport(format);
    }

    public static void main(String[] args) {
        SpringApplication.run(JasperReportApplication.class, args);
        System.out.println("Hello Jasper Report");
    }

}
