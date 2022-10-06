/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameisduy.mathutil.core;

import static com.nameisduy.mathutil.core.MathUtil.getFactorial;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//import static .... tên-class.tên-hàm thì sau này
//khi gọi hàm static bỏ luôn tên class. , hiểu ngầm tên class
//code gọi như hàm C
//.* là đại diện cho tất cả các hàm static trong class vừa import
//nếu rảnh thì chấm từng tên hàm static (không có dấu ngoặc)

/**
 *
 * @author Mr Duy
 */

//KĨ THUẬT DDT - DATA DRIVEN DEVELOPMENT
//TRÁNH NHẦM LẪN TDD - TEST DRIVEN DEVELOPMENT
//DDT: KĨ THUẬT TỔ CHỨC CÁC TEST CASE CHO GỌN GÀNG
//TÁCH CÁC CÂU LỆNH KIỂM THỬ VÀ BỘ DATA DÙNG ĐỂ TEST RIÊNG RA 2 NƠI
//PHIÊN BẢN TEST JUNIT VỪA HỌC ĐANG TRỘN DATA TEST VÀ GỌI HÀM LẪN LỘN VỚI NHAU
//KHÔNG SAI NHƯNG NHÌN KHÔNG RÕ RÀNG

//Nếu ta muốn check hàm getF() với các giá trị đầu vào và có trả về đầu ra
//mong đợi hay không, kiểu như:
//0 -> 1
//1 -> 1
//2 -> 2
//3 -> 6
//4 -> 24
//5 -> 120
//6 -> 720
//...
//có chỗ nào định nghĩa riêng cái đám data này, thì ta sẽ dễ dàng cảm nhận các case
//đã đủ hay chưa, hay đại diện đã đủ hay chưa!!
//lát hồi ta nhồi cái đám data này vào hàm assertEquals(? getF(?))
//cảm giác viết code để test hàm nhìn rõ ràng hơn
//kĩ thuật đẩy DATA TEST ra 1 chỗ khác, lát hồi nhồi ngược lại vào chỗ gọi hàm
//kĩ thuật này được gọi là DDT - viết TEST CASE theo kiểu tách DATA cho dễ đọc
//còn gọi là PARAMETERIZED TESTING

@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    
    //chuẩn bị data để nhồi vào hàm test
    //quy ước hàm chuẩn bị data phải là static - nằm ở 1 chỗ cố định trong ram
    //để object nào cũng thấy được!!
    @Parameterized.Parameters //thông báo sẵn sàng truyền data 
    public static Object[][] initData() {
        return new Integer[][] {
            {0, 1}, 
            {1, 1}, 
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
            {6, 720}
        };
    }
    
    //2 biến này sẽ map vào 2 cột tương ứng của hàm ở trên
    //của hàm initData
    //sau đó ta nhồi 2 biến này vào trong hàm assertEquals() như cũ
    @Parameterized.Parameter(value = 0)//map biến này vào cột 0
    public int n;
    @Parameterized.Parameter(value = 1)//map biến này vào cột 1
    public long expected;
    
    @Test//xài thử data từ 2 biến trên và chạy compare
    public void testFactorialGivenRightArgumentReturnsWell() {
        assertEquals(expected, getFactorial(n));
    }
}

//KẾT LUẬN CHUNG CHO XANH ĐỎ:
//XANH: KHI TẤT CẢ CÁC TEST CASE ĐỀU PHẢI XANH - EXPECTED == ACTUAL
//ĐỎ: CHỈ CẦN 1 THẰNG ĐỎ, TẤT CẢ LÀ ĐỎ!!!
//XANH: MỆNH ĐỀ AND, XANH KHI TẤT CẢ CÙNG XANH
//ĐỎ: MỆNH ĐỀ OR, CHỈ CÓ 1 THẰNG ĐỎ, CẢ ĐÁM CÙNG ĐỎ

//LÍ DO: HÀM ĐƯỢC GỌI ĐÚNG, THÌ PHẢI ĐÚNG HẾT VỚI CÁC CASES
//       HÀM CÓ 1 THẰNG SAI, ĐÁM CÒN LẠI ĐÚNG/XANH, HÀM KHÔNG ỔN ĐỊNH
//       DO CÓ 1 THẰNG SAI -> KẾT LUẬ NCHUNG LÀ HÀM SAI

//CHỈ CẦN 1 THẰNG ĐỎ, DÁM KẾT LUẬN CODE KHÔNG ỔN ĐỊNH, KHÔNG CHO ĐI TIẾP
//CODE KHÁC, PHẢI SỬA CHO XANH -> PHẦN LÍ THUYẾT CỐT LÕI CỦA
//CI - CONTINUOUS INTEGRATION - TÍCH HỢP LIÊN TỤC