package helse;

public interface ObservableList {

	public void addListener(ListListener listener) ; 
	
	public void removeListener(ListListener listener) ; 
	
	public void fireListChanged(Patient patient); 

}
