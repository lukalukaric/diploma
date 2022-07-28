package diploma.lukaric.backend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestResponse {
    private int status;
    private String info;
    private ArrayList<ResponseModel> data;

    private String answer;
}
