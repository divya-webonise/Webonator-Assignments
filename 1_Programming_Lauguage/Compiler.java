import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Compiler {
	private static BufferedReader b;

	public static void main(String args[]) throws IOException 
	{
		int class_variable=1,java_function=1,java_variable=1,flag_i=0,ruby_variable=1,ruby_function=1,flag_j=0,php_variable=1,php_function=1,flag_k=0;
		//class pattern for all languages///
		Pattern class_pattern = Pattern.compile("^s*([(public|private|protected)\\s+]*)class[\\s|\\t|\\n]+([a-zA-z_]+\\w+)[\\s|\\t|\\n]*.*");
		//variable pattern for java language//
		Pattern java_variable_pattern= Pattern.compile("^s*([(public|private|protected)\\s+]*)(String|Double|Long|double|long|int|boolean|int|float)+[\\s|\\t|\\n]+([a-zA-Z_]+\\w*)[\\s|\\t|\\n]*[;|=]+.*");
		//function pattern for java//
		Pattern java_function_pattern = Pattern.compile("^s*([(public|private|protected)\\s+]*)(String|Double|Long|double|long|int|boolean|int|float|void)+[\\s|\\t|\\n]+([a-zA-Z_]+\\w*)[\\s|\\t|\\n]*[\\(]+.*");
		//syntax patterns for java
		Pattern java_syntax_pattern= Pattern.compile("^[\\s|\\t|\\n]*import.java.*");
		Pattern java_syntax_pattern2= Pattern.compile("^[\\s|\\t|\\n]*public[\\s|\\t|\\n]+static[\\s|\\t|\\n]+void[\\s|\\t|\\n]+main[\\s|\\t|\\n]+[\\(]String[\\s]+args[\\[][\\]][\\)].*");
		//variable  pattern for ruby
		Pattern ruby_variable_pattern = Pattern.compile("^[\\s|\\n|\\t]*(@@|@|$)+([a-zA-z_]+)[\\s|\\t|\\n]*[;|=]+.*");
		//function pattern for ruby
		Pattern ruby_function_pattern = Pattern.compile("^[\\s|\\n|\\t]*def[\\s|\\t|\\n]+([a-zA-Z_]+)[\\s|\\t|\\n]*[\\(]*.*");
		//variable  pattern for php//
		Pattern php_variable_pattern = Pattern.compile("^[\\s|\\t|\\n]*([(public|private|protected)[\\s|\\t|\\n]+]*)([(var)[\\s|\\t|\\n]+]*)[$]+([a-zA-Z_]+\\w*)[\\s|\\n|\\t]*[;|=]+.*");
		//function  pattern for php//
		Pattern php_function_pattern = Pattern.compile("^[\\s|\\t|\\n]*([(public|private|protected)[\\s|\\t|\\n]+]*)function[\\s|\\t|\\n]+([a-zA-z_]+\\w+)[\\s|\\t|\\n]*[\\(]+.*");
		//syntax pattern for php
		Pattern php_syntax_pattern= Pattern.compile("^[\\s|\\t|\\n]*[<?php]+.*");
		Pattern php_syntax_pattern2= Pattern.compile("^[\\s|\\t|\\n]*echo[\\s|\\t|\\n][$|\"]+.*");


		try
		{
			// For each line of input, try matching in it.//
			String filename;
			Scanner user = new Scanner(System.in);
			System.out.print("Enter file:");
			//name of file which user have entered//
			filename = user.nextLine();
			b = new BufferedReader(new FileReader(filename));
			String line;
			while ((line=b.readLine())!= null){
				// For each match in the line from file, extract the matched variable//
				Matcher java_variable_matcher = javavariablepattern.matcher(line);
				Matcher class_matcher = classpattern.matcher(line);
				Matcher java_function_matcher = javafunctionpattern.matcher(line);
				Matcher java_syntax_matcher = javasyntaxpattern.matcher(line);
				Matcher java_syntax_matcher1 = javasyntaxpattern2.matcher(line);
				Matcher	ruby_variable_matcher= rubyvariablepattern.matcher(line);
				Matcher	ruby_function_matcher= rubyfunctionpattern.matcher(line);
				Matcher	php_variable_matcher= phpvariablepattern.matcher(line);
				Matcher php_function_matcher = phpfunctionpattern.matcher(line);
				Matcher php_syntax_matcher = phpsyntaxpattern.matcher(line);
				Matcher php_syntax_matcher1 = phpsyntaxpattern2.matcher(line);


				//loop for finding the name of class//
				while (class_matcher.find())
				{
					System.out.println("\n CLASS"+class_variable+":"+class_matcher.group(2)+"\n");
					classvariable++;
				}
				//loop for finding the function name of functions in java code //
				while (java_function_matcher.find())
				{
					System.out.println("function"+java_function+" : "+java_function_matcher.group(3));
					java_function++;
				}
				//loop for finding name of variables in the java code//
				while (java_variable_matcher.find())
				{
					System.out.println("variables"+java_variable+" : "+java_variable_matcher.group(3));
					java_variable++;
				}
				//loop for finding the variables name of ruby//
				while (ruby_variable_matcher.find())
				{
					System.out.println("variables"+ruby_variable+" : "+ruby_variable_matcher.group(2));
					ruby_variable++;
				}
				//loop for finding the functions name of ruby//
				while (ruby_function_matcher.find())
				{
					System.out.println("method"+ruby_function+" : "+ruby_function_matcher.group(1));
					ruby_function++;
				}
				//loop for finding the variables name of php//
				while (php_variable_matcher.find())
				{
					System.out.println("variables"+php_variable+" : "+php_variable_matcher.group(3));
					php_variable++;
				}
				//loop for finding the functions name of php//
                                while (php_function_matcher.find())
				{
					System.out.println("function"+php_function+" : "+php_function_matcher.group(2));
					php_function++;
				}

			
				//loop for matching java variables,java functions and java syntaxes //
				if (java_function_matcher.matches()|java_syntax_matcher.matches()|java_syntax_matcher1.matches()|java_variable_matcher.matches())
				{
					flag_i++;
				}
				//loop for matching ruby variables,ruby functions and ruby syntaxes //
				else if(ruby_function_matcher.matches()|ruby_variable_matcher.matches())
				{
					flag_j++;
				}
				else if (php_syntax_matcher.matches()|php_syntax_matcher1.matches()|php_variable_matcher.matches())
				{
					flag_k++;
				}
				
				
					}
			//if java match found then language is java//
			if (flag_i>0)
			{
				System.out.println("\n\nIt is java language");
			}
			//if ruby match found language is ruby//
			if (flag_j>0)
			{
				System.out.println("\n\nIt is ruby language");
			}
			if (flag_k>0)
			{
				System.out.println("\n\nIt is php language");
			}
			}
		catch (Exception e)
		{
			System.out.println("caught");  
		}
	}

}
