package org.hao.homedepot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HomeDepotException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String exceptionMsg;
	
}
