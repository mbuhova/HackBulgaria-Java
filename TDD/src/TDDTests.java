
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TDDTests {
    TDDMethods instance;
    
    @Before
    public void setUp() throws Exception {
        this.instance = new TDDMethods();
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void testMaxScalarSumSimple() {
        int[] a = { 1 };
        int[] b = { 1 };
        
        long actual = this.instance.maxScalarSum(a, b);
        assertEquals(1, actual);
    }
    
    @Test
    public void testMaxScalarSumWithZeros() {
        int[] a = { 1, 0 };
        int[] b = { 0, 1 };
        
        long actual = this.instance.maxScalarSum(a, b);
        assertEquals(1, actual);
    }
    
    @Test
    public void testMaxScalarSumWithMoreNumbers() {
        int[] a = { 1, 0, 2, 6, 3, 4 };
        int[] b = { 0, 1, 8, 5, 4, 1 };
        
        long actual = this.instance.maxScalarSum(a, b);
        assertEquals(83, actual);
    }
    
    @Test(expected=RuntimeException.class)
    public void testMaxScalarSumWithNullArray() {
        int[] a = null;
        int[] b = { 0, 1, 8, 5, 4, 1 };
        
        this.instance.maxScalarSum(a, b);
    }
    
    @Test(expected=RuntimeException.class)
    public void testMaxScalarSumWithDifferentLengths() {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 0, 1, 8, 5, 4, 1 };
        
        this.instance.maxScalarSum(a, b);
    }

    @Test
    public void testGetNumberOfDigits(){
        int actual = this.instance.getNumberOfDigits(123);
        assertEquals(3, actual);
    }
    
    @Test
    public void testGetNumberOfDigitsWithZero(){
        int actual = this.instance.getNumberOfDigits(0);
        assertEquals(1, actual);
    }
    
    @Test
    public void testGetNumberOfDigitsWithNegativeNumber(){
        int actual = this.instance.getNumberOfDigits(-34578);
        assertEquals(5, actual);
    }
    
    @Test
    public void testGetNumberOfDigitsWithBigNumber(){
        int actual = this.instance.getNumberOfDigits(123456789);
        assertEquals(9, actual);
    }
    
    @Test
    public void testStichMeUpSimple(){
        String actual = this.instance.stichMeUp(" ", "Spiderman", new Integer(23));
        assertEquals("Spiderman 23", actual);
        
    }
    
    @Test
    public void testStichMeUpWithPrimitives(){
        String actual = this.instance.stichMeUp(", ", 'a', 23, new StringBuilder("abc"), 2.5);
        assertEquals("a, 23, abc, 2.5", actual);
        
    }
    
    @Test
    public void testStichMeUp(){
        String actual = this.instance.stichMeUp(new Integer(11), "Spiderman", 23, new StringBuilder("abc"));
        assertEquals("Spiderman112311abc", actual);
        
    }
    
    @Test(expected=NullPointerException.class)
    public void testStichMeUpMethod(){
        this.instance.stichMeUp(" ", null, 23, new StringBuilder("abc"));
        
    }
    
    @Test
    public void testReduceFilePathSimple() {
        String actual = this.instance.reduceFilePath("/./www/htdocs/wtf");
        assertEquals("/www/htdocs/wtf", actual);
    }
    
    @Test
    public void testReduceFilePathSimpleEmpty() {
        String actual = this.instance.reduceFilePath("/");
        assertEquals("/", actual);
    }
    
    @Test
    public void testReduceFilePathOnlyWithLines() {
        String actual = this.instance.reduceFilePath("///////");
        assertEquals("/", actual);
    }
    
    @Test
    public void testReduceFilePathWithGettingBack() {
        String actual = this.instance.reduceFilePath("/etc/../etc/../etc/../");
        assertEquals("/", actual);
    }
}
