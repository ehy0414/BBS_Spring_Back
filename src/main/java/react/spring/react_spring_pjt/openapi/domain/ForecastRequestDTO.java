package react.spring.react_spring_pjt.openapi.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ForecastRequestDTO {
    // validation annotation
    // NotNull, NotEmpty, NotBlank, Past, PastOrPresent, Email, Pattern Regular Expression(정규표현식) etc...

    @NotBlank(message = "시간을 입력하세요")
    private String base_time;
    @NotBlank(message = "날짜를 입력하세요")
    private String base_date;
    @NotBlank(message = "검색을 원하시는 해변코드를 입력하세요")
    private String beach_num;
}
