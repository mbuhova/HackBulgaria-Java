import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestExam {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSortSimple() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(3);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(13);
        list.add(10);
        list.add(2);
        List<Integer> actual = Exam.sort(list);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(3);
        expected.add(5);
        expected.add(7);
        expected.add(9);
        expected.add(10);
        expected.add(13);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSortSingleElement() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        List<Integer> actual = Exam.sort(list);
        assertEquals(list, actual);
    }
    
    @Test
    public void testSortEmptyCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> actual = Exam.sort(list);
        assertEquals(list, actual);
    }
    
    @Test(expected=RuntimeException.class)
    public void testSortException() {
        ArrayList<Integer> list = null;
        Exam.sort(list);
    }

    @Test
    public void testReverseSimple() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> actual = Exam.reverse(list);        
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        expected.add(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testReverseSingleElement() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        List<Integer> actual = Exam.reverse(list);
        assertEquals(list, actual);
    }
    
    @Test
    public void testReverseEmptyCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> actual = Exam.reverse(list);
        assertEquals(list, actual);
    }

    @Test(expected=RuntimeException.class)
    public void testReverseException() {
        ArrayList<Integer> list = null;
        Exam.reverse(list);
    }

    @Test
    public void testIsMonotonousTrue() {
        boolean actual = Exam.isMonotonous(Arrays.asList(1,2,3,4,5,6));
        assertEquals(true, actual);
    }
    
    @Test
    public void testIsMonotonousTrueDecreasing() {
        boolean actual = Exam.isMonotonous(Arrays.asList(6,5,4,3,2,1,1,1));
        assertEquals(true, actual);
    }
    
    @Test
    public void testIsMonotonousFalse() {
        boolean actual = Exam.isMonotonous(Arrays.asList(1,2,1,4,5,4));
        assertEquals(false, actual);
    }
    
    @Test
    public void testIsMonotonousOneElement() {
        boolean actual = Exam.isMonotonous(Arrays.asList(4));
        assertEquals(true, actual);
    }
}
