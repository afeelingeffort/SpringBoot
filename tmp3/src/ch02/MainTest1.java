package ch02;

public class MainTest1 {

	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setIButtonListener(new IButtonListener() {
			@Override
			public void clickEvent(String event) {
				System.out.println("콜백 ㅎㅇ" + event);
			}
		});
		
		btn.click("asdefsfdafsda");
		btn.click("ASFDSFDAFSD");
	}

}
