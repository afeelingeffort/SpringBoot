package ch02;

public class Button {

	private IButtonListener iButtonListener;

	public Button() {
	}

	// setter 만들기
	public void setIButtonListener(IButtonListener iButtonListener) {
		this.iButtonListener = iButtonListener;
	}
	
	public void click(String message) {
		if(iButtonListener != null) {
			this.iButtonListener.clickEvent(message);
		}
	}
}
