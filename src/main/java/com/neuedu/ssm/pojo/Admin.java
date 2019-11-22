package com.neuedu.ssm.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8371503778422796276L;
	private Integer id;
	private String aname;
	private String apwd;
}
