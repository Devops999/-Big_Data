
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapred.FileInputFormat;
//import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class Speed{

public class MapClass extends Mapper<LongWritable, Text, Text, IntWritable> {
	
		

	
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		try {
			String[] record = value.toString().split(",");
			
			String vehicleNo = record[0];
			int speed = Integer.parseInt(record[1]);
			
			context.write(new Text(vehicleNo), new IntWritable(speed));
			
		} catch (IndexOutOfBoundsException e) {
		} catch (ArithmeticException e1) {
			//System.out.println(e.getMessage():
			
		}
	}
}

public class ReduceClass extends Reducer<Text, IntWritable, NullWritable, Text> {
	
	
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		//float maxPercentValue=0;
		//float temp_val=0;
		int   offence=0;
		int vehicleVisited=0;
		String result=null;
		
		
		for (IntWritable value : values) {
			vehicleVisited++;
			//sum += value.get();
			if (value.get() > 65) {
				
				offence++;
			
			}
		}
		 result="vehcile Number is"+key+"Visited "+vehicleVisited+"times visited"+(vehicleVisited/offence)*100 +"%";
		
	
	context.write(null, new Text (result));

			}
}



	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.out
					.printf("Usage: Offence <input dir> <output dir>\n");
			System.exit(-1);
		}

		
		Configuration conf = new Configuration();
		//conf.set("","")
		Job job = Job.getInstance(conf, "NYSE_Computation");

		job.setJarByClass(Speed.class);
		job.setJobName("Offence _Check");

		//job.setJobName("NYSE Stock");

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(MapClass.class);
		//job.setCombinerClass(NYSEReducer.class);
		job.setReducerClass(ReduceClass.class);
		job.setNumReduceTasks(1);
		
		//job.setOutputKeyClass(NullWritable.class);
		//job.setOutputValueClass(Text.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}
}