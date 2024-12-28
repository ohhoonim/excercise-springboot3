package dev.ohhoonim.jdbc_query_dsl.component.response;

public sealed interface Response  {

    public record Success (
        ResponseCode code,
        Object data
    ) implements Response { }

    public record Fail (
        ResponseCode code,
        String message,
        Object data
    ) implements Response { }
}
