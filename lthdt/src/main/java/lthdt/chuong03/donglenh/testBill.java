/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.chuong03.donglenh;

import lthdt.chuong03.coffeelogic.Bill;
import lthdt.chuong03.coffeelogic.Product;

/**
 *
 * @author Admin
 */
public class testBill {
    public static void main(String[]args) throws CloneNotSupportedException{
        Bill a = new Bill(12, new Product[]{
                    new Product("Shampoo",12),
                     new Product("Closed",10)});
        System.out.println("a = "+ a);
        Bill temp =(Bill) a.clone();
        temp.setBillID(15);
         System.out.println("a = " + a);
         System.out.println("temp = " + temp);
       }
    
}
