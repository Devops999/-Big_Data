package com.niit;

import java.io.IOException;
import java.util.TreeMap;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class Query6Reducer extends Reducer < Text, Text, Text, Text > {
    
   double denied =0.0;
   double certified=0.0;
   double withdrawn=0.0;
   double certified_withdrawn=0.0;
   double perDenied;
   double perCertified;
   double perWithdrawn;
   double perCert_Withdrawn;
   double total;
   int count =0;
   
    long sum = 0;
    String case_status ="";
    public void reduce(Text key, Iterable < Text > values, Context context) throws IOException,
    InterruptedException {
        //sum = 0;
        for (Text val: values) {
        	case_status= val.toString();
        	total++;
        
        if ( case_status.equals("DENIED"))
        {
        	denied++;
        }
        if ( case_status.equals("CERTIFIED"))
        {
        	certified++;
        }
       if (case_status.equals("WITHDRAWN"))
        {
        	withdrawn++;
        }
       if(case_status.equals("CERTIFIED-WITHDRAWN"))
        {
        	certified_withdrawn++;
        }
        }
        perDenied = ( denied*100)/total;
        perCertified =(certified*100)/total;
        perWithdrawn = (withdrawn*100)/total;
        
        perCert_Withdrawn=(withdrawn*100)/total;
        
       // String keys = key.toString();
        String ans =  String.format(perDenied + "," + perCertified + "," + perWithdrawn + "," +  perCert_Withdrawn);
        
        context.write(key, new Text(ans));
        
        }
        	
}
