package whatever.sublog.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EnrollmentSearchParam {

    @Schema(description = "페이지 위치")
    private Integer page;

    @Schema(description = "한번에 가져올 크기")
    private Integer size;

    public EnrollmentSearchParam(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}
