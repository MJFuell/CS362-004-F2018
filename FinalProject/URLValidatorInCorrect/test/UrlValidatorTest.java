

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	UrlValidator urlVal = new UrlValidator(null, null, 0);
	   
	   //Should pass, URL is valid
	   assertTrue(urlVal.isValid("http://www.google.com:80/test1?action=view"));
	   
	   //Should fail for Scheme
	   assertTrue(urlVal.isValid("h3ttp://www.google.com:80/test1?action=view"));
	   assertTrue(urlVal.isValid("http/www.google.com:80/test1?action=view"));
	   
	   //Should fail for authority
	   assertTrue(urlVal.isValid("http://256.256.256.256:80/test1?action=view"));
	   assertTrue(urlVal.isValid("http://aaa:80/test1?action=view"));
	   
	   //Should fail for port
	   assertTrue(urlVal.isValid("http://www.google.com:-1/test1?action=view"));
	   assertTrue(urlVal.isValid("http://www.google.com:32b/test1?action=view"));
	   
	   //Should fail for path
	   assertTrue(urlVal.isValid("http://www.google.com:80/../?action=view"));
	   assertTrue(urlVal.isValid("http://www.google.com:80/file1//file2?action=view"));
	   
	   //Should fail for query
	   assertTrue(urlVal.isValid("http://www.google.com:80/test1?action=upload"));
	   assertTrue(urlVal.isValid("http://www.google.com:80/test1?aview"));
	  	   
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
