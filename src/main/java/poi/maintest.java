package poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    
    public class maintest {  
    	private static List<XlsDto> list = new ArrayList<XlsDto>();  
    	 public static void main(String[] args) throws IOException {  
    	        maintest xlsMain = new maintest();  
    	        XlsDto xls = null;  
    	        List<XlsDto> list = xlsMain.readXls();  

    	        for (int i = 0; i < list.size(); i++) {  
    	            xls = (XlsDto) list.get(i);  
    	            System.out.println(xls.getUsename() + "    " + xls.getPassword() + "    " + xls.getName() + "    " + xls.getDepartment() + "    " + xls.getCompany()+ "    "
    	            		+xls.getMainlist() +"    " + xls.getProjectlist() +"    " +xls.getButton_submit()+"    "
    	            		+xls.getStep() +"    " + xls.getFindway() +"    " + xls.getElement() + "    " +xls.getText()+"   "+xls.getType()+ "    "+ xls.getNumber()+"    "+xls.getSelect_text()
    	            		);      
    	      }  
    	        System.out.println(list.get(46).getElement()+ list.get(46).getText());
     }  	
    	
  
      
//       读取xls文件内容  
//       @return List<XlsDto>对象  
//       @throws IOException  
//       输入/输出(i/o)异常  

    
         public List<XlsDto> readXls() throws IOException {  
            InputStream is = new FileInputStream("src/main/java/poi/testData.xlsx");  
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);  
            XlsDto xlsDto = null;  
            // 循环工作表Sheet   
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {  
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);  
                if (xssfSheet == null) {  
                    continue;  
                }  
                list=readXlsType(xssfSheet);
                
                //循环行Row
            }  
            return list;  
        }  
       
    public static List<XlsDto> readXlsType(XSSFSheet xssfSheet){
    	XlsDto xlsDto = null;
    	if("用户信息".equals(xssfSheet.getSheetName())){  	
            // 循环行Row  
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {  
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);  
                
                if (xssfRow == null) {  
                    continue;  
                }  
                xlsDto = new XlsDto();  
                // 循环列Cell  
                
                // for (int cellNum = 0; cellNum <=4; cellNum++) {  

                
                XSSFCell usename = xssfRow.getCell(0);  
                if (usename != null) {  
                	xlsDto.setUsename(getValue(usename));  
                }  
                
                XSSFCell password = xssfRow.getCell(1);  
                if (password != null) {
                	xlsDto.setPassword(getValue(password));  
                }  
                
                XSSFCell name = xssfRow.getCell(2);  
                if (name != null) {  
                	xlsDto.setName(getValue(name));  
                }  
                
                XSSFCell company = xssfRow.getCell(3);  
                if (company != null) {  
                	xlsDto.setCompany(getValue(company));  
                }  
                 
                XSSFCell department = xssfRow.getCell(4);  
                if (department != null) {
                	xlsDto.setDepartment(getValue(department));  
                }  
         
                XSSFCell opendepartment = xssfRow.getCell(5);  
                if (opendepartment != null) {
                	xlsDto.setOpendepartment(getValue(opendepartment));  
                }  
         
                               
                list.add(xlsDto);  
            }  	
    	}
    	
    	
//    		if("目录".equals(name)){
//		XlsDto xlsDto = null;

    	else if("目录".equals(xssfSheet.getSheetName())){  	
            // 循环行Row  

                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {  
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);  
                    
                    if (xssfRow == null) {  
                        continue;  
                    }  
                    xlsDto = new XlsDto();  
   // 循环列Cell  
                    
                    // for (int cellNum = 0; cellNum <=4; cellNum++) {  

                    
                    XSSFCell mainlist = xssfRow.getCell(0);  
                    if (mainlist != null) {  
                    	xlsDto.setMainlist(getValue(mainlist));  
                    }  
                    
                    XSSFCell projectlist = xssfRow.getCell(1);  
                    if (projectlist != null) {
                    	xlsDto.setProjectlist(getValue(projectlist));  
                    }  
                    
                    XSSFCell button_submit = xssfRow.getCell(2);  
                    if (button_submit != null) {  
                    	xlsDto.setButton_submit(getValue(button_submit));  
                    }  
                     
                                   
                    list.add(xlsDto);  
                }  
        	}
        	
           else {
            	  
            	  for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {  
                      XSSFRow xssfRow = xssfSheet.getRow(rowNum);  
                      
                      if (xssfRow == null) {  
                          continue;  
                      }  
                      xlsDto = new XlsDto();  
   // 循环列Cell  
                      
                      // for (int cellNum = 0; cellNum <=4; cellNum++) {  

                      
                      XSSFCell step = xssfRow.getCell(0);  
                      if (step != null) {  
                      	xlsDto.setStep(getValue(step));  
                      }  
                      
                      XSSFCell findway = xssfRow.getCell(1);  
                      if (findway != null) {
                      	xlsDto.setFindway(getValue(findway));  
                      }  
                      
                      XSSFCell element = xssfRow.getCell(2);  
                      if (element != null) {  
                      	xlsDto.setElement(getValue(element));  
                      }  
                       
                      XSSFCell text = xssfRow.getCell(3);  
                      if (text != null) {  
                      	xlsDto.setText(getValue(text));  
                      }  
                      
                      XSSFCell type = xssfRow.getCell(4);  
                      if (type != null) {
                      	xlsDto.setType(getValue(type));  
                      }  
                      
                      
                      XSSFCell number = xssfRow.getCell(5);  
                      if (number != null) {  
                    	  String aa = getValue(number);
                    	  if(!"".equals(aa)){
                    		  int a = Integer.parseInt(aa);
                    		  xlsDto.setNumber(a); 
                    	  }
                      	 
                      }  
                      
                      XSSFCell select_text = xssfRow.getCell(6);  
                      if (select_text != null) {  
                      	xlsDto.setSelect_text(getValue(select_text));  
                      }  
                      
                      
            	                 
                      
            	  
            	  list.add(xlsDto);  
                   
            	  }  	
                }
    		
    		
    	
    	return list;
    }     
    
//           得到Excel表中的值     
//  @param hssfCell Excel中的每一个格子  
//  @return Excel中每一个格子中的值  
//  @SuppressWarnings("static-access")  
         
         
        private static String getValue(XSSFCell xssfCell) {  
            if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {  
            	 // 返回布尔类型的值  
                return String.valueOf(xssfCell.getBooleanCellValue());  
            } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {  
                // 返回数值类型的值  
                return String.valueOf((int) xssfCell.getNumericCellValue()); 
            }else {  
                // 返回字符串类型的值  

                return String.valueOf(xssfCell.getStringCellValue());  
            }  
        }  
       
    } 
    
    
