package whatever.sublog.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnrollmentSearchParam {

    @Schema(description = "페이지 위치")
    private Integer page;

    @Schema(description = "한번에 가져올 크기")
    private Integer size;

    public EnrollmentSearchParam(Integer page, Integer size) {
        if (page == null) {
            this.page = 0;
        }
        else {
            this.page = page;
        }
        if (size == null) {
            this.size = 2;
        }
        else {
            this.size = size;
        }
    }
}
