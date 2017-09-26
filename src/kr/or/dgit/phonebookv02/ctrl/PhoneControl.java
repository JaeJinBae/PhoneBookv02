package kr.or.dgit.phonebookv02.ctrl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import kr.or.dgit.phonebookv02.dto.Phone;

public class PhoneControl {
	public static Map<String, Phone> phoneBook;

	public PhoneControl() {
		phoneBook = new HashMap<>();
		phoneBook.put("홍길동", new Phone("홍길동", "대구", "010-1111-1111"));
		phoneBook.put("김태희", new Phone("김태희", "서울", "010-2222-2222"));
		phoneBook.put("태연", new Phone("태연", "부산", "010-3333-3333"));
		
		
	}

	@Override
	public String toString() {
		return String.format("%s", phoneBook);
	}
	
	public boolean insertPhone(Phone newPhone){
		if (isExist(newPhone)){
			JOptionPane.showMessageDialog(null, "?���? 존재?��?�� ?��?��번호?��?��?��.");
			return false;
		}
		phoneBook.put(newPhone.getName(), newPhone);
		return true;
	}
	
	public boolean isExist(Phone newPhone){
		return phoneBook.containsKey(newPhone.getName());
	}

	public void deletePhone(Phone delPhone) {
		if (!isExist(delPhone)){
			JOptionPane.showMessageDialog(null, delPhone.getName() + "?��록되�? ?��?? ?��?��?��?��?��.");
			return;
		}
		phoneBook.remove(delPhone.getName());
	}

	public Phone searchPhone(Phone searchPhone) {
		if (!isExist(searchPhone)){
			JOptionPane.showMessageDialog(null, searchPhone.getName() + "?��록되�? ?��?? ?��?��?��?��?��.");
			return null;
		}
		return phoneBook.get(searchPhone.getName());
				
	}

	public Object[][] showPhones() {
		Object[][] datas=new Object[phoneBook.size()][];
		
		int i=0;
		for(Entry<String, Phone> e:phoneBook.entrySet()){
			Object[] arr=new Object[4];//"번호, 이름, 주소, 연락처"
			arr[0]=i+1;					//번호, "","",""
			Object[] phoneArr = e.getValue().toArray();//"홍길동, 대구, 010~~"
			System.arraycopy(phoneArr, 0, arr, 1, phoneArr.length);
			datas[i]=arr;
			
			i++;
		}
		return datas;
		
	}

	public Map<String, Phone> getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(Map<String, Phone> phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	/* 1. ?��?�� insertPhone()
	 * 2. ?��?�� deletePhone()
	 * 3. 찾기 searchPhone()
	 * 4. ?��체보�? showPhones()
	 * */
}
