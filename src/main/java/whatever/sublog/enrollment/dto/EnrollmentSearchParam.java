package whatever.sublog.enrollment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EnrollmentSearchParam {

    private Integer page;

    private Integer size;

    public EnrollmentSearchParam(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}
