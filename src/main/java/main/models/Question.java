package main.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = Examination.class)
    @NotNull(message = "Câu hỏi phải nằm trong bài kiểm tra")
    private Examination examination;

    @Column(nullable = false)
    @NotNull(message = "Cần phải có đề bài")
    private String description;
    @Column(length = 500)
    @NotNull
    private String answer;  // split by &&&
    @Max(value = 3, message = "Không có đáp án nào như vậy")
    @NotNull(message = "Câu hỏi cần có câu trả lời đúng")
    private Integer correctAnswer;
}
