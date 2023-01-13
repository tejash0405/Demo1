import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProductComponent } from './create-product/create-product.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ProductListComponent } from './product-list/product-list.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ViewProductComponent } from './view-product/view-product.component';



const routes: Routes = [
  {path: 'products', component: ProductListComponent, canActivate:[AuthGaurdService]},
  {path: 'create-product', component: CreateProductComponent, canActivate:[AuthGaurdService]},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'update-product/:id', component: UpdateProductComponent, canActivate:[AuthGaurdService]},
  {path: 'product-details/:id', component: ViewProductComponent, canActivate:[AuthGaurdService]},
  { path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent , canActivate:[AuthGaurdService]}
  //{path: 'addproduct', component: AddEmployeeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
