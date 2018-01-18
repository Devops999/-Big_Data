package com.niit;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Query8Mapper1 extends Mapper < LongWritable, Text, Text, Text > {
	//LongWritable one = new LongWritable(1);
    public void map(LongWritable key, Text value, Context context) throws IOException,
    InterruptedException {
       // if (key.get() > 0)

        {
        	String [] token = value.toString().split("\t");
        	
        	String case_status = token[1];
        	String year = token[7];
        	String job_title = token[4];
        	String full_time_position = token[5];
        	String prevailing_wage = token[6];
        	String mySearchText = context.getConfiguration().get("myText");

			if(mySearchText.equals("ALL"))
			{
           if(full_time_position.equals("Y"))
           {
        	   if(case_status.equals("CERTIFIED") || case_status.equals("CERTIFIED-WITHDRAWN"))
        	   {
        		   String myvalue = year +"\t" + prevailing_wage;
        		   context.write(new Text(job_title), new Text(myvalue));
        		   }
        	   }
			}
           
           
        	   else
   			{
   				if(full_time_position.equals("N") && year.equals(mySearchText))
           
        	  // if(case_status.equals("CERTIFIED") || case_status.equals("CERTIFIED-WITHDRAWN"))
        	   {
        		   String myvalue = year +"\t" + prevailing_wage;
        		   context.write(new Text(job_title), new Text(myvalue));
        		   }
        	   }
			}
        }
    }

            
           
               
           



