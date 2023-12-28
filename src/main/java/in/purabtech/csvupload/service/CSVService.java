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
public class CSVService {

    @Autowired
    ApplicationFormRepository applicationFormRepository;

    public void save(MultipartFile file) {
        try {
            csvParser(file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    private void csvParser(InputStream is) {
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                 CSVParser csvParser = new CSVParser(fileReader,
                         CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

                List<ApplicationFormDto> dto = new ArrayList<>();
                Iterable<CSVRecord> csvRecords = csvParser.getRecords();


                for (CSVRecord csvRecord : csvRecords) {


                    dto.add(ApplicationFormDto.builder()
                            .pFname(csvRecord.get(2))
                            .pMname(csvRecord.get(3))
                            .pLname(csvRecord.get(4))
                            .pDob(csvRecord.get(5))
                            .pPob(csvRecord.get(6))
                            .pStatus(csvRecord.get(7))
                            .pCitizenship(csvRecord.get(8))
                            .pTinNo(csvRecord.get(9))
                            .pSssNo(csvRecord.get(10))
                            .pMobileNo(csvRecord.get(11))
                            .pEmailAdd(csvRecord.get(12))
                            .pMotherMaiden(csvRecord.get(13))
                            .pAddress(csvRecord.get(14))
                            .pNoOfYrsStayed(csvRecord.get(15))
                            .pebiEmploymentBusinessName(csvRecord.get(16))
                            .pebiBusinessAddress(csvRecord.get(17))
                            .pebiPosition(csvRecord.get(18))
                            .pebiTelNo(csvRecord.get(19))
                            .pebiLos(csvRecord.get(20))
                            .pebiMonthlyIncome(csvRecord.get(21))
                            .pebiOtherSource(csvRecord.get(22))
                            .pebiOtherSourceAddress(csvRecord.get(23))
                            .pebiOtherSourcePosition(csvRecord.get(24))
                            .pebiOtherSourceTelNo(csvRecord.get(25))
                            .pebiOtherLos(csvRecord.get(26))
                            .pebiOtherMonthlIncome(csvRecord.get(27))
                            .pbdBankName(csvRecord.get(28))
                            .pbdBranch(csvRecord.get(29))
                            .pbdAccoutNo(csvRecord.get(30))
                            // co Borrower parser
                            .cFname(csvRecord.get(31))
                            .cMname(csvRecord.get(32))
                            .cLname(csvRecord.get(33))
                            .cDob(csvRecord.get(34))
                            .cPob(csvRecord.get(35))
                            .cRelationToPrincipal(csvRecord.get(36))
                            .cCitizenship(csvRecord.get(37))
                            .cTinNo(csvRecord.get(38))
                            .cSssNo(csvRecord.get(39))
                            .cMobileNo(csvRecord.get(40))
                            .cEmailAdd(csvRecord.get(41))
                            .cMotherMaiden(csvRecord.get(42))
                            .cAddress(csvRecord.get(43))
                            .cNoOfYrsStayed(csvRecord.get(44))
                            .copebiEmploymentBusinessName(csvRecord.get(45))
                            .copebiBusinessAddress(csvRecord.get(46))
                            .copebiPosition(csvRecord.get(47))
                            .copebiTelNo(csvRecord.get(48))
                            .copebiLos(csvRecord.get(49))
                            .copebiMonthlyIncome(csvRecord.get(50))
                            .copebiOtherSource(csvRecord.get(51))
//                            .copebiOtherSourceAddress(csvRecord.get(52))
//                            .copebiOtherSourcePosition(csvRecord.get(53))
//                            .copebiOtherSourceTelNo(csvRecord.get(54))
//                            .copebiOtherLos(csvRecord.get(55))
//                            .copebiOtherMonthlIncome(csvRecord.get(56))
                            .copbdBankName(csvRecord.get(52))
                            .copbdBranch(csvRecord.get(53))
                            .copbdAccoutNo(csvRecord.get(54))
                            .build());


                }


                for (ApplicationFormDto applicationFormDto : dto) {
                    var duplicated = applicationFormRepository.count(applicationFormDto.getPFname().toLowerCase(),
                            applicationFormDto.getPMname().toLowerCase(), applicationFormDto.getPLname().toLowerCase());

                    if (duplicated > 0 ) {
                    log.debug("DO Nothing  : {}", duplicated);
                    } else {
                    applicationFormRepository.save(in.purabtech.csvupload.model.ApplicationForm.builder()
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
                            .copbdBranch(applicationFormDto.getCopbdBranch())
                            .copbdAccoutNo(applicationFormDto.getCopbdAccoutNo())
                            .build());
                }

                }

            } catch (IOException e) {
                throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
            }

    }


    public ByteArrayInputStream load(Long id) {
        ApplicationForm applicationForms = applicationFormRepository.findById(id).orElse(null);

        ByteArrayInputStream in = CSVHelper.booksToCSV(applicationForms);
        return in;
    }

    public void loadData(Long id) {
        InputStream applicationFormReport = getClass().getResourceAsStream("/jasperReport/applicationform2.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(applicationFormReport);
            JRSaver.saveObject(jasperReport, "jas.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parseData(id), new JREmptyDataSource());
            var fName = parseData(id).get("pFname");
            var lName = parseData(id).get("pLname");
            var fileName =  fName.toString().concat("_").concat(lName.toString());
            ApplicationForm form = applicationFormRepository.findById(id).orElse(null);
            form.setDownloaded(true);
            applicationFormRepository.save(form);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/jcate/Downloads/pdfs/"+fileName+".pdf");

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Object> parseData(Long id) {
        ApplicationForm applicationForm = applicationFormRepository.findById(id).orElse(null);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("pFname", applicationForm.getPFname());
        parameters.put("pMname", applicationForm.getPMname());
        parameters.put("pLname", applicationForm.getPLname());
        parameters.put("pDob", applicationForm.getPDob());
        parameters.put("pPob", applicationForm.getPPob());
        parameters.put("pStatus", applicationForm.getPStatus());
        parameters.put("pCitizenship", applicationForm.getPCitizenship());
        parameters.put("pTinNo", applicationForm.getPTinNo());
        parameters.put("pSssNo", applicationForm.getPSssNo());
        parameters.put("pTelNo", applicationForm.getPTelNo());
        parameters.put("pMobileNo", applicationForm.getPMobileNo());
        parameters.put("pEmailAdd", applicationForm.getPEmailAdd());
        parameters.put("pMothersMaiden", applicationForm.getPMotherMaiden());
        parameters.put("pAddress", applicationForm.getPAddress());
        parameters.put("pNos", applicationForm.getPNoOfYrsStayed());
        parameters.put("pebiEmploymentBusinessName", applicationForm.getPebiEmploymentBusinessName());
        parameters.put("pebiBusinessAddress", applicationForm.getPebiBusinessAddress());
        parameters.put("pebiPosition", applicationForm.getPebiPosition());
        parameters.put("pebiTelNo", applicationForm.getPebiTelNo());
        parameters.put("pebiLos", applicationForm.getPebiLos());
        parameters.put("pebiMonthlyIncome", applicationForm.getPebiMonthlyIncome());
        parameters.put("pebiOtherSource", applicationForm.getPebiOtherSource());
        parameters.put("pebiOtherSourceAddress", applicationForm.getPebiOtherSourceAddress());
        parameters.put("pebiOtherSourcePosition", applicationForm.getPebiOtherSourcePosition());
        parameters.put("pebiOtherSourceTelNo", applicationForm.getPebiOtherSourceTelNo());
        parameters.put("pebiOtherLos", applicationForm.getPebiOtherLos());
        parameters.put("pebiOtherMonthlIncome", applicationForm.getPebiOtherMonthlIncome());
        parameters.put("pbdBankName", applicationForm.getPbdBankName());
        parameters.put("pbdBranch", applicationForm.getPbdBranch());
        parameters.put("pbdAccoutNo", applicationForm.getPbdAccoutNo());
        parameters.put("cFname", applicationForm.getCFname());
        parameters.put("cMname", applicationForm.getCMname());
        parameters.put("cLname", applicationForm.getCLname());
        parameters.put("cDob", applicationForm.getCDob());
        parameters.put("cPob", applicationForm.getCPob());
        parameters.put("cRelationToPrincipal", applicationForm.getCRelationToPrincipal());
        parameters.put("cCitizenship", applicationForm.getCCitizenship());
        parameters.put("cTinNo", applicationForm.getCTinNo());
        parameters.put("cSssNo", applicationForm.getCSssNo());
        parameters.put("cTelNo", applicationForm.getCTelNo());
        parameters.put("cMobileNo", applicationForm.getCMobileNo());
        parameters.put("cEmailAdd", applicationForm.getCEmailAdd());
        parameters.put("cMothersMaiden", applicationForm.getCMotherMaiden());
        parameters.put("cAddress", applicationForm.getCAddress());
        parameters.put("cNos", applicationForm.getCNoOfYrsStayed());
        parameters.put("copebiEmploymentBusinessName", applicationForm.getCopebiEmploymentBusinessName());
        parameters.put("copebiBusinessAddress", applicationForm.getCopebiBusinessAddress());
        parameters.put("copebiPosition", applicationForm.getCopebiPosition());
        parameters.put("copebiTelNo", applicationForm.getCopebiTelNo());
        parameters.put("copebiLos", applicationForm.getCopebiLos());
        parameters.put("copebiMonthlyIncome", applicationForm.getCopebiMonthlyIncome());
        parameters.put("copebiOtherSource", applicationForm.getCopebiOtherSource());
        parameters.put("copebiOtherSourceAddress", applicationForm.getCopebiOtherSourceAddress());
        parameters.put("copebiOtherSourcePosition", applicationForm.getCopebiOtherSourcePosition());
        parameters.put("copebiOtherSourceTelNo", applicationForm.getCopebiTelNo());
        parameters.put("copebiOtherLos", applicationForm.getCopebiOtherLos());
        parameters.put("copebiOtherMonthlIncome", applicationForm.getCopebiOtherMonthlIncome());
        parameters.put("copbdBankName", applicationForm.getCopbdBankName());
        parameters.put("copbdBranch", applicationForm.getCopbdBranch());
        parameters.put("copbdAccoutNo", applicationForm.getCopbdAccoutNo());
        parameters.put("unit", applicationForm.getUnit());
        parameters.put("unitPrice", applicationForm.getUnitPrice());
        parameters.put("downPayment", applicationForm.getDownPayment());
        parameters.put("noOfMonths", applicationForm.getNoOfMonths());
        parameters.put("color", applicationForm.getColor());
        parameters.put("amountFinance", applicationForm.getAmountFinance());
        parameters.put("rate", applicationForm.getRate());


        return parameters;
    }
}
