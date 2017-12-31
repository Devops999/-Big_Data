

	import java.io.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
//import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;



	public class MyPartitioner extends Configured implements Tool {
	
		
		public static class MapClass extends Mapper<LongWritable,Text,Text,Text>
		   {
		      public void map(LongWritable key, Text value, Context context)
		      {	    	  
		         try{
		            String[] str = value.toString().split(",");	
		            String gender=str[3];
		            //long vol = Long.parseLong(str[7]);
		            context.write(new Text(gender),new Text(value));
		         }
		         catch(Exception e)
		         {
		            System.out.println(e.getMessage());
		         }
		      }
		   }
		
		
		 public static class ReduceClass extends Reducer<Text,Text,Text,IntWritable>
		   {
			 public int max=0;
			 private Text outputKey= new Text();
			 
			   
			    
			    public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
			      
			    	max=0;
					
			         for (Text val : values)
			         {   
			        	 String[] str=val.toString().split(",");
			        	 if(Integer.parseInt(str[4])>max)
			        	 {
			        		 max=Integer.parseInt(str[4]);
			        		 
			        		 
			        		 String mykey = str[3] + ',' + str[1] + ',' +str[2];
			        		 outputKey.set(mykey);
			        	 }
			             
			         }
			         
			           
			      context.write(outputKey, new IntWritable(max));
			      //context.write(key, new LongWritable(sum));
			      
			    }
		   }

			public static class CodePartitioner extends Partitioner <Text,Text>
			
			{
				//@Override
			
			
			
		 public int getPartition(Text key,Text value,int numReduceTasks)
			{
				String[] str=value.toString().split(",");
				int age=Integer.parseInt(str[2]);
				if(age<=20)
				{return 0 % numReduceTasks;
			}
				
				
				else if(age>20 && age<=30)
				{
					return 1 % numReduceTasks;
				}
				else{
					return 2 % numReduceTasks;
				}
		}

			



	}
	

		


	
		
	


	@Override
	public int run(String[] arg) throws Exception {
		// TODO Auto-generated method stub
		 Configuration conf = new Configuration();
		    //conf.set("name", "value")
		    //conf.set("mapreduce.input.fileinputformat.split.minsize", "134217728");
		    Job job = Job.getInstance(conf);
		    job.setJarByClass(MyPartitioner.class);
		    job.setJobName("Top salary employee");
		    job.setMapperClass(MapClass.class);
		    job.setReducerClass(ReduceClass.class);
		    job.setPartitionerClass(CodePartitioner.class);
		    //job.setCombinerClass(ReduceClass.class);
		   
		  
		    
		    job.setNumReduceTasks(3);
		    job.setOutputKeyClass(Text.class);
		    job.setOutputValueClass(Text.class);
		    FileInputFormat.addInputPath(job, new Path(arg[0]));
		    FileOutputFormat.setOutputPath(job, new Path(arg[1]));
		    
		    
		    System.exit(job.waitForCompletion(true) ? 0 : 1);
		return 0;
	}
	public static void main(String args[]) throws Exception{
		ToolRunner.run(new Configuration(), new MyPartitioner(),args);
		System.exit(0);
	}
	}
	
	