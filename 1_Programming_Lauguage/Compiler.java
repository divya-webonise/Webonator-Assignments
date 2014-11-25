import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Compiler {
	public static void main(String args[]) throws IOException 
	{
		int i=1,j=1,k=1,flag_i=0;
		//class pattern for all languages///
		Pattern classpattern = Pattern.compile("^s*([(public|private|protected)\\s+]*)class[\\s|\\t|\\n]+([a-zA-z_]+\\w+)[\\s|\\t|\\n]*.*");
		//variable pattern for java language//
		Pattern javavariablepattern= Pattern.compile("^s*([(public|private|protected)\\s+]*)(String|Double|Long|double|long|int|boolean|int|float)+[\\s|\\t|\\n]+([a-zA-Z_]+\\w*)[\\s|\\t|\\n]*[;|=]+.*");
		//function pattern for java//
		Pattern javafunctionpattern = Pattern.compile("\\w+ +(\\w+) *\\(.*\\) *\\{");
		//syntax patterns for java
		Pattern javasyntaxpattern= Pattern.compile("^[\\s|\\t|\\n]*import.java.*");
		Pattern javasyntaxpattern2= Pattern.compile("^[\\s|\\t|\\n]*public[\\s|\\t|\\n]+static[\\s|\\t|\\n]+void[\\s|\\t|\\n]+main[\\s|\\t|\\n]+[\\(]String[\\s]+args[\\[][\\]][\\)].*");
		try
		{
			// For each line of input, try matching in it.//
			String filename;
			Scanner user = new Scanner(System.in);
			System.out.print("Enter file:");
			//name of file which user have entered//
			filename = user.nextLine();
			//reading file entered by user//
			BufferedReader b=new BufferedReader(new FileReader(filename));
			String line;
			while ((line=b.readLine())!= null){
				// For each match in the line from file, extract the matched variable//
				Matcher javavariablematcher = javavariablepattern.matcher(line);
				Matcher classmatcher = classpattern.matcher(line);
				Matcher javafunctionmatcher = javafunctionpattern.matcher(line);
				Matcher javasyntaxmatcher = javasyntaxpattern.matcher(line);
				Matcher javasyntaxmatcher1 = javasyntaxpattern2.matcher(line);
				//loop for finding the name of class//
				while (classmatcher.find())
				{
					System.out.println("CLASS"+i+":"+classmatcher.group(2));
					i++;
				}
				//loop for finding the function name of functions in java code //
				while (javafunctionmatcher.find())
				{
					System.out.println("function:"+j+" : "+javafunctionmatcher.group(1));
					j++;
				}
				//loop for finding name of variables in the java code//
				while (javavariablematcher.find())
				{
					System.out.println("variables:"+k+" : "+javavariablematcher.group(3));
					k++;
				}
				//loop for matching java variables,java functions and java syntaxes //
				if (javafunctionmatcher.matches()|javasyntaxmatcher.matches()|javasyntaxmatcher1.matches()|javavariablematcher.matches())
				{
					flag_i++;
				}
			}
			//if match found then language is java//
			if (flag_i>0)
			{
				System.out.println("The code of java language");
			}
			//if match not found language is not  java//
			else
			{
				System.out.println("not a java language");
			}
		}
		catch (Exception e)
		{
			System.out.println("caught");  
		}
	}

}
