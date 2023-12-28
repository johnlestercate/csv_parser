package in.purabtech.csvupload.repository;

import in.purabtech.csvupload.model.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Long> {

    @Query("SELECT COUNT(a) from ApplicationForm a where lower(a.pFname) = lower(:fName) and lower(a.pMname) = lower(:mName) and lower(a.pLname) = lower(:lName)" )
    int count(@Param("fName") String fName, @Param("mName") String mName, @Param("lName") String lName);


}
