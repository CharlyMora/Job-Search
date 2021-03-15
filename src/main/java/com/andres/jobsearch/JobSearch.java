package com.andres.jobsearch;

import com.andres.jobsearch.api.APIJobs;
import com.andres.jobsearch.cli.CLIArguments;
import com.andres.jobsearch.cli.CLIFunctions;
import com.beust.jcommander.JCommander;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.andres.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.andres.jobsearch.CommanderFunctions.parseArguments;
import static com.andres.jobsearch.api.APIFunctions.buildAPI;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello job search");
        JCommander jCommander= buildCommanderWithName("job-search", CLIArguments::newInstance);
        Stream<CLIArguments> stramOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                stramOfCLI.filter(cli->!cli.isHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }
    private  static Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com");

        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
