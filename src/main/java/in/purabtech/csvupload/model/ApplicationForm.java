package in.purabtech.csvupload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="application_form")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicationForm {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "pFname")
    private String pFname;

    @Column(name = "pMname")
    private String pMname;

    @Column(name = "pLname")
    private String pLname;

    @Column(name = "pDob")
    private String pDob;

    @Column(name = "pPob")
    private String pPob;

    @Column(name = "pStatus")
    private String pStatus;

    @Column(name = "pCitizenship")
    private String pCitizenship;

    @Column(name = "pTinNo")
    private String pTinNo;

    @Column(name = "pSssNo")
    private String pSssNo;

    @Column(name = "pTelNo")
    private String pTelNo;

    @Column(name = "pMobileNo")
    private String pMobileNo;

    @Column(name = "pEmailAdd")
    private String pEmailAdd;

    @Column(name = "pMotherMaiden")
    private String pMotherMaiden;

    @Column(name = "pAddress")
    private String pAddress;

    @Column(name = "noOfYrsStayed")
    private String pNoOfYrsStayed;


    @Column(name = "pebi_employment_business_name")
    private String pebiEmploymentBusinessName;

    @Column(name = "pebi_business_address")
    private String pebiBusinessAddress;


    @Column(name = "pebi_position")
    private String pebiPosition;

    @Column(name = "pebi_telNo")
    private String pebiTelNo;

    @Column(name = "pebi_los")
    private String pebiLos;

    @Column(name = "pebi_monthlyIncome")
    private String pebiMonthlyIncome;


    /**
     * Other Source Of Income
     */

    @Column(name = "pebi_other_source")
    private String pebiOtherSource;

    @Column(name = "pebi_other_source_address")
    private String pebiOtherSourceAddress;

    @Column(name = "pebi_other_source_position")
    private String pebiOtherSourcePosition;

    @Column(name = "pebi_other_source_telNo")
    private String pebiOtherSourceTelNo;

    @Column(name = "pebi_other_los")
    private String pebiOtherLos;

    @Column(name = "pebi_other_monthl_income")
    private String pebiOtherMonthlIncome;

    @Column(name = "pbd_bankName")
    private String pbdBankName;

    @Column(name = "pbd_branch")
    private String pbdBranch;

    @Column(name = "pbd_accoutNo")
    private String pbdAccoutNo;


    /*
    co borrower
     */

    @Column(name = "cFname")
    private String cFname;

    @Column(name = "cMname")
    private String cMname;

    @Column(name = "cLname")
    private String cLname;

    @Column(name = "cDob")
    private String cDob;

    @Column(name = "cPob")
    private String cPob;

    @Column(name = "cRelationToPrincipal")
    private String cRelationToPrincipal;

    @Column(name = "cCitizenship")
    private String cCitizenship;

    @Column(name = "cTinNo")
    private String cTinNo;

    @Column(name = "cSssNo")
    private String cSssNo;

    @Column(name = "cTelNo")
    private String cTelNo;

    @Column(name = "cMobileNo")
    private String cMobileNo;

    @Column(name = "cEmailAdd")
    private String cEmailAdd;

    @Column(name = "cMotherMaiden")
    private String cMotherMaiden;

    @Column(name = "cAddress")
    private String cAddress;

    @Column(name = "cNoOfYrsStayed")
    private String cNoOfYrsStayed;


    @Column(name = "copebi_employment_business_name")
    private String copebiEmploymentBusinessName;

    @Column(name = "copebi_business_address")
    private String copebiBusinessAddress;


    @Column(name = "copebi_position")
    private String copebiPosition;

    @Column(name = "copebi_telNo")
    private String copebiTelNo;

    @Column(name = "copebi_los")
    private String copebiLos;

    @Column(name = "copebi_monthlyIncome")
    private String copebiMonthlyIncome;


    /**
     * Other Source Of Income
     */

    @Column(name = "copebi_other_source")
    private String copebiOtherSource;

    @Column(name = "copebi_other_source_address")
    private String copebiOtherSourceAddress;

    @Column(name = "copebi_other_source_position")
    private String copebiOtherSourcePosition;

    @Column(name = "copebi_other_source_telNo")
    private String copebiOtherSourceTelNo;

    @Column(name = "copebi_other_los")
    private String copebiOtherLos;

    @Column(name = "copebi_other_monthl_income")
    private String copebiOtherMonthlIncome;


    @Column(name = "copbd_bankName")
    private String copbdBankName;

    @Column(name = "copbd_branch")
    private String copbdBranch;

    @Column(name = "copbd_accoutNo")
    private String copbdAccoutNo;

    // Vehicle Info

    private String unit;
    private String unitPrice;
    private String downPayment;
    private String noOfMonths;
    private String color;
    private String amountFinance;
    private String rate;

    private Boolean downloaded;

}
