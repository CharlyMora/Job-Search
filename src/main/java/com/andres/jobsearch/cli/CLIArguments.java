package com.andres.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    CLIArguments(){}

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD",
            validateWith = CLIKeyWordValidator.class)
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "Ciudad, codigo postal o algun otro termino para buscar una ubicacion")
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "Cada busqueda contiene 50 posiciones, puedes paginar mas resultados cambiando el numero, la paginacion empieza en 0")
    private int page =0;

    @Parameter(
            names = "--full-time",
            description = "Agregar esta bandera si se desea unicamente listar trabajos de 'full time'"
    )
    private boolean isFullTime = false;

    @Parameter(
            names = "--markdown",
            description = "Agregar esta bandera si se desea obtener los resultados en markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            //validateWith = CLIHelpValidator.class,
            description = "Muestra esta ayuda")
    private boolean isHelp;

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public  static CLIArguments newInstance(){
        return new CLIArguments();
    }
}
