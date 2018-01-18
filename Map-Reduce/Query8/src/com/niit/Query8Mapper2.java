package com.niit;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
//import org.w3c.dom.Text;

public class Query8Mapper2 extends Mapper<LongWritable ,Text,DoubleWritable,Text>
	{
	protected void map(LongWritable Key,Text value,Context context) throws IOException, InterruptedException{
		String [] token = value.toString().split("\t");
		
		String job_title = token[0];
		String year = token[1];
		
		double average_prevailing_wage = Double.parseDouble(token[2]);
		String myVal = year + "\t" + job_title;
		context.write(new DoubleWritable(average_prevailing_wage), new Text(myVal));
		
	}
	}



