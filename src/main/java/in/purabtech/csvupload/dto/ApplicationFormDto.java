package in.purabtech.csvupload.dto;


import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ApplicationFormDto {


    private Long cellNo;
    private String pFname;

    private String pMname;

    private String pLname;

    private String pDob;

    private String pPob;

    private String pStatus;

    private String pCitizenship;

    private String pTinNo;

    private String pSssNo;

    private String pTelNo;

    private String pMobileNo;

    private String pEmailAdd;

    private String pMotherMaiden;

    private String pAddress;

    private String pNoOfYrsStayed;

    private String pebiEmploymentBusinessName;

    private String pebiBusinessAddress;

    private String pebiPosition;

    private String pebiTelNo;

    private String pebiLos;

    private String pebiMonthlyIncome;

    private String pebiOtherSource;

    private String pebiOtherSourceAddress;

    private String pebiOtherSourcePosition;

    private String pebiOtherSourceTelNo;

    private String pebiOtherLos;

    private String pebiOtherMonthlIncome;

    private String pbdBankName;

    private String pbdBranch;

    private String pbdAccoutNo;


    /*
    CO BORROWER
     */
    private String cFname;

    private String cMname;

    private String cLname;

    private String cDob;

    private String cPob;

    private String cRelationToPrincipal;

    private String cCitizenship;

    private String cTinNo;

    private String cSssNo;

    private String cTelNo;

    private String cMobileNo;

    private String cEmailAdd;

    private String cMotherMaiden;

    private String cAddress;

    private String cNoOfYrsStayed;
    private String copebiEmploymentBusinessName;

    private String copebiBusinessAddress;

    private String copebiPosition;

    private String copebiTelNo;

    private String copebiLos;

    private String copebiMonthlyIncome;

    private String copebiOtherSource;

    private String copebiOtherSourceAddress;

    private String copebiOtherSourcePosition;

    private String copebiOtherSourceTelNo;

    private String copebiOtherLos;

    private String copebiOtherMonthlIncome;

    private String copbdBankName;

    private String copbdBranch;

    private String copbdAccoutNo;

    private String unit;
    private String unitPrice;
    private String downPayment;
    private String noOfMonths;
    private String color;
    private String amountFinance;
    private String rate;



}
