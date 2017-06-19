import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SEDMMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	IntWritable one=new IntWritable(1);
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String line=value.toString().replaceAll("Hadoop","111111111111");
		context.write(new Text(line), NullWritable.get());
	}

	
}
