package com.training.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Training implements Serializable{
	private long trainingId;
	private String trainingType;
	private String module;

}
