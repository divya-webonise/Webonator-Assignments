#include<iostream>
#include<stdio.h>
#include<fstream>
#include<regex.hpp>
#include<string.h>

using namespace std;

class Compiler
{
    public:    
    string file;
    ifstream infile;       
	cout << "\n Enter File Name: ";
	cin >> file;
	infile.open(file);
	
	        if (!infile) 
		{
	            cout << "\n\n Unable To Open Your File.\n";
        	    exit(0);
        	} 
		else 
		{
	            cout << "\n\n your " << file << " file is opened !!\n\n";
	        }
	

  	string checker() 
	{
		string line;
        
     //regex for  java   
    	boost::regex regexJava("[\\s]*(public|private|protected)*[\\s]+]*class[\\s]+[\\w]+([\\s]|[\\t]|[\\n])*\\z");
        boost::regex regexJava1("[\\s]*import[\\s]+java[.]\\z");
        
        //regex for php
        boost::regex regexPhp("\\s*\\$.*");
        boost::regex regexPhp1("[\\s]*[<?php]+([\\s]|[\\t]|[\\n])*)|(([var]+[\\s]+[\\w])+)|([function]+[\\s]+[\\w]+)\\z");
        
        //regex for ruby
        boost::regex regexRuby("\\s*[def]+\\s+\\z|\\s*[@@]+\\s*\\z"); 
        
        //removing multilinecomments,Comments from the Code.
	        while (!file.eof()) 										
		{
		        boost::regex regexOneLineComment("^\\s*#.*|^\\s*//.*");
                	boost::regex regexMultiLineCommentStart("^\\s*/\\*.*"); 
		        boost::regex regexMultiLineCommentEnd(".*(\\*/\\s*).*");
		        
		
		        getline(file, line);
	`
			if (!boost::regex_match(line, regexOneLineComment)) 
			{
	                	if (boost::regex_match(line, regexMultiLineCommentStart)) 
				{
	                	    	while (!boost::regex_match(line,regexMultiLineCommentEnd))
		                        	getline(file, line);
	                	} 
				else
				{
					cout<<line<<endl;
                    
    				 if(boost::regex_match(line, regexJava)||boost::regex_match(line, regexJava1))
					{
        	    				cout << " This is JAVA code \n";
        	    				return "java";			
					}		
	 	        	
					else if ((boost::regex_match(line, regexPhp)||boost::regex_match(line,regexPhp1)) 
					{
        	    				cout << " This is PHP code \n";
        	    				return "php";
					}
					else if (boost::regex_match(line, regexRuby)) 
					{
       	  					cout << " This is RUBY code \n";
      	    					return "ruby";
       					}
  		      	}
		}
		cout << " This is a wrong code \n";
        	return "\0";		
	}
};


class compiler_demo: public Compiler
{
	
	public:
	
	void compile()
	{
		while(!file.eof())											
  		{	
			string line ;
			boost::regex regexMultiLineCommentStart("^\\s*/\\*.*"); 
			boost::regex regexMultiLineCommentEnd(".*(\\*/\\s*).*");
			boost::regex regexOneLineComment("^\\s*#.*|^\\s*//.*");
		
			getline(file, line);
		
			if (!boost::regex_match(line, regexOneLineComment)) 
			{
		                if (boost::regex_match(line, regexMultiLineCommentStart)) 
				{
		               	    	while (!boost::regex_match(line,regexMultiLineCommentEnd))
			                       	getline(file, line);
		               	}
                           
                            //checking classes
				else
				{
					boost::regex regexClass("^\\s*class\\s+[a-zA-Z]+[0-9A-Za-z]*[\\s|\\t|\]*"); 	
                    //checking classes. 
	    				if (boost::regex_match(line,regexClass))						
					{
						cout<<" Class : ";
		    				cout<<"  "<<line.substr(6,(line.substr(6,line.length())).find_first_of(' ',1))<<endl;
					}
				            //checking variables.
                            
					boost::regex regexVar("^\\s*var\\s\\$[a-zA-Z0-9_](\\s+|;|\\=|\\+|\\*)"); 
                    boost::regex regexVar1("^[\\s|\\W|\\w]*(int|long|double|char|float|boolean|byte|Long|Integer|Character|Double)(\\s+)(\\w+)(\\s+|;|\\=|\\+|\\*)"); 
					if (boost::regex_match(line,regexVar)) 							
					{		
                            cout<<" Variable : ";
		    				cout<<"  "<<line.substr(line.find_first_of('$',1),(line.find_first_of(' ',line.find_first_of('$',1)+1)-line.find_first_of	('$',1)))<<endl;
                        cout<<line;
					}
					
                    //checking functions
					boost::regex regexFun("^(\\s|\\t)*function\\s[a-zA-Z]+[a-zA-Z0-9_](\\s+|\\()");
					if (boost::regex_match(line,regexFun)) 											
					{
						cout<<" Function : ";
		    				cout<<"  "<<line.substr(line.find_first_of('o',1)+2,(line.find_first_of('(',1)-(line.find_first_of('o',1)+2)))<<endl;
                            cout<<line;
					}
				}
			
   			}
		}
	}
};


int main() 
{
 	
 	string language;
	language = compiler.checker();
 
	if((language.compare("php")|(language.compare("java")|(language.compare("ruby"))
	{
		compilerdemo code;
		code.compile();
	}
    	return 0;
}
