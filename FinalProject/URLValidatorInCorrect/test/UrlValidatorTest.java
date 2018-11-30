
import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   //These are manual tests that test the URLs in sections (scheme, authority, port, path, and query)
   public void testManualTest()
   {	 
	   UrlValidator urlVal = new UrlValidator(null, null, 0);
	   
	   // Tests we expect to pass
	   
	   //Should pass, valid URLs (Valid Scheme, Authority, Port, Path, and Query)
	   assertTrue(urlVal.isValid("http://www.google.com:80/test1?action=view"));
	   assertTrue(urlVal.isValid("ftp://go.com:65535/test1/?action=edit&mode=up"));
	   assertTrue(urlVal.isValid("ftp://255.255.255.255:0/test4?action=view"));
	   assertTrue(urlVal.isValid("http://255.com:86/$23?action=edit&mode=up"));
	   assertTrue(urlVal.isValid("ftp://go.au:65535/test1/file?action=view"));
	   assertTrue(urlVal.isValid("http://0.0.0.0:264/t123?action=view"));
	  	   
	   
	   //Empty Port should pass
	   assertTrue(urlVal.isValid("ftp://go.com/test1/?action=edit&mode=up"));
	   assertTrue(urlVal.isValid("http://255.com/$23?action=edit&mode=up"));
	   assertTrue(urlVal.isValid("ftp://go.au/test1/file?action=view"));
	   
	   //Empty Path should pass
	   assertTrue(urlVal.isValid("http://www.google.com:80?action=view"));
	   assertTrue(urlVal.isValid("ftp://go.com:65535?action=edit&mode=up"));
	   assertTrue(urlVal.isValid("http://255.com:86?action=edit&mode=up"));	   
	   
	   //Empty Query should pass
	   assertTrue(urlVal.isValid("http://www.google.com:80/test1"));
	   assertTrue(urlVal.isValid("ftp://go.au:65535/test1/file"));
	   assertTrue(urlVal.isValid("http://255.com:86/$23"));	   
	   
	   
	   //Real world URL. Found the missing tilde and forward slash in regex string variable
	   assertTrue(urlVal.isValid("http://web.engr.oregonstate.edu/~redfiels/classes/cs271/HammingCodes/"));
	   
	   
	   
	   //Tests we expect to fail
	   
	   //Should fail for empty Scheme
	   assertFalse(urlVal.isValid("www.google.com:80/test1?action=view"));
	   assertFalse(urlVal.isValid("255.255.255.255:0/test4?action=view"));
	   assertFalse(urlVal.isValid("go.au:65535/test1/file?action=view"));
	   
	   //Should fail for empty Authority
	   assertFalse(urlVal.isValid("ftp://:65535/test1/file?action=view"));
	   assertFalse(urlVal.isValid("h3t://:0/test4?action=view"));
	   assertFalse(urlVal.isValid("ftp://:65535/test1/?action=edit&mode=up"));	   
	   	      
	   
	   //Should fail for invalid Scheme
	   assertFalse(urlVal.isValid("3ht://www.google.com:80/test1?action=view"));
	   assertFalse(urlVal.isValid("http:/0.0.0.0:264//t123?action=view"));
	   assertFalse(urlVal.isValid("://255.255.255.255:0/test4?action=view"));
	   
	   //Should fail for invalid authority
	   assertFalse(urlVal.isValid("ftp://256.256.576.2555:65535/test1/?action=view"));
	   assertFalse(urlVal.isValid("http://1.2.3.4.5:86/$23?action=edit&mode=up"));
	   assertFalse(urlVal.isValid("h3t://go.a1a:0/test4?action=view"));
	   
	   //Should fail for invalid port
	   assertFalse(urlVal.isValid("h3t://255.255.255.255:-1/test4?action=view"));
	   assertFalse(urlVal.isValid("ftp://go.au:65636/test1/file?action=view"));
	   assertFalse(urlVal.isValid("h3t://0.0.0.0:65a//t123?action=view"));
	   
	   //Should fail for invalid path
	   assertFalse(urlVal.isValid("http://www.google.com:80/..?action=view"));
	   assertFalse(urlVal.isValid("ftp://go.com:65535/../?action=edit&mode=up"));
	   assertFalse(urlVal.isValid("ftp://go.com:65535/..//file?action=edit&mode=up"));
	   
	   //Should fail for invalid query
	   assertFalse(urlVal.isValid("http://www.google.com:80/test1 @action.go"));
	   assertFalse(urlVal.isValid("ftp://go.au:65535/test1/file// ?action/travel"));
	   assertFalse(urlVal.isValid("ftp://go.au:65535/test1/file ?edit?view"));
	     
   }
   
   //This tests the boolean aspect of the ResultPair class
   public void testResultPair()
   {
	 //Create a few result pairs to compare	   
	   ResultPair[] testUrl = {new ResultPair("a", true),new ResultPair("b", true)};	   
	   
	   boolean expected = true;	   
	   
	   //& the boolean variables together
	   for (int index = 0; index < 1; ++index) {           
           expected &= testUrl[index].valid;
	   	}
	   
	   //All true went in, should come out true
	   assertTrue(expected);
   }
}
   
   
