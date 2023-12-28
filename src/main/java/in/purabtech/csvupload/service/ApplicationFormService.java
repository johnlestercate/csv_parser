package in.purabtech.csvupload.service;

import in.purabtech.csvupload.dto.ApplicationFormDto;
import in.purabtech.csvupload.helper.CSVHelper;
import in.purabtech.csvupload.model.ApplicationForm;
import in.purabtech.csvupload.repository.ApplicationFormRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRSaver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ApplicationFormService {

    @Autowired
    ApplicationFormRepository applicationFormRepository;

    public ApplicationForm updateDetails (Long id , ApplicationFormDto applicationFormDto) {

        return applicationFormRepository.save(ApplicationForm.builder()
                .id(id)
                .pFname(applicationFormDto.getPFname())
                .pMname(applicationFormDto.getPMname())
                .pLname(applicationFormDto.getPLname())
                .pDob(applicationFormDto.getPDob())
                .pPob(applicationFormDto.getPPob())
                .pStatus(applicationFormDto.getPStatus())
                .pCitizenship(applicationFormDto.getPCitizenship())
                .pTinNo(applicationFormDto.getPTinNo())
                .pSssNo(applicationFormDto.getPSssNo())
                .pMobileNo(applicationFormDto.getPMobileNo())
                .pEmailAdd(applicationFormDto.getPEmailAdd())
                .pMotherMaiden(applicationFormDto.getPMotherMaiden())
                .pAddress(applicationFormDto.getPAddress())
                .pNoOfYrsStayed(applicationFormDto.getPNoOfYrsStayed())
                .pebiEmploymentBusinessName(applicationFormDto.getPebiEmploymentBusinessName())
                .pebiBusinessAddress(applicationFormDto.getPebiBusinessAddress())
                .pebiPosition(applicationFormDto.getPebiPosition())
                .pebiTelNo(applicationFormDto.getPebiTelNo())
                .pebiLos(applicationFormDto.getPebiLos())
                .pebiMonthlyIncome(applicationFormDto.getPebiMonthlyIncome())
                .pebiOtherSource(applicationFormDto.getPebiOtherSource())
                .pebiOtherSourceAddress(applicationFormDto.getPebiOtherSourceAddress())
                .pebiOtherSourcePosition(applicationFormDto.getPebiOtherSourcePosition())
                .pebiOtherSourceTelNo(applicationFormDto.getPebiOtherSourceTelNo())
                .pebiOtherLos(applicationFormDto.getPebiOtherLos())
                .pebiOtherMonthlIncome(applicationFormDto.getPebiOtherMonthlIncome())
                .pbdBankName(applicationFormDto.getPbdBankName())
                .pbdBranch(applicationFormDto.getPbdBankName())
                .pbdAccoutNo(applicationFormDto.getPbdAccoutNo())
                .cFname(applicationFormDto.getCFname())
                .cMname(applicationFormDto.getCMname())
                .cLname(applicationFormDto.getCLname())
                .cDob(applicationFormDto.getCDob())
                .cPob(applicationFormDto.getCPob())
                .cRelationToPrincipal(applicationFormDto.getCRelationToPrincipal())
                .cCitizenship(applicationFormDto.getCCitizenship())
                .cTinNo(applicationFormDto.getCTinNo())
                .cSssNo(applicationFormDto.getCSssNo())
                .cMobileNo(applicationFormDto.getCMobileNo())
                .cEmailAdd(applicationFormDto.getCEmailAdd())
                .cMotherMaiden(applicationFormDto.getCMotherMaiden())
                .cAddress(applicationFormDto.getCAddress())
                .cNoOfYrsStayed(applicationFormDto.getCNoOfYrsStayed())
                .copebiEmploymentBusinessName(applicationFormDto.getCopebiEmploymentBusinessName())
                .copebiBusinessAddress(applicationFormDto.getCopebiBusinessAddress())
                .copebiPosition(applicationFormDto.getCopebiPosition())
                .copebiTelNo(applicationFormDto.getCopebiTelNo())
                .copebiLos(applicationFormDto.getCopebiLos())
                .copebiMonthlyIncome(applicationFormDto.getCopebiMonthlyIncome())
                .copebiOtherSource(applicationFormDto.getCopebiOtherSource())
                .copebiOtherSourceAddress(applicationFormDto.getCopebiOtherSourceAddress())
                .copebiOtherSourcePosition(applicationFormDto.getCopebiOtherSourcePosition())
                .copebiOtherSourceTelNo(applicationFormDto.getCopebiOtherSourceTelNo())
                .copebiOtherLos(applicationFormDto.getCopebiOtherLos())
                .copebiOtherMonthlIncome(applicationFormDto.getCopebiOtherMonthlIncome())
                .copbdBankName(applicationFormDto.getCopbdBankName())
                .copbdBranch(applicationFormDto.getCopbdBankName())
                .copbdAccoutNo(applicationFormDto.getCopbdAccoutNo())
                .unit(applicationFormDto.getUnit())
                .unitPrice(applicationFormDto.getUnitPrice())
                .downPayment(applicationFormDto.getDownPayment())
                .noOfMonths(applicationFormDto.getNoOfMonths())
                .color(applicationFormDto.getColor())
                .amountFinance(applicationFormDto.getAmountFinance())
                .rate(applicationFormDto.getRate())
                .build());

    }
}
