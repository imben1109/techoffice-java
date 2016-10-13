# Spring Batch Example

Console Output
```
SimpleItemReader read: 1
SimpleProcessor input: 1
SimpleProcessor input: Processed 1
SimpleItemWriter write: Processed 1
SimpleItemReader read: 2
SimpleProcessor input: 2
SimpleProcessor input: Processed 2
SimpleItemWriter write: Processed 2
SimpleItemReader read: 3
SimpleProcessor input: 3
SimpleProcessor input: Processed 3
SimpleItemWriter write: Processed 3
```

## Job Config

beans.xml
```
	<bean id="simpleItemReader" class="com.ittechoffice.example.batch.SimpleItemReader" />
	<bean id="simpleItemWriter" class="com.ittechoffice.example.batch.SimpleItemWriter" />
	<bean id="simpleItemProcessor" class="com.ittechoffice.example.batch.SimpleProcessor" />

	<!-- Job Definition -->
	<batch:job id="reportJob">
		<batch:step id="step1">
			<batch:tasklet>
				<batch:chunk reader="simpleItemReader" writer="simpleItemWriter"
					processor="simpleItemProcessor" commit-interval="1">
				</batch:chunk>
			</batch:tasklet>
		</batch:step>
	</batch:job>
```

## ItemReader

SimpleItemReader.java
```
public class SimpleItemReader implements ItemReader<String>{

	private List<String> items;
	
	public SimpleItemReader(){
		items = new ArrayList<String>();
		items.add("1");
		items.add("2");
		items.add("3");
	}
	
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (!items.isEmpty()){
			String item = items.remove(0);
			System.out.println("SimpleItemReader read: " + item);
			return item;	
		}
		return null;
	}

}
```

## ItemProcessor

SimpleProcessor.java
```
public class SimpleProcessor implements ItemProcessor<String, String>{

	public String process(String item) throws Exception {
		String input = item;
		String output = "Processed " + input;
		System.out.println("SimpleProcessor input: " + input);
		System.out.println("SimpleProcessor input: " + output);
		return output;
	}

}
```

## ItemWriter

SimpleItemWriter.java
```
public class SimpleItemWriter implements ItemWriter<String>{

	public void write(List<? extends String> items) throws Exception {
		for (String item: items){
			System.out.println("SimpleItemWriter write: " + item);
		}
	}

}
```
