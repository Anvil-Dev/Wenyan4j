package dev.anvilcraft.base.wenyan.runtime;

import dev.anvilcraft.base.wenyan.parser.wenyanParser;

import java.util.List;

public record WenyanFunction(List<String> parameterNames,
                             List<wenyanParser.StatementContext> body,
                             Environment closure) {
}

