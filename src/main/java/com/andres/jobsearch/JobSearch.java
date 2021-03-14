package com.andres.jobsearch;

import com.andres.jobsearch.cli.CLIArguments;
import com.beust.jcommander.JCommander;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static com.andres.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.andres.jobsearch.CommanderFunctions.parseArguments;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello job search");
        JCommander jCommander= buildCommanderWithName("job-search", CLIArguments::newInstance);
        Stream<CLIArguments> stramOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList());
    }
}
