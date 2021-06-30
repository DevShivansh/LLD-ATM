package app.model.dto;

public class Response<T> {

	public T res;
	
	public Response() {
		res = null;
	}

	public Response(T res) {
		super();
		this.res = res;
	}
	
	
}
