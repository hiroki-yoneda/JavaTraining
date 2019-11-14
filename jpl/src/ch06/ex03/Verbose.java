package jpl.ch06.ex03;

interface Verbose {
	enum VerboseEnum{
		SILENT,
		TERSE,
		NORMAL,
		VERBOSE,
	}

	void setVerbosity(VerboseEnum level);
	int getVerbosity();
}
