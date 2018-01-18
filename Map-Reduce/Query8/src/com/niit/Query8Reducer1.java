package com.niit;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Query8Reducer1 extends Reducer<Text,Text,Text,DoubleWritable>
{
	protected void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException
	{
		long count =0;
		long totalOfEmp =0;
		String year = "";
		for (Text val:values)
		{
			String[] str = val.toString().split("\t");
			year = str[0];
			long  prevailing_wage = Long.parseLong(str[1]);
			count ++;
			totalOfEmp = totalOfEmp+prevailing_wage;
		}
		String job_title = key.toString();
		double average_prevailing_wage = totalOfEmp/count;
		String myKey = job_title + "\t" + year;
		context.write(new Text(myKey), new DoubleWritable(average_prevailing_wage));
			
			
		}
	}

