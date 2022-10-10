/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameisduy.mathutil.core;

/**
 *
 * @author Mr Duy
 */
//Class này sẽ chứa các hàm static, là tiện ích dùng chung cho các class khác

public class MathUtil {
    
    //hàm tính n! = 1.2.3...n
    //0! = 1! = 1
    //vì giai thừa tăng cực nhanh, 21! tràn kiểu long (18 số 0)
    //không có giai thừa âm
    //quy ước: n nhận vào từ 0..20!
//    public static long getFactorial(int n) {
//        
//        if (n < 0 || n > 20) 
//            throw new IllegalArgumentException("Invalud argument. n must between 0..20");
//        
//        if (n == 0 || n == 1)
//            return 1;
//        
//        long product = 1;
//        
//        for (int i = 2; i <= n; i++)
//            product *= i; //product = product * i;
//        
//        return product;
//    }
    
    //Viết tính giai thừa theo đệ quy
    //n! = 1.2.3.4....n
    //Cách 1: viết kiểu for, con heo đất, nhồi dần kết quả vào 1 biến
    //product = product * i; i chạy từ 1..n
    //Cách 2: Đệ quy - recursion
    //Gọi lại chính mình đối với 1 quy mô/giá trị khác
    //Búp bê của người Nga : con búp bê bự chứ con búp bê nhỏ bên trong con trong chứa con
    //khác...khoảng 12 con
    //lặp lại chính mình 12 lần
    //5! = ??? 1.2.3.4.5
    //5! =           4! . 5 = 5 x 4!
    //4! = 4 x 3!
    //3! = 3 x 2!
    //2! = 2 x 1!
    //1! = 1
    //n! = n x (n - 1)!
    public static long getFactorial(int n) {
        if (n < 0 || n > 20) 
            throw new IllegalArgumentException("Invalud argument. n must between 0..20");
        
        if (n == 0 || n == 1)
            return 1; //tình huống n đặc biệt, tính luôn
        
        //sống sót đến đây n = 2..20
        //hàm này đang tính n! = n * (n - 1)!
        return n * getFactorial(n - 1);
        //n! = n * (n - 1)!
    }
    
    
    //tư duy viết code theo kiểu gọi là TDD - Test Driven Development 
    //                                       (1 skill viết code - có thể thêm vào CV)
    //Test First Development: khi viết code thì song song đó phải viết các tình huống
    //kiểm thử code/hàm/class
    
    //tư duy viết code kèm kiểm thử:
    //hàm của ta getFactorial(n đưa vào) -> trả về n! trong giới hạn long
    //ta suy nghĩ luôn tình huống kiểm thử -> TEST CASE
    //TEST CASE: 1 TÌNH HUỐNG TA XÀI APP, TỨC LÀ TA ĐƯA DATA ĐẦU VÀO VÀ CHỜ APP TRẢ RA KQUA
    //                                    VÀ SO SÁNH APP TRẢ CÓ ĐÚNG KÌ VỌNG??
    //TDT là kĩ thuật vừa viết code vừa suy nghĩ luôn các TEST CASE kiểm thử code
    
    //CASE 1: n = 0, Expected == getFactorial(0) == 1
    //CASE 2: n = 1, Expected == getFactorial(1) == 1
    //CASE 3: n = 2, Expected == getFactorial(2) == 2
    //CASE 4: n = 3, Expected == getFactorial(3) == 6
    //CASE 5: n = 4, Expected == getFactorial(4) == 24
    //CASE ...: n = 21, Expected == getFactorial(21) == Ngoại lệ vì n! quá lớn
    //                                                  không lưu được trong long ĐC
    //CASE ...: n < 0, Expected == getFactorial(-5) == Ngoại lệ vì không tính
    //                                                 giai thừa âm!!!
}
