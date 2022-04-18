package com.lec.ex2_datastream;
import java.io.*;
import java.util.ArrayList;
// 파일에 저장된 재고들을 출력
public class Ex04_ProductPrint {
	public static void main(String[] args) {
		InputStream     fis = null;
		DataInputStream dis = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			fis = new FileInputStream("src/com/lec/ex2_datastream/product.dat");
			dis = new DataInputStream(fis);
			while(true) {
				String name  = dis.readUTF(); // 상품명
				int    price = dis.readInt(); // 가격
				int    ps    = dis.readInt(); // 재고량
				products.add(new Product(name, price, ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 데이터는 다음과 같습니다");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			} catch (Exception e2) {}
		} // try-catch
		// ArrayList products 출력
		if(products.isEmpty()) {
			System.out.println("입력된 재고량이 없습니다");
		}else {
			for(Product product :products) {
				System.out.println(product);
			}
			System.out.println("이상 물품 " + products.size() +"가지 입력됨");
		}
	}
}













