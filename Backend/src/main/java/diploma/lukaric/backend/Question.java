package diploma.lukaric.backend;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Question {
    private String id;
    private String question;
    private String answer;

    private String type;
}
