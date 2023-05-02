package day9;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Task1 {
  @Test(dataProvider = "dp")
  public void add(Integer a, Integer b) {
	 int c=a+b;
	 Assert.assertEquals(c,178 );
  }
  @Test(dataProvider = "dp")
  public void sub(Integer a, Integer b) {
	 int c=a-b;
	 Assert.assertEquals(c,4);
  } @Test(dataProvider = "dp")
  public void mul(Integer a, Integer b) {
	 int c=a*b;
	 Assert.assertEquals(c,7917 );
  } @Test(dataProvider = "dp")
  public void div(Integer a, Integer b) {
	 long c=a/b;
	 Assert.assertEquals(c,1);
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {   new Object[] { 91, 87 }};
  }
}
