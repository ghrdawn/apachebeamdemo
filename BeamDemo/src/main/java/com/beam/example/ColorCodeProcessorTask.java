package com.beam.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.beam.runners.spark.SparkRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.extensions.jackson.ParseJsons;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

import com.google.gson.Gson;

public class ColorCodeProcessorTask {
	static class ValueConverter extends DoFn<ColorCodes, String> {
		private static final long serialVersionUID = -4595273832143963634L;

		@ProcessElement
		public void processElement(ProcessContext c) {
			List<Colors> colors = new ArrayList<Colors>();
			ColorCodes element = c.element();
			List<ColorCode> colorCodes = element.getColors();
			for (ColorCode colorCode : colorCodes) {
				Colors color = new Colors();
				color.setColor(colorCode.getColor());
				colors.add(color);
			}

			Gson gson = new Gson();
			String json = gson.toJson(colors);
			c.output(json);
		}
	}

	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "C:\\hadoop_home\\");

		RuntimeOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(RuntimeOptions.class);
		options.setRunner(SparkRunner.class);
		options.setJobName("testColorCodeProcessing");
		options.setInputFile("input/color-code.json");
		options.setOutputFile("output/color-code-output");
		options.setExtn(".json");
		Pipeline pipeline = Pipeline.create(options);

		PCollection<String> colorData = pipeline.apply(TextIO.read().from(options.getInputFile()));

		PCollection<ColorCodes> colorcodes = colorData.apply(ParseJsons.of(ColorCodes.class))
				.setCoder(SerializableCoder.of(ColorCodes.class));

		PCollection<String> outputData = colorcodes.apply(ParDo.of(new ValueConverter()));

		outputData.apply(TextIO.write().to(options.getOutputFile()).withoutSharding().withSuffix(options.getExtn()));

		pipeline.run();

		//This is a hack to keep the Spark UI available after job is finished
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}
