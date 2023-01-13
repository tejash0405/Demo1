import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  employees: Product[] = [];

  constructor(private http:HttpClient,private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProduct();
  }

  private getProduct(){
    this.productService.getProductList().subscribe(data => {
      this.employees = data;
    });
  }

  productDetails(id: number){
    this.router.navigate(['product-details', id]);
  }

  updateProduct(id: number){
    this.router.navigate(['update-product', id]);
  }

  deleteProduct(id: number){
    this.productService.deleteProduct(id).subscribe( data => {
      console.log(data);
      this.getProduct();
    })
  }

 
  name: string = "";
  file:any;
  getName(name:string)
  {
    this.name= "file" ; 
  }
  getFile(event:any)
 {
  this.file = event.target.files[0];
  console.log('file',this.file);
 }
 
 submitData(){
  let formData  = new FormData() ;
  formData.set("name","file" ); 
  formData.set("file",this.file) ; 

  this.http.post('http://localhost:8080/product/upload',formData).subscribe((response)=>{}) ; 
  this.getProduct();
 }

 goToAddProduct() {
  this.router.navigate(['/addproduct']);
}

}
