/**
 * 
 */
package com.ondemand.business.service.util;


import org.modelmapper.ModelMapper;

public final class ModelMapperUtil {
	
	public static Object map(Object source, Class<?> destinationType)
	{
		ModelMapper modelMapper = new ModelMapper();
		Object destination = modelMapper.map(source, destinationType);
		return destination;
	}
	

	
}
