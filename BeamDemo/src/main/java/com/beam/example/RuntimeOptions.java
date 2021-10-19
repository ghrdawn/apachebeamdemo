package com.beam.example;

import org.apache.beam.runners.spark.SparkPipelineOptions;

public interface RuntimeOptions extends SparkPipelineOptions {
	void setInputFile(String fileName);
	String getInputFile();
	
	void setOutputFile(String fileName);
	String getOutputFile();
	
	void setExtn(String extn);
	String getExtn();
}
