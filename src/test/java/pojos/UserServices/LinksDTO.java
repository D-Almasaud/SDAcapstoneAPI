package pojos.UserServices;

import java.io.Serializable;

public class LinksDTO implements Serializable {
	private Object first;
	private Object previous;
	private String current;
	private String next;
	private String last;

	public void setFirst(Object first){
		this.first = first;
	}

	public Object getFirst(){
		return first;
	}

	public void setPrevious(Object previous){
		this.previous = previous;
	}

	public Object getPrevious(){
		return previous;
	}

	public void setCurrent(String current){
		this.current = current;
	}

	public String getCurrent(){
		return current;
	}

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setLast(String last){
		this.last = last;
	}

	public String getLast(){
		return last;
	}

	@Override
 	public String toString(){
		return 
			"LinksDTO{" + 
			"first = '" + first + '\'' + 
			",previous = '" + previous + '\'' + 
			",current = '" + current + '\'' + 
			",next = '" + next + '\'' + 
			",last = '" + last + '\'' + 
			"}";
		}
}