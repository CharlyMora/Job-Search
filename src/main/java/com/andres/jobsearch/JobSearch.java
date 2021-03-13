package com.andres.jobsearch;

import com.andres.jobsearch.cli.CLIArguments;
import com.beust.jcommander.JCommander;

import static com.andres.jobsearch.CommanderFunctions.buildCommanderWithName;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello job search");
        JCommander jCommander= buildCommanderWithName("job-search", CLIArguments::newInstance);
    }
}
