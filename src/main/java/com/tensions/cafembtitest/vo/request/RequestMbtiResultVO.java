package com.tensions.cafembtitest.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestMbtiResultVO {
    @JsonProperty("E") private int E;
    @JsonProperty("I") private int I;
    @JsonProperty("N") private int N;
    @JsonProperty("S") private int S;
    @JsonProperty("T") private int T;
    @JsonProperty("F") private int F;
    @JsonProperty("P") private int P;
    @JsonProperty("J") private int J;
}
