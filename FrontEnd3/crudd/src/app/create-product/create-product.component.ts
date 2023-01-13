import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  employee: Product = new Product();
  constructor(private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveProduct(){
    this.productService.createProduct(this.employee).subscribe( data =>{
      console.log(data);
      this.goToProductList();
    },
    error => console.log(error));
  }

  goToProductList(){
    this.router.navigate(['/products']);
  }
  
  onSubmit(){
    console.log(this.employee);
    this.saveProduct();
  }
}
