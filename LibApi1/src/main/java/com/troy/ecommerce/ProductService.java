package com.troy.ecommerce;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	// excel to list of products and save .
	public void save(MultipartFile file) {

		try {
			List<Product> products = Helper.convertExcelToListOfProduct(file.getInputStream());
			this.productRepo.saveAll(products);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    //Data to Excel 
	public List<Product> exportCustomerToExcel(HttpServletResponse response) throws IOException {
		List<Product> prod = productRepo.findAll();
		ExcelExportUtils exportUtils = new ExcelExportUtils(prod);
		exportUtils.exportDataToExcel(response);
		return prod;
	}

	// return list of products as json .
	public List<Product> getAllProducts() {
		return this.productRepo.findAll();
	}

	
	 public void deleteProduct(int bid) { 
		 
	 // List<Product>() ; List<Product> prodi =
	  // prodi.stream().filter(product->product.getProductId()!=bid).collect(
	  // Collectors.toList()) ; 
		 
		 productRepo.deleteById(bid);
	  
	 }

//	public void updateProduct(Product p, int productId) {
//		List<Product> list = list.stream().map(p -> {
//			if(p.getProductId() == productId)
//			{
//				p.setProductName(products.getProductName)) ; 
//				p.setProductDesc(products.getProductDesc()) ; 
//				p.setProductPrice(products.getProductPrice());
//			}
//			return p ; 
//		}).collect(Collectors.toList()) ; 
//		
//	}
	 
	
	 
	 
	 

}