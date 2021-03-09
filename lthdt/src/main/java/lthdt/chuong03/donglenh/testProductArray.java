/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.chuong03.donglenh;

import java.util.Arrays;
import lthdt.chuong03.coffeelogic.Product;
import lthdt.chuong03.coffeelogic.ProductCompByPrice;
import lthdt.chuong03.coffeelogic.ProductCompyByName;

/**
 *
 * @author Admin
 */
public class testProductArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // tao mang cac san pham
        Product[]sp =new Product[]{new Product("sunlifk",12),
                                   new Product("lifebouy",5),
                                    new Product("Thien long",1)};
        System.out.println("Mang ban dau la");
        System.out.println(Arrays.toString(sp));
//        Product temp;
//        for(int i=0 ;i<sp.length-1;i++)
//            for(int j =i+1;j<sp.length;j++)    
//                if(sp[i].getPrice() > sp[j].getPrice()) {
//                    temp =sp[i];
//                    sp[i]=sp[j];
//                    sp[j]=temp;
//                }

           // sap xep mang theo gia ca
//           Arrays.sort(sp, new ProductCompByPrice());
//           System.out.println("Mang sap xep theo gia ca");
//           System.out.println(Arrays.toString(sp));
           System.out.println("Mang sap xep theoten sp");
           Arrays.sort(sp, new ProductCompyByName());
            System.out.println(Arrays.toString(sp));  
            
            int index =Arrays.binarySearch(sp, new Product("sunsilk",12), new ProductCompyByName());
            if(index<0){
                System.out.println("k tim thay");
            }else{
                System.out.println("Phan tu thu "+ index + "chua gia tri can tim");
                System.out.println(sp[index]);
            }
              
           
        
        
    }
    
}
