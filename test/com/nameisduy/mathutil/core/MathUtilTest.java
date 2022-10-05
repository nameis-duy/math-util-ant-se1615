/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameisduy.mathutil.core;

import com.nameisduy.mathutil.core.MathUtil;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Mr Duy
 */
public class MathUtilTest {
    
    //@Test là 1 đánh dấu - annotation để báo với JVM
    //biết rằng hàm này là hàm main() và chạy code trong hàm này.
    //nếu thiếu @Test trước hàm thì, JUnit không vận hành!!!
    @Test
    //TEST CASE #1: n = 0, expected == 1
    //TEST CASE #2: n = 1, expected == 1
    //TEST CASE #3: n = 2, expected == 2
    //TEST CASE #4: n = 3, expected == 6
    public void testFactorialGivenRightArgumentReturnsWell() {
        long expected = 1;
        long actual = MathUtil.getFactorial(0);
        Assert.assertEquals(expected, actual);
        
        Assert.assertEquals(1, MathUtil.getFactorial(1));
        Assert.assertEquals(2, MathUtil.getFactorial(2));
        Assert.assertEquals(6, MathUtil.getFactorial(3));
    }
    
    @Test
    //TEST CASE #4: n = 4, 4! expected == 24, actual ? đoán xem
    //TEST CASE #5: n = 5, 5! expected == 120, actual ? đoán xem
    public void testFactorialGivenRightArgumentReturnsWell2() {
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        Assert.assertEquals(120, MathUtil.getFactorial(5));
    }
    
    //bắt Exception thì sao??
    //TEST CASE #6: n = -5, -5! expected: hy vọng sẽ thấy NGOẠI LỆ NÉM RA
    //nếu -5 đưa vào hàm, thì phải thấy ngoại lệ xuất hiện
    //nếu ngoại lệ xuất hiện khi tính -5, NGHĨA LÀ HÀM CHẠY ĐÚNG
    //NHƯ THIẾT KẾ
    //TUI MUỐN ĐO, CÓ NGOẠI LỆ XUẤT HIỆN HAY KHÔNG KHI CHƠI -5
    //DO NGOẠI LỆ KHÔNG PHẢI LÀ VALUE KIỂU LONG ĐỂ SO SÁNH
    //CÁCH VIẾT KHÁC 1 TÍ: KHI CHẠY -5!, EXPECTED == IllegalArgumentException
    //nghĩa là có sự xuất hiện của 1 object thuộc class IllegalArgEx hay không
    
    //@Test(epxected = Exception.class)//không tốt, vì chung chung Exception
    @Test(expected = IllegalArgumentException.class) //bắt lớp Con
    public void testFactorialGivenWrongArgumentThowsException() {
        MathUtil.getFactorial(-5);
    }
    
//    @Test
//    public void testGreen() {
//        Assert.assertEquals(10, 10);
//    }
//    
//    @Test
//    public void testRed() {
//        Assert.assertEquals(10, 100); //em hy vọng trả về 10
//                                      //thực tế anh là mấy
//                                      //thực tế là 10 -> XANH
//                                      //thực tế éo là 10 -> ĐỎ
//    }
    
}