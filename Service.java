package com.app.service;
import java.util.*;

import com.bkfs.bean.Customer;
public class Service {
		public void withdraw(ArrayList<Customer> al,long accno,double amnt){
			int i,j,k,l;
			int flag=0;
			for(i=0;i<al.size();i++){
				if(al.get(i).getAccno()==accno){
					if(al.get(i).getSal()>=amnt){
					double bal=al.get(i).getSal()-amnt;
					al.get(i).setSal(bal);
					System.out.println("Updated account"+al.get(i));
					break;
					}else{
						System.out.println("Insufficient balance");
					}
				}
			}
			if(flag==0){
				System.out.println("Account not found");
			}
		}
		public void deposit(ArrayList<Customer> al,long accno,double amnt){
			int i,j,k,l;
			int flag=0;
			for(i=0;i<al.size();i++){
				if(al.get(i).getAccno()==accno){
					double bal=al.get(i).getSal()+amnt;
					al.get(i).setSal(bal);
					System.out.println("Updated account"+al.get(i));
					break;
				}
			}
			if(flag==0){
				System.out.println("Account not found");
			}
		}
	}
