package whatever.sublog.enrollment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnrollmentSearchParam {

    private Integer page;

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
