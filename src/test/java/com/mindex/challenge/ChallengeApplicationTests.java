package com.mindex.challenge;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

    @Autowired
	private EmployeeService employeeService;

    @Autowired
	private CompensationService compensationService;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindReport(){
		String emp_id = "16a596ae-edd3-4847-99fe-c4518e82c86f";//John
		ReportingStructure reportingStructure = employeeService.getReport(emp_id);
		assertTrue(reportingStructure != null);
		assertTrue(reportingStructure.getNumberOfReports() == 4);
	}

	@Test
	public void testCompensation(){
		String employeeId = "dkladklsdkaldkfslsdalll22dx-ds-2222";
		int salary = 999;
		String effectiveDate = "2020-03-03";
		Compensation compensation = new Compensation(employeeId,salary,effectiveDate);
		Compensation res = compensationService.createCompensation(compensation);
		assertTrue(res!=null);
		assertTrue(res.getEmployeeId().equals(employeeId));
	}

}
