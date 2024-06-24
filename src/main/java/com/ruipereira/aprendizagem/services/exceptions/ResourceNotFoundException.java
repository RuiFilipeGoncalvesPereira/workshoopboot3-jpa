package com.ruipereira.aprendizagem.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1705473482231861638L;
	
	public ResourceNotFoundException(Object id)
	{
		super("Resource not found .Id " +  id);
	}
	

}
