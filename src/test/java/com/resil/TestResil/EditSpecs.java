package com.resil.TestResil;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditSpecs extends Testbase
{
//	private static int n = 0;
	private String sheetName="SpecsEdit";
	
	@DataProvider(name="test")
	 public Object[][] dataSource()
	 {
	  return getData("TestData.xlsx", sheetName);
	    }
	 
	 @Test (dataProvider="test")
	public void Specification_Edit(String SpecsName, String SpecsType, String SpecsUOM, String SpecsPRNo, String SpecsTextValue, String SpecsOptionValue1, String SpecsOptionValue2,String SpecsOptionValue3,String SpecsOptionValue4, String SpecsRNFMin, String SpecsRNFMax, String SpecsRFMin, String SpecsRFMax, String SpecsFormula, String Result) throws Exception
	{
		 getWebElement("com.resil.TestResil.UserManagement.Menu").click();
			Testbase.Screenshot(driver, "Menu");
			getWebElement("com.resil.TestResil.SubModule.Master").click();
			Testbase.Screenshot(driver, "Master");
	     getWebElement("com.resil.TestResil.Specification.Specs_Tab").click();
	     getWebElement("com.resil.TestResil.Specification.Specs_EditButton").click();
//	     getWebElement("com.resil.TestResil.Specification.Specs_CopyButton").click();
	     getWebElement("com.resil.TestResil.Specification.Specs_Name").clear();
	     getWebElement("com.resil.TestResil.Specification.Specs_Name").sendKeys(SpecsName);
	     Select spctype = new Select(getWebElement("com.resil.TestResil.Specification.Specs_Type"));
	     spctype.selectByVisibleText(SpecsType);
	     switch(SpecsType)
		   {
		     case ("Plain - Text"):
		     {
		      getWebElement("com.resil.TestResil.Specification.Specs_TextValue").clear();
		      getWebElement("com.resil.TestResil.Specification.Specs_TextValue").sendKeys(SpecsTextValue);
		      break;
		     }
		     case ("Number"):
		     {
		      getWebElement("com.resil.TestResil.Specification.Specs_TextValue").clear();
		      getWebElement("com.resil.TestResil.Specification.Specs_TextValue").sendKeys(SpecsTextValue);
		      break;
		     }   
		     case ("Options - Text"):
		     {
		         WebElement opt1=getWebElement("com.resil.TestResil.Specification.Specs_Option1Value");
		         opt1.clear();
		         opt1.sendKeys(SpecsOptionValue1);
		         WebElement opt2=getWebElement("com.resil.TestResil.Specification.Specs_Option2Value");
		         opt2.clear();
		         opt2.sendKeys(SpecsOptionValue2);
		         WebElement opt3=getWebElement("com.resil.TestResil.Specification.Specs_Option3Value");
		         opt3.clear();
		         opt3.sendKeys(SpecsOptionValue3);
		         WebElement opt4=getWebElement("com.resil.TestResil.Specification.Specs_Option4Value");
		         opt4.clear();
		         opt4.sendKeys(SpecsOptionValue4);
		         getWebElement("com.resil.TestResil.Specification.Specs_Optionradiobtn1").click();
		         break;
		     }
		     case ("Options - Number"):
		     {
		      WebElement opn1=getWebElement("com.resil.TestResil.Specification.Specs_Option1Value");
		      opn1.clear();
		      opn1.sendKeys(SpecsOptionValue1);
		      WebElement opn2=getWebElement("com.resil.TestResil.Specification.Specs_Option2Value");
		      opn2.clear();
		      opn2.sendKeys(SpecsOptionValue2);
		      WebElement opn3=getWebElement("com.resil.TestResil.Specification.Specs_Option3Value");
		      opn3.clear();
		      opn3.sendKeys(SpecsOptionValue3);
		      WebElement opn4=getWebElement("com.resil.TestResil.Specification.Specs_Option4Value");
		      opn4.clear();
		      opn4.sendKeys(SpecsOptionValue4);
		      getWebElement("com.resil.TestResil.Specification.Specs_Optionradiobtn1").click();
		      break;
		     }
		     case ("Range - No Formula"):
		     {
		      getWebElement("com.resil.TestResil.Specification.Specs_RangeNFMinvalue").sendKeys(SpecsRNFMin);
		      getWebElement("com.resil.TestResil.Specification.Specs_RangeNFMaxvalue").sendKeys(SpecsRNFMax); 
		      break;
		     }
		     case ("Range - formula"):
		     {
		    	 getWebElement("com.resil.TestResil.Specification.Specs_RangeFMinvalue").sendKeys(SpecsRFMin);
			      getWebElement("com.resil.TestResil.Specification.Specs_RangeFMaxvalue").sendKeys(SpecsRFMax);
			      getWebElement("com.resil.TestResil.Specification.Specs_FormulaIcon").click();
			      getWebElement("com.resil.TestResil.Specification.Specs_FormulaBox").sendKeys(SpecsFormula);
			      Thread.sleep(3000);
			      getWebElement("com.resil.TestResil.Specification.Specs_FormulaAdd").click();
			      break;
		     }
		   }
		    
		//   if(value.equals("Plain - Text"))
		//   {
//		    getWebElement("com.resil.Specification.Specs_TextValue").sendKeys("Red & Yellow");
		//   }
		//   else if(value.equals("Number"))
		//   {
//		    getWebElement("com.resil.Specification.Specs_TextValue").sendKeys("1234.123456");
		//   }
		     Select spcuom = new Select(getWebElement("com.resil.TestResil.Specification.Specs_Uom"));
		     spcuom.selectByVisibleText(SpecsUOM);
		     getWebElement("com.resil.TestResil.Specification.Specs_PRno").clear();
		     getWebElement("com.resil.TestResil.Specification.Specs_PRno").sendKeys(SpecsPRNo);
//		     getWebElement("com.resil.TestResil.Specification.Specs_UploadDoc").sendKeys("C:\\Users\\Sushma\\Downloads\\APR DURATION.pdf");
		     getWebElement("com.resil.TestResil.Specification.Specs_Save").click();
		     Thread.sleep(1000);
		     String text=driver.switchTo().alert().getText();
		     
//		     int LastRow = ++n;
		     if(text.equals("Your record is succesfully saved."))	 
		   {
		    driver.switchTo().alert().accept();
		    System.out.println("Specification is saved");
		    

			ExcelWrite write = new ExcelWrite(
					System.getProperty("user.dir") + "\\src\\main\\java\\ExcelData\\TestData.xlsx");
			write.setCellData("SpecsEdit", "Result", "Pass");
			
//		    ExcelApiTest eat = new ExcelApiTest(System.getProperty("user.dir")+"\\src\\main\\java\\ExcelData\\TestData.xlsx");
//	        eat.setCellData("SpecsData","Result",i,"PASS");
//		    String status = "PASS";
////		    Excel_Writer.excelwrite(status,sheetName);
//		    Excel_WriterUsingColName obj=new Excel_WriterUsingColName();
//		    obj.excelwrite(status, sheetName);
		   
		   }
		   else
		   {   
//			   String str=driver.switchTo().alert().getText();
		       driver.switchTo().alert().accept();
		       System.out.println("Specification Not saved : "+text); 

				ExcelWrite write = new ExcelWrite(
						System.getProperty("user.dir") + "\\src\\main\\java\\ExcelData\\TestData.xlsx");
				write.setCellData("SpecsEdit", "Result", "Fail");
				
//		       String status = "FAIL";
////		       Excel_Writer.excelwrite(status,sheetName);
//		       Excel_WriterUsingColName obj=new Excel_WriterUsingColName();
//			    obj.excelwrite(status, sheetName);
		   } 
		   
		 }
		 
}
