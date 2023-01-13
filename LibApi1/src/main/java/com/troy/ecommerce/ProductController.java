package com.troy.ecommerce;

import com.troy.ecommerce.Product;
import com.troy.ecommerce.Helper;
import com.troy.ecommerce.ProductService;


import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

@RestController
// "http://localhost:4200/create-employee"
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4200/create-employee"} )
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
	private ProductRepo productRepo;
    
    @GetMapping("/display")  // test apii
  	public String sayHello() {
  		return " Hello World  " ; 
  	} 
    
    
    @PostMapping("/product/upload")  // 2nd Api
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            //true
            this.productService.save(file); // return type boolean

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/product") // 1st api
    public List<Product> getAllProduct() {
        return this.productService.getAllProducts();
    }
    
  
    
    @GetMapping("/export-to-excel") // 1st feature
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Customers_Information.xlsx";
        response.setHeader(headerKey, headerValue);
        productService.exportCustomerToExcel(response);

    }
      
    @GetMapping("/product/{id}") // get employee by id
	public ResponseEntity<Product> getEmployeeById(@PathVariable int id) {
		Product employee = productRepo.findById(id)
				.orElseThrow();
		return ResponseEntity.ok(employee);
	}
    

	
	  @DeleteMapping("/product/{productId}")  // 3rd Api
	  public void deleteProduct(@PathVariable int productId) { 
	     this.productService.deleteProduct(productId) ; }
	  
	  
	  @PutMapping("/product/{id}") // 4th api
	  public ResponseEntity<Product> updateCustomer(@RequestBody Product customer) {
	  	
	  	try {
	  		return new ResponseEntity<Product>(productRepo.save(customer), HttpStatus.OK);
	  	} catch (Exception e) {
	  		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  	}
	  }
	  
	  @PostMapping("/product")
	  @CrossOrigin(origins = "http://localhost:4200")
		public Product createEmployee(@RequestBody Product employee) {
			return productRepo.save(employee);
		}
	  
	  
	  
	  
		/*
		 * @GetMapping("/download") public ResponseEntity download() { String fileName =
		 * "/Book1.xlsx"; InputStream is =
		 * this.getClass().getResourceAsStream(fileName); try { return
		 * ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
		 * "attachment; fileName=" + fileName)
		 * .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(
		 * IOUtils.toByteArray(is)); } catch (IOException e) { return
		 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); } }
		 */
	  
	  
//	  @PutMapping("/update_product/{productId}")
//	public Product updateProduct(@RequestBody Product p, @PathVariable("productId") int productId)
//	{
//		  this.productService.updateProduct(p, productId)  ;
//		  return p  ; 
//	}
	  
//	    @PutMapping("/update_product/{id}")
//	    public void <Product> updateEmployee(@PathVariable int id,@RequestBody Product employeeDetails) {
//	        Product updateEmployee = productRepo.getById(id) ;
//
//	        updateEmployee.setProductName(employeeDetails.getProductName());
//	        updateEmployee.setProductDesc(employeeDetails.getProductDesc());
//	        updateEmployee.setProductPrice(employeeDetails.getProductPrice());
//
//	        productRepo.save(updateEmployee);
//
//	       
//	    }
	  
     	 
       

}




