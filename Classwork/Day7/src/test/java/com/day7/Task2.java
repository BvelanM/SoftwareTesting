package com.day7;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Task2 {
	int ek,dho,theen;
  @BeforeSuite
  public void getData() {
	  Scanner sc=new Scanner(System.in);
	  ek=sc.nextInt();
	  dho=sc.nextInt();
  }
	@Test(priority = 3)
  public void add() {
  theen=ek+dho;
  Assert.assertEquals(theen, 3);
  }
  @Test(priority = 4)
  public void sub() {
	  theen=ek-dho;
	  Assert.assertEquals(theen, -1);
  }
  @Test(priority = 1)
  public void mul() {
	  theen=ek*dho;
	  Assert.assertEquals(theen, 2);
  }
  @Test(priority = 2)
  public void div() {
	  theen=ek/dho;
	  Assert.assertEquals(theen, 0);
  }
}
